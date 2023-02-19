package com.example.demo.domain.service.group.dto;

import lombok.Data;

import java.util.List;

@Data
public class GroupResponseDto {
    private String group_name;
    private String group_id;
    List<GroupResponseFriendDto> members;
}
