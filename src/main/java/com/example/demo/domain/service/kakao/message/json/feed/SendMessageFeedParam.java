package com.example.demo.domain.service.kakao.message.json.feed;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SendMessageFeedParam extends SendMessageParam {
  @Valid
  @NotNull(message = "feedObject 는 필수 입력값 입니다.")
  FeedObject feedObject;

  public SendMessageFeedParam(Long groupId, FeedObject feedObject) {
    super.groupId = groupId;
    this.feedObject = feedObject;
  }
}

