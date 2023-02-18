package com.example.demo.domain.service.kakao.oauth.json;

import lombok.Data;

@Data
public class OauthToken {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private String scope;
    private int refresh_token_expires_in;
    private int expires_in;
}
