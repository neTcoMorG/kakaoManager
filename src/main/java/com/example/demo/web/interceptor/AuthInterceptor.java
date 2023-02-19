package com.example.demo.web.interceptor;

import com.example.demo.domain.jwt.JwtProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    /**
     * /auth/* 경로를 제외한 모든 Endpoint에 동작되는 인증 인터셉터
     *
     * @return true - 정상적인 인증 토큰을 받았을 때
     * @throws Exception 유효하지 않은 토큰이 넘어왔을 때
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        log.info("[AuthInterceptor-authHeader] " + authHeader);
        try { JwtProvider.parse(authHeader); }
        catch (Exception e) { 
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            log.info("[AuthInterceptor] invalid jwt token");
            return false;
        }
        return true;
    }
}
