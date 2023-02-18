package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MEMBER")
public class User {

    protected  User() {}
    public User(String accessToken, String refreshToken, String uuid, String nickname, String email, String profileImageUrl) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.uuid = uuid;
        this.nickname = nickname;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String accessToken;
    private String refreshToken;
    private String uuid;
    private String nickname;
    private String email;
    private String profileImageUrl;
}
