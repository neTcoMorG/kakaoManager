package com.example.demo.domain.service.kakao.message.json.location;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LocationObject extends MessageObject {
  private String object_type;
  private Content content;
  private List<Button> buttons;
  private String address;
  private String address_title;
}
