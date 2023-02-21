package com.example.demo.domain.service.kakao.message.json.commerce;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import lombok.Data;

import java.util.List;

@Data
public class CommerceObject extends MessageObject {
  private Content content;
  private Commerce commerce;
  private List<Button> buttons;

  public CommerceObject(String object_type, Content content, Commerce commerce, List<Button> buttons) {
    super.object_type = object_type;
    this.content = content;
    this.commerce = commerce;
    this.buttons = buttons;
  }
}
