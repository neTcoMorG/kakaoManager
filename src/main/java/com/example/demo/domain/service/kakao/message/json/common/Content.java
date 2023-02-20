package com.example.demo.domain.service.kakao.message.json.common;

import lombok.Data;

@Data
public class Content {
  private String title;
  private String description;
  private String image_url;
  private String image_width;
  private String image_height;
  private Link link;
}
