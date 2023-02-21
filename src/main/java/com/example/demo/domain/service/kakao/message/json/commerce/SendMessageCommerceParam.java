package com.example.demo.domain.service.kakao.message.json.commerce;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SendMessageCommerceParam extends SendMessageParam {
  @Valid
  @NotNull(message = "commerceObject 는 필수 입력값 입니다.")
  CommerceObject commerceObject;

  public SendMessageCommerceParam(Long groupId, CommerceObject commerceObject) {
    super.groupId = groupId;
    this.commerceObject = commerceObject;
  }
}

