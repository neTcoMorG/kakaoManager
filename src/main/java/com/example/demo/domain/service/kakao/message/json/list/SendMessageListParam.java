package com.example.demo.domain.service.kakao.message.json.list;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import lombok.Data;

@Data
public class SendMessageListParam extends SendMessageParam {
  ListObject listObject;

  public SendMessageListParam(Long groupId, ListObject listObject) {
    super.groupId = groupId;
    this.listObject = listObject;
  }
}

