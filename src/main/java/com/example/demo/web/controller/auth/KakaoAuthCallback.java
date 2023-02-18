package com.example.demo.web.controller.auth;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.jwt.JwtProvider;
import com.example.demo.domain.service.auth.AuthService;
import com.example.demo.domain.service.kakao.KakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class KakaoAuthCallback {

    private final KakaoService kakaoService;
    private final AuthService authService;

    @GetMapping("/auth/kakao")
    public HttpEntity<?> callback (@RequestParam String code) {
        User login = authService.login(code).orElseThrow();
        return ResponseEntity.ok(JwtProvider.generate(login));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public HttpEntity<?> noSuchElementExceptionHandler (RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
