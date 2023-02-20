package com.example.demo.domain.service.kakao.message.json.common;

import lombok.Data;

import java.util.Map;

@Data
public class Button {
  private String title;
  private Map<String, String> link;
}
