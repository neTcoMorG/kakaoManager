package com.example.demo.domain.service.kakao.message.json.text;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import lombok.Data;

@Data
public class SendMessageTextParam extends SendMessageParam {
  TextObject textObject;

  public SendMessageTextParam(Long groupId, TextObject textObject) {
    super.groupId = groupId;
    this.textObject = textObject;
  }
}
