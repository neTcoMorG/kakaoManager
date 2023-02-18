package com.example.demo.domain.service.auth.json;

import lombok.Data;

@Data
public class KakaoAccount {
    private Profile profile;
    private String email;
}
