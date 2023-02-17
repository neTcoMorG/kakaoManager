package com.example.demo.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

    public User(String accessToken, String refreshToken, String nickname, String email, String profileImageUrl) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.nickname = nickname;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String accessToken;
    private String refreshToken;
    private String nickname;
    private String email;
    private String profileImageUrl;
}
