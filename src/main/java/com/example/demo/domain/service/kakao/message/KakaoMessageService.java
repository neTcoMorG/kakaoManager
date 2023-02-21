package com.example.demo.domain.service.kakao.message;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.service.kakao.message.json.SendMessageRequest;
import com.example.demo.domain.service.kakao.message.json.SendMessageResponse;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KakaoMessageService {
  private static final int MAXIMUM_RECEIVER_PER_ONETIME = 5;
  private final Gson gson;

  /**
   * receiver 에게 message 전송.
   * 재사용을 위해 message 타입을 MessageObject 로 함.
   * 따라서 Controller 단에서 입력 값에 대한 검증이 반드시 필요.
   * @param receiver : 메세지 전송 대상의 uuid List
   * @param message : 전송할 메세지 내용.
   */
  public void sendMessage(User who, List<String> receiver, MessageObject message) throws RuntimeException {
    List<String> receiver_uuid = new ArrayList<>();
    for (int i = 0; i < receiver.size(); i++) {
      receiver_uuid.add(receiver.get(i));

      if (receiver_uuid.size() >= MAXIMUM_RECEIVER_PER_ONETIME || i == receiver.size() - 1) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest(gson.toJson(receiver_uuid), gson.toJson(message));
        messageSendApiCall(who, sendMessageRequest);
        receiver_uuid.clear();
      }
    }
  }


  private void messageSendApiCall (User who, SendMessageRequest sendMessageRequest) {

    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("receiver_uuids", sendMessageRequest.getReceiver_uuids());
    params.add("template_object", sendMessageRequest.getTemplate_object());

    WebClient webClient = WebClient.builder()
            .baseUrl("https://kapi.kakao.com/v1/api/talk/friends/message/default/send")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + who.getAccessToken())
            .build();

    webClient.post()
            .body(BodyInserters.fromValue(params))
            .retrieve()
            .onStatus(status -> status.value() == HttpStatus.BAD_REQUEST.value() || status.value() == HttpStatus.UNAUTHORIZED.value(),
                    response -> Mono.error(RuntimeException::new))
            .bodyToMono(SendMessageResponse.class)
            .block();
  }
}
