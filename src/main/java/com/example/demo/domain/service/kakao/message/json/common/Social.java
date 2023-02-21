package com.example.demo.domain.service.kakao.message.json.common;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Social {
  @Pattern(regexp = "^[0-9]+$", message = "like_count 는 숫자만 입력가능합니다.")
  private String like_count;
  @Pattern(regexp = "^[0-9]+$", message = "comment_count 는 숫자만 입력가능합니다.")
  private String comment_count;
  @Pattern(regexp = "^[0-9]+$", message = "shared_count 는 숫자만 입력가능합니다.")
  private String shared_count;
  @Pattern(regexp = "^[0-9]+$", message = "view_count 는 숫자만 입력가능합니다.")
  private String view_count;
  @Pattern(regexp = "^[0-9]+$", message = "subscriber_count 는 숫자만 입력가능합니다.")
  private String subscriber_count;
}
