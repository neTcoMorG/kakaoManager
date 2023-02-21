package com.example.demo.domain.service.kakao.message.json.calendar;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CalendarObject extends MessageObject {
  private String object_type;
  private String id_type;
  private String id;
  private Content content;
  private List<Button> buttons;
}
