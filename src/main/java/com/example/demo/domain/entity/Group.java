package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "CUSTOM_GROUP")
public class Group {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long groupId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FRIEND_ID")
  private Friend friend;

  @Column(name = "GROUP_NAME")
  private String name;

  @Column(name = "GROUP_UUID")
  private String uuid;

  @OneToMany(mappedBy = "group")
  private List<GroupMember> groupMemberList;
}
