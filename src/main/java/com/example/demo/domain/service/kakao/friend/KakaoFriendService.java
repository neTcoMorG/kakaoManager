package com.example.demo.domain.service.kakao.friend;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.service.kakao.friend.json.FriendResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class KakaoFriendService {
    public FriendResponse getFriendsTest (User user, int start, int end) {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://kapi.kakao.com")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + user.getAccessToken())
                .build();

        return webClient.get()
                .uri("/v1/api/talk/friends")
                .retrieve()
                .bodyToMono(FriendResponse.class)
                .block();
    }
}
