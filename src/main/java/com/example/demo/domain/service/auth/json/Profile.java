package com.example.demo.domain.service.auth.json;

import lombok.Data;

@Data
public class Profile {
    private String nickname;
    private String profile_image_url;
    private String thumbnail_image_url;
}
