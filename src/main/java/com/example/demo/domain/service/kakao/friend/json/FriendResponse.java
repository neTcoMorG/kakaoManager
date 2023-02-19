package com.example.demo.domain.service.kakao.friend.json;

import lombok.Data;

import java.util.List;

@Data
public class FriendResponse {
    private List<Friend> elements;
    private Integer total_count;
}
