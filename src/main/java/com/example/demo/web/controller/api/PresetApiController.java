package com.example.demo.web.controller.api;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.message.feed.FeedMessagePreset;
import com.example.demo.domain.service.kakao.message.json.feed.FeedObject;
import com.example.demo.domain.service.kakao.preset.MessagePresetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/preset")
public class PresetApiController {
  private final MessagePresetService messagePresetService;

  @PostMapping("/feed/save")
  public HttpEntity<?> savePreset(User user, @RequestBody FeedMessagePreset feedMessagePreset) {
    feedMessagePreset.setUser(user);
    messagePresetService.savePreset(feedMessagePreset, "feed");
    return ResponseEntity.ok().build();
  }

  @GetMapping("/feed/list")
  public List<FeedObject> getFeedPreset(User user) {
    return messagePresetService.getPresetList(user.getId());
  }
}
