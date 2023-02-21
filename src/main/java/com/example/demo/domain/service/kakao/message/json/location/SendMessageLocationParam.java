package com.example.demo.domain.service.kakao.message.json.location;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import lombok.Data;

@Data
public class SendMessageLocationParam extends SendMessageParam {
  LocationObject locationObject;

  public SendMessageLocationParam(Long groupId, LocationObject locationObject) {
    super.groupId = groupId;
    this.locationObject = locationObject;
  }
}

