package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class GroupMember {

    protected GroupMember () {}

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @OneToOne
    @JoinColumn(name = "GROUP")
    private Group group;


}
