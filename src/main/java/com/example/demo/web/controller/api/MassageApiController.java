package com.example.demo.web.controller.api;

import com.example.demo.domain.dto.FriendDto;
import com.example.demo.domain.entity.Friend;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.FriendRepository;
import com.example.demo.domain.service.kakao.KakaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/message")
public class MassageApiController {
  private final KakaoService kakaoService;
  private final FriendRepository friendRepository;
  private final ModelMapper modelMapper;
  @GetMapping("/friend")
  public List<FriendDto> getFriendList(User user) {
    List<Friend> friendList = friendRepository.findByUserId(user.getId());
    List<FriendDto> result = modelMapper.map(friendList, new TypeToken<List<FriendDto>>() {}.getType());

    for (FriendDto friendDto : result) {
      System.out.println(friendDto);
    }

    return result;
  }


}
