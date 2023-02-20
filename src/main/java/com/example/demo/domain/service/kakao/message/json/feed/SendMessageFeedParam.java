package com.example.demo.domain.service.kakao.message.json.feed;
import lombok.Data;

import java.util.List;

@Data
public class SendMessageFeedParam {
  List<String> receiver;
  FeedObject feedObject;
}

