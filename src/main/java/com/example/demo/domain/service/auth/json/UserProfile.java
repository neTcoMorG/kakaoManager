package com.example.demo.domain.service.auth.json;

import com.example.demo.domain.service.auth.json.KakaoAccount;
import lombok.Data;

@Data
public class UserProfile {

    private String id;
    private KakaoAccount kakao_account;

}


