package com.example.demo.domain.service.kakao.message.json.location;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class LocationObject extends MessageObject {
  @Valid
  @NotNull(message = "content 는 필수 입력값 입니다.")
  private Content content;
  @Valid
  private List<Button> buttons;
  @NotBlank(message = "address 는 필수 입력값 입니다.")
  private String address;
  private String address_title;

  public LocationObject(String object_type, Content content, List<Button> buttons, String address, String address_title) {
    super.object_type = object_type;
    this.content = content;
    this.buttons = buttons;
    this.address = address;
    this.address_title = address_title;
  }
}
