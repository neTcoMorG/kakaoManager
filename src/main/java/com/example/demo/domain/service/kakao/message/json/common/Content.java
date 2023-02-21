package com.example.demo.domain.service.kakao.message.json.common;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Content {
  @NotBlank(message = "title 는 필수 입력값 입니다.")
  private String title;
  private String description;
  @NotBlank(message = "image_url 는 필수 입력값 입니다.")
  private String image_url;
  @Pattern(regexp = "^[0-9]+$", message = "image_width 는 숫자만 입력가능합니다.")
  private String image_width;
  @Pattern(regexp = "^[0-9]+$", message = "image_height 는 숫자만 입력가능합니다.")
  private String image_height;
  @Valid
  @NotNull(message = "link 는 필수 입력값 입니다.")
  private Link link;
}
