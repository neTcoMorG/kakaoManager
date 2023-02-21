package com.example.demo.domain.service.kakao.message.json.commerce;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CommerceObject extends MessageObject {
  private String object_type;
  private Content content;
  private Commerce commerce;
  private List<Button> buttons;
}
