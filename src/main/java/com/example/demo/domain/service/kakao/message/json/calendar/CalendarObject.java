package com.example.demo.domain.service.kakao.message.json.calendar;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CalendarObject extends MessageObject {
  @NotBlank(message = "id_type 는 필수 입력값 입니다.")
  private String id_type;
  @NotBlank(message = "id 는 필수 입력값 입니다.")
  private String id;
  @Valid
  @NotNull(message = "content 는 필수 입력값 입니다.")
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
