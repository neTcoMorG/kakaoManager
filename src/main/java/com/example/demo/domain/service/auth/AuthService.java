package com.example.demo.domain.service.auth;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    @Value("${oauth.kakao.client_id}") private String clientId;
    @Value("${oauth.kakao.secret_id}") private String secret;
    @Value("${oauth.kakao.redirect_url}") private String redirectUrl;

    /**
     * 카카오톡 oAuth 로그인 서비스
     * <p>
     *  카카오 oAuth2 API를 이용해 로그인/회원가입을 처리   
     * </p>
     * 
     * @author : joyoungjun
     * @param code : Resource owner 로 부터 받은 code
     * @return jwt 토큰
     */
    public String login (String code) {
        return getToken(code).getAccess_token();
    }

    /**
     * Access_token 가져오기
     * 
     * <p>code를 가지고 access_token을 가져옴</p>
     *
     * @author : joyoungjun
     * @param code :  Resource owner 로 부터 받은 code
     * @return : access_token
     */
    private OauthToken getToken (String code) {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://kauth.kakao.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        return webClient.post()
                .uri("/oauth/token")
                .bodyValue(new TokenRequestValue("authorization_code", clientId, redirectUrl, code))
                .retrieve()
                .bodyToMono(OauthToken.class)
                .block();
    }


    /**
     * API 요청에 사용할 객체
     */
    @Data
    static class TokenRequestValue {
        private String grant_type;
        private String client_id;
        private String redirect_uri;
        private String code;

        public TokenRequestValue(String grant_type, String client_id, String redirect_uri, String code) {
            this.grant_type = grant_type;
            this.client_id = client_id;
            this.redirect_uri = redirect_uri;
            this.code = code;
        }
    }

    /**
     * 인증 서버로 부터 넘어올 토큰 객체
     */
    @Data
    static class OauthToken {
        private String access_token;
        private String token_type;
        private String refresh_token;
        private String scope;
        private int refresh_token_expires_in;
        private int expires_in;
    }
}
