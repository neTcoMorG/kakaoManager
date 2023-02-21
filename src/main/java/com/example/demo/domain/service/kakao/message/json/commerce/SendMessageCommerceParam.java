package com.example.demo.domain.service.kakao.message.json.commerce;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import lombok.Data;

@Data
public class SendMessageCommerceParam extends SendMessageParam {
  CommerceObject commerceObject;

  public SendMessageCommerceParam(Long groupId, CommerceObject commerceObject) {
    super.groupId = groupId;
    this.commerceObject = commerceObject;
  }
}

