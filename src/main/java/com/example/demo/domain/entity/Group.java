package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "CUSTOM_GROUP")
public class Group {

  protected Group() {}

  public Group(User user, String name) {
    this.user = user;
    this.name = name;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long groupId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID")
  private User user;

  @Column(name = "GROUP_NAME")
  private String name;

  @OneToMany(mappedBy = "group")
  private List<GroupMember> groupMemberList;
}
