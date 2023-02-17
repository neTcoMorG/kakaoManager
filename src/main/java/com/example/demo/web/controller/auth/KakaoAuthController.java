package com.example.demo.web.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KakaoAuthController {

    @GetMapping("/auth/kakao")
    public HttpEntity<?> callback (@RequestParam String code) {
        return ResponseEntity.ok("Hello,world");
    }
}
