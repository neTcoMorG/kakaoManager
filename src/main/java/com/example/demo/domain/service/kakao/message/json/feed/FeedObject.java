package com.example.demo.domain.service.kakao.message.json.feed;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FeedObject {
  private String object_type;
  private Content content;
  private ItemContent item_content;
  private Social social;
  private List<Button> buttons;
}
