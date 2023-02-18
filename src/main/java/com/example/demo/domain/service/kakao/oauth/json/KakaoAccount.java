package com.example.demo.domain.service.kakao.oauth.json;

import lombok.Data;

@Data
public class KakaoAccount {
    private Profile profile;
    private String email;
}
