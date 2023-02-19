package com.example.demo.web.controller.auth;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.jwt.JwtProvider;
import com.example.demo.domain.service.auth.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class KakaoAuthCallback {
    private final AuthService authService;
    @Value("${oauth.kakao.client_id}") private String clientId;
    @Value("${oauth.kakao.redirect_url}") private String redirect;

    @GetMapping("/auth/kakao")
    public HttpEntity<?> callback (@RequestParam String code, HttpServletResponse response) throws IOException {
        User login = authService.login(code).orElseThrow();

        if (!login.getPermissions().contains("friends")) {
            response.sendRedirect(
                    "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=" + clientId
                            + "&redirect_uri=" + redirect
                            + "&scope=friends");
        }

        return ResponseEntity.ok(JwtProvider.generate(login));
    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public HttpEntity<?> noSuchElementExceptionHandler (RuntimeException ex) {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//    }
}
