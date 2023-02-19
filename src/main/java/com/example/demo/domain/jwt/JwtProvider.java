package com.example.demo.domain.jwt;


import com.example.demo.domain.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Date;

@Slf4j
public class JwtProvider {

    private final static String KEY = "helloworld4522!@#$";

    public static String generate (User user) {
        Date now = new Date();
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("KakaoManager")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis())) // (4)
                .claim("uuid", user.getUuid())
                .claim("email", user.getEmail())
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
    }

    public static Claims parse (String requestHeader) throws Exception {
        if (requestHeader == null || !requestHeader.split(" ")[0].equals("Bearer")) { throw new Exception("[JwtProvider] 유효하지 않은 토큰 형식"); }
        String extractToken = requestHeader.split(" ")[1];
        log.info("extractToken: " + extractToken);

        return Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(extractToken)
                .getBody();
    }
}
