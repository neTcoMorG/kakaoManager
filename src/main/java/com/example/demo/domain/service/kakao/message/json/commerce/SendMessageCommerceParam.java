package com.example.demo.domain.service.kakao.message.json.commerce;
import lombok.Data;

import java.util.List;

@Data
public class SendMessageCommerceParam {
  List<String> receiver;
  CommerceObject commerceObject;
}

