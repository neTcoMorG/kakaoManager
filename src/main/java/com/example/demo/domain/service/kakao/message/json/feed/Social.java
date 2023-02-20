package com.example.demo.domain.service.kakao.message.json.feed;

import lombok.Data;

@Data
public class Social {
  private String like_count;
  private String comment_count;
  private String shared_count;
  private String view_count;
  private String subscriber_count;
}
