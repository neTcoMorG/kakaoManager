package com.example.demo.domain.service.kakao.message.json.list;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.Link;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import lombok.Data;

import java.util.List;

@Data
public class ListObject extends MessageObject {
  private String header_title;
  private Link header_link;
  private List<Content> contents;
  private List<Button> buttons;

  public ListObject(String object_type, String header_title, Link header_link, List<Content> contents, List<Button> buttons) {
    super.object_type = object_type;
    this.header_title = header_title;
    this.header_link = header_link;
    this.contents = contents;
    this.buttons = buttons;
  }
}
