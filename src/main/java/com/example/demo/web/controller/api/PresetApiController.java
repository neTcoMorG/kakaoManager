package com.example.demo.web.controller.api;

import com.example.demo.domain.entity.Group;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.message.feed.FeedMessagePreset;
import com.example.demo.domain.repository.FeedMessagePresetRepository;
import com.example.demo.domain.repository.GroupRepository;
import com.example.demo.domain.service.kakao.message.json.feed.FeedObject;
import com.example.demo.domain.service.kakao.preset.MessagePresetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/preset")
public class PresetApiController {
  private final MessagePresetService messagePresetService;
  private final FeedMessagePresetRepository feedMessagePresetRepository;
  private final GroupRepository groupRepository;

  @PostMapping("/feed/save")
  public HttpEntity<?> saveFeedPreset(User user, @RequestBody FeedMessagePreset feedMessagePreset) {
    feedMessagePreset.setUser(user);
    messagePresetService.savePreset(feedMessagePreset, "feed");
    return ResponseEntity.ok().build();
  }

  @GetMapping("/feed/send")
  public void sendFeedPreset(User user, @RequestParam Long groupId, @RequestParam Long presetId) {
    Long userId = user.getId();
    FeedMessagePreset findPreset = feedMessagePresetRepository.findByIdAndUserId(userId, presetId).orElseThrow();
    Group findGroup = groupRepository.findByIdAndUserId(groupId, userId).orElseThrow();

  }

  @GetMapping("/feed/list")
  public List<FeedObject> getFeedPreset(User user) {
    return messagePresetService.getPresetList(user.getId());
  }
}
