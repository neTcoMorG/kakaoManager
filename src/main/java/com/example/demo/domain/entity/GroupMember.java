package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class GroupMember {

  protected GroupMember() {}

  public GroupMember(Group group, Friend friend) {
    this.group = group;
    this.friend = friend;
  }

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "GROUP_ID")
  private Group group;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FRIEND_ID")
  private Friend friend;
}
