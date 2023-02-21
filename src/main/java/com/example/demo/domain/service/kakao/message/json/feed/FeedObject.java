package com.example.demo.domain.service.kakao.message.json.feed;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import lombok.Data;

import java.util.List;

@Data
public class FeedObject extends MessageObject {
  private Content content;
  private ItemContent item_content;
  private Social social;
  private List<Button> buttons;

  public FeedObject(String object_type, Content content, ItemContent item_content, Social social, List<Button> buttons) {
    super.object_type = object_type;
    this.content = content;
    this.item_content = item_content;
    this.social = social;
    this.buttons = buttons;
  }
}
