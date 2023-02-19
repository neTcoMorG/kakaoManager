package com.example.demo.domain.service.group.dto;

import lombok.Data;

import java.util.List;

@Data
public class GroupAddFriendDto {

    private List<String> friend_uuid;
    private String group_id;
}
