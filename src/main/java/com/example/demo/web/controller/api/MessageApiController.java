package com.example.demo.web.controller.api;

import com.example.demo.domain.dto.FriendDto;
import com.example.demo.domain.service.kakao.message.json.feed.FeedObject;
import com.example.demo.domain.service.kakao.message.json.feed.SendMessageFeedParam;
import com.example.demo.domain.service.kakao.message.json.list.ListObject;
import com.example.demo.domain.service.kakao.message.json.list.SendMessageListParam;
import com.example.demo.domain.service.kakao.message.json.location.SendMessageLocationParam;
import com.example.demo.domain.service.kakao.message.json.text.SendMessageTextParam;
import com.example.demo.domain.entity.Friend;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.FriendRepository;
import com.example.demo.domain.service.kakao.KakaoService;
import com.example.demo.domain.service.kakao.message.KakaoMessageService;
import com.example.demo.domain.service.kakao.message.json.text.TextObject;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/message")
public class MessageApiController {
  private final KakaoService kakaoService;
  private final FriendRepository friendRepository;
  private final ModelMapper modelMapper;
  private final KakaoMessageService kakaoMessageService;

  @PostMapping("/send/text")
  public HttpEntity<?> sendTextMessage(User user, @RequestBody SendMessageTextParam sendMessageTextParam) {
    List<String> receiver = sendMessageTextParam.getReceiver();
    TextObject textObject = sendMessageTextParam.getTextObject();

    kakaoMessageService.sendMessage(user, receiver, textObject);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/send/feed")
  public HttpEntity<?> sendFeedMessage(User user, @RequestBody SendMessageFeedParam sendMessageFeedParam) {
    List<String> receiver = sendMessageFeedParam.getReceiver();
    FeedObject feedObject = sendMessageFeedParam.getFeedObject();

    kakaoMessageService.sendMessage(user, receiver, feedObject);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/send/list")
  public HttpEntity<?> sendListMessage(User user, @RequestBody SendMessageListParam sendMessageListParam) {
    List<String> receiver = sendMessageListParam.getReceiver();
    ListObject listObject = sendMessageListParam.getListObject();

    kakaoMessageService.sendMessage(user, receiver, listObject);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/send/location")
  public HttpEntity<?> sendLocationMessage(User user, @RequestBody SendMessageLocationParam sendMessageLocationParam) {
    List<String> receiver = sendMessageLocationParam.getReceiver();
    ListObject locationObject = sendMessageLocationParam.getListObject();

    kakaoMessageService.sendMessage(user, receiver, locationObject);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/friend")
  public List<FriendDto> getFriendList (User user) {
    List<Friend> friendList = friendRepository.findByUserId(user.getId());
    return modelMapper.map(friendList, new TypeToken<List<FriendDto>>() {}.getType());
  }
}
