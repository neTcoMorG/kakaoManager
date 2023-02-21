package com.example.demo.domain.service.kakao.message.json.feed;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import lombok.Data;

@Data
public class SendMessageFeedParam extends SendMessageParam {
  FeedObject feedObject;

  public SendMessageFeedParam(Long groupId, FeedObject feedObject) {
    super.groupId = groupId;
    this.feedObject = feedObject;
  }
}

