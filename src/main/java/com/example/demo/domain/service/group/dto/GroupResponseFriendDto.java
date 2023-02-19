package com.example.demo.domain.service.group.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroupResponseFriendDto {
    private String name;
    private String uuid;
    private String profile_image_url;
}
