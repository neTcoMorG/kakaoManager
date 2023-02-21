package com.example.demo.web.controller.api;

import com.example.demo.domain.dto.FriendDto;
import com.example.demo.domain.service.kakao.message.json.calendar.SendMessageCalendarParam;
import com.example.demo.domain.service.kakao.message.json.commerce.SendMessageCommerceParam;
import com.example.demo.domain.service.kakao.message.json.feed.SendMessageFeedParam;
import com.example.demo.domain.service.kakao.message.json.list.SendMessageListParam;
import com.example.demo.domain.service.kakao.message.json.location.SendMessageLocationParam;
import com.example.demo.domain.service.kakao.message.json.text.SendMessageTextParam;
import com.example.demo.domain.entity.Friend;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.FriendRepository;
import com.example.demo.domain.service.kakao.message.KakaoMessageService;
import jakarta.validation.Valid;
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
  private final ModelMapper modelMapper;
  private final KakaoMessageService kakaoMessageService;
  private final FriendRepository friendRepository;

  /**
   * sendMessageParam.groupId 에
   * 해당하는 모든 사람에게 메세지를 전송합니다.
   */
  @PostMapping("/send/feed")
  public HttpEntity<?> sendFeedMessage(User user, @RequestBody @Valid SendMessageFeedParam sendMessageFeedParam) {
    kakaoMessageService.sendMessage(user, sendMessageFeedParam, sendMessageFeedParam.getFeedObject(), "feed");
    return ResponseEntity.ok().build();
  }

  @PostMapping("/send/list")
  public HttpEntity<?> sendListMessage(User user, @RequestBody @Valid SendMessageListParam sendMessageListParam) {
    kakaoMessageService.sendMessage(user, sendMessageListParam, sendMessageListParam.getListObject(), "list");
    return ResponseEntity.ok().build();
  }

  @PostMapping("/send/location")
  public HttpEntity<?> sendLocationMessage(User user, @RequestBody @Valid SendMessageLocationParam sendMessageLocationParam) {
    kakaoMessageService.sendMessage(user, sendMessageLocationParam, sendMessageLocationParam.getLocationObject(),"location");
    return ResponseEntity.ok().build();
  }

  @PostMapping("/send/commerce")
  public HttpEntity<?> sendCommerceMessage(User user, @RequestBody @Valid SendMessageCommerceParam sendMessageCommerceParam) {
    kakaoMessageService.sendMessage(user, sendMessageCommerceParam, sendMessageCommerceParam.getCommerceObject(), "commerce");
    return ResponseEntity.ok().build();
  }

  @PostMapping("/send/text")
  public HttpEntity<?> sendTextMessage(User user, @RequestBody @Valid SendMessageTextParam sendMessageTextParam) {
    kakaoMessageService.sendMessage(user, sendMessageTextParam, sendMessageTextParam.getTextObject(), "text");
    return ResponseEntity.ok().build();
  }

  @PostMapping("/send/calendar")
  public HttpEntity<?> sendCalendarMessage(User user, @RequestBody @Valid SendMessageCalendarParam sendMessageCalendarParam) {
    kakaoMessageService.sendMessage(user, sendMessageCalendarParam, sendMessageCalendarParam.getCalendarObject(), "calendar");
    return ResponseEntity.ok().build();
  }

  @GetMapping("/friend")
  public List<FriendDto> getFriendList (User user) {
    List<Friend> friendList = friendRepository.findByUserId(user.getId());
    return modelMapper.map(friendList, new TypeToken<List<FriendDto>>() {}.getType());
  }


}
