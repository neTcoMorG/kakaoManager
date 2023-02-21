package com.example.demo.domain.service.kakao.message.json.commerce;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CommerceObject extends MessageObject {
  @Valid
  @NotNull(message = "content 는 필수 입력값 입니다.")
  private Content content;
  @Valid
  @NotNull(message = "commerce 는 필수 입력값 입니다.")
  private Commerce commerce;
  private List<Button> buttons;

  public CommerceObject(String object_type, Content content, Commerce commerce, List<Button> buttons) {
    super.object_type = object_type;
    this.content = content;
    this.commerce = commerce;
    this.buttons = buttons;
  }
}
