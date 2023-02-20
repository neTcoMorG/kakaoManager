package com.example.demo.domain.service.kakao.message.json.location;
import com.example.demo.domain.service.kakao.message.json.list.ListObject;
import lombok.Data;

import java.util.List;

@Data
public class SendMessageLocationParam {
  List<String> receiver;
  ListObject listObject;
}

