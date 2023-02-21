package com.example.demo.domain.service.kakao.message.json.text;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SendMessageTextParam extends SendMessageParam {
  @Valid
  @NotNull(message = "textObject 는 필수 입력값 입니다.")
  TextObject textObject;

  public SendMessageTextParam(Long groupId, TextObject textObject) {
    super.groupId = groupId;
    this.textObject = textObject;
  }
}
