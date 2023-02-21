package com.example.demo.domain.service.kakao.message.json.calendar;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import lombok.Data;

import java.util.List;

@Data
public class CalendarObject extends MessageObject {
  private String id_type;
  private String id;
  private Content content;
  private List<Button> buttons;

  public CalendarObject(String object_type, String id_type, String id, Content content, List<Button> buttons) {
    super.object_type = object_type;
    this.id_type = id_type;
    this.id = id;
    this.content = content;
    this.buttons = buttons;
  }
}
