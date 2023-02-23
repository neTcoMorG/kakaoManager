package com.example.demo.domain.service.kakao.preset;

import com.example.demo.domain.entity.message.common.MessagePreset;
import com.example.demo.domain.service.kakao.message.json.feed.FeedObject;

import java.util.List;

public interface MessagePresetService {
  void savePreset(MessagePreset messagePreset, String template);
  List<FeedObject> getPresetList(Long userId);
}
