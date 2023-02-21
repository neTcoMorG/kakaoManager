package com.example.demo.domain.service.kakao.message.json.common;

import jakarta.validation.constraints.NotNull;

public class MessageObject {
  @NotNull(message = "object_type 는 필수 입력값 입니다.")
  public String object_type;
}
