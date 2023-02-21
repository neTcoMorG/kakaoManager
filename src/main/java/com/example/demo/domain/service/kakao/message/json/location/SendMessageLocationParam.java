package com.example.demo.domain.service.kakao.message.json.location;
import lombok.Data;

import java.util.List;

@Data
public class SendMessageLocationParam {
  List<String> receiver;
  LocationObject locationObject;
}

