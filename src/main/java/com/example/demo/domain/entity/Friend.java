package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Friend {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;      // 친구의 주인

    private String uuid;
    private String profileImageUrl;
    private String nickname;

    @OneToMany(mappedBy = "friend")
    private List<GroupMember> groupMemberList;

    protected Friend() {}
    public Friend(User user, String uuid, String profileImageUrl, String nickname) {
        this.user = user;
        this.uuid = uuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
    }
}
