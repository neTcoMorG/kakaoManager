package com.example.demo.domain.service.kakao.message.json.location;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import lombok.Data;

import java.util.List;

@Data
public class LocationObject extends MessageObject {
  private Content content;
  private List<Button> buttons;
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
