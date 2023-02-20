package com.example.demo.domain.service.kakao.message.json.feed;

import lombok.Data;

import java.util.List;

@Data
public class ItemContent {
  private String profile_text;
  private String profile_image_url;
  private String title_image_url;
  private String title_image_text;
  private String title_image_category;
  private List<Item> items;
  private String sum;
  private String sum_op;
}
