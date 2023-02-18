package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOM_GROUP")
public class Group {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long groupId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
    @Column(name = "GROUP_NAME")  private String name;


}
