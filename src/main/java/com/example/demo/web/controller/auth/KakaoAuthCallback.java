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

    /**
     * 카카오 OAuth 처리 컨트롤러
     *
     * @param code      Authorization code 가 넘어옴
     * @param response  scope에 friend가 없을 시 추가동의 페이지로 리다이렉션 하기 위해 사용
     * @return : 성공적으로 로그인하면 JWT 토큰 반환
     * @throws IOException
     */
    @GetMapping("/auth/kakao")
    public HttpEntity<?> callback (@RequestParam String code, HttpServletResponse response) throws IOException {
        User login = authService.login(code).orElseThrow();
        
        if (!login.getPermissions().contains("friends")) { // 신규 등록이던 기존 로그인이던 friend 권한이 있는지 확인
            response.sendRedirect(
                    "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=" + clientId
                            + "&redirect_uri=" + redirect
                            + "&scope=friends"); // friend 권한이 없으면 추가동의페이지로 리다이렉트
        }

        return ResponseEntity.ok(JwtProvider.generate(login));
    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public HttpEntity<?> noSuchElementExceptionHandler (RuntimeException ex) {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//    }
}
