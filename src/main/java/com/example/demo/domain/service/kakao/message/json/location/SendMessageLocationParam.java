package com.example.demo.domain.service.kakao.message.json.location;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SendMessageLocationParam extends SendMessageParam {
  @Valid
  @NotNull(message = "locationObject 는 필수 입력값 입니다.")
  LocationObject locationObject;

  public SendMessageLocationParam(Long groupId, LocationObject locationObject) {
    super.groupId = groupId;
    this.locationObject = locationObject;
  }
}

