package com.example.demo.domain.service.kakao.message.json.list;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.Link;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ListObject extends MessageObject {
  @NotBlank(message = "header_title 는 필수 입력값 입니다.")
  private String header_title;
  @Valid
  @NotNull(message = "header_link 는 필수 입력값 입니다.")
  private Link header_link;
  @Valid
  @NotNull(message = "contents 는 필수 입력값 입니다.")
  private List<Content> contents;
  @Valid
  private List<Button> buttons;

  public ListObject(String object_type, String header_title, Link header_link, List<Content> contents, List<Button> buttons) {
    super.object_type = object_type;
    this.header_title = header_title;
    this.header_link = header_link;
    this.contents = contents;
    this.buttons = buttons;
  }
}
