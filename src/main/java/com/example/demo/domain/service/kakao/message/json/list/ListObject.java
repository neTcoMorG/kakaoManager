package com.example.demo.domain.service.kakao.message.json.list;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.Link;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListObject extends MessageObject {
  private String object_type;
  private String header_title;
  private Link header_link;
  private List<Content> contents;
  private List<Button> buttons;
}
