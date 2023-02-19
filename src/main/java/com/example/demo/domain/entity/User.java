package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    @OneToMany(mappedBy = "user")
    private List<Friend> friendList;

    @OneToMany(mappedBy = "user")
    private List<Group> groupList;
    protected  User() {}
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
