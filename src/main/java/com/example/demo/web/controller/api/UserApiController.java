package com.example.demo.web.controller.api;

import com.example.demo.domain.dto.FriendDto;
import com.example.demo.domain.entity.Friend;
import com.example.demo.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    @GetMapping
    public ProfileDto getProfile (User user) {
        return new ProfileDto(user.getNickname(), user.getUuid(), user.getEmail(), user.getProfileImageUrl());
    }

    @GetMapping("/friend")
    public List<FriendDto> getFriends (User user) {
        List<FriendDto> friends = new ArrayList<>();
        user.getFriendList().forEach(friend -> friends.add(new FriendDto(
                friend.getNickname(), friend.getProfileImageUrl(), friend.getUuid())));
        return friends;
    }

    @Data
    @AllArgsConstructor
    static class ProfileDto {
        private String name;
        private String uuid;
        private String email;
        private String profileImageUrl;
    }
}
