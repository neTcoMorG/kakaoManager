package com.example.demo.domain.service.kakao.message.json.text;
import lombok.Data;

import java.util.List;

@Data
public class SendMessageTextParam {
  List<String> receiver;
  TextObject textObject;
}
