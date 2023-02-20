package com.example.demo.domain.service.kakao.message.json.list;
import lombok.Data;

import java.util.List;

@Data
public class SendMessageListParam {
  List<String> receiver;
  ListObject listObject;
}

