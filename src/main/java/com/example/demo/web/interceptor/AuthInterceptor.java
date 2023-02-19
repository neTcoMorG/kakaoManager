package com.example.demo.web.interceptor;

import com.example.demo.domain.jwt.JwtProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        try { JwtProvider.parse(authHeader); }
        catch (Exception e) { response.setStatus(HttpStatus.UNAUTHORIZED.value()); return false;}
        return true;
    }
}
