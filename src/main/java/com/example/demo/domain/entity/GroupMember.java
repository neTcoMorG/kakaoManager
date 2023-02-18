package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class GroupMember {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "GROUP_ID")
  private Group group;
  @ManyToOne
  @JoinColumn(name = "FRIEND_ID")
  private Friend friend;
}
