package com.example.demo.domain.service.kakao.message;

import com.example.demo.domain.entity.Friend;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.service.kakao.message.json.SendMessageResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class KakaoMessageService {

    public void sendMessage (User who, List<Friend> receiver) throws RuntimeException {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://kapi.kakao.com/v1/api/talk/friends/message/default/send")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + who.getAccessToken())
                .build();

        webClient.post()
                .retrieve()
                .onStatus(status -> status.value() == HttpStatus.BAD_REQUEST.value() || status.value() == HttpStatus.UNAUTHORIZED.value(),
                        response -> Mono.error(RuntimeException::new))
                .bodyToMono(SendMessageResponse.class)
                .block();
    }
}
