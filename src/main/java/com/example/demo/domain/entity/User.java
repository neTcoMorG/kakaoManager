package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Table(name = "MEMBER")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accessToken;
    private String refreshToken;
    private String uuid;
    private String nickname;
    private String email;
    private String profileImageUrl;

    private String scope;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Friend> friendList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Group> groupList;

    public User() {
    }

    public User(String scope, String accessToken, String refreshToken, String uuid, String nickname, String email, String profileImageUrl) {
        this.scope = scope;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.uuid = uuid;
        this.nickname = nickname;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
    }

    public List<String> getPermissions () { return Arrays.asList(scope.split(" ")); }
}
