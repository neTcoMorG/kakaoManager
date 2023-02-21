package com.example.demo.domain.service.kakao.message.json.feed;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import com.example.demo.domain.service.kakao.message.json.common.Social;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class FeedObject extends MessageObject {
  @Valid
  @NotNull(message = "content 는 필수 입력값 입니다.")
  private Content content;
  @Valid
  private ItemContent item_content;
  @Valid
  private Social social;
  @Valid
  private List<Button> buttons;

  public FeedObject(String object_type, Content content, ItemContent item_content, Social social, List<Button> buttons) {
    super.object_type = object_type;
    this.content = content;
    this.item_content = item_content;
    this.social = social;
    this.buttons = buttons;
  }
}
