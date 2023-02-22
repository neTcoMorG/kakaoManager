package com.example.demo.web.controller.api;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.message.common.MessagePreset;
import com.example.demo.domain.entity.message.feed.FeedMessagePreset;
import com.example.demo.domain.repository.MessagePresetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/preset")
public class PresetApiController {
  private final MessagePresetRepository messagePresetRepository;

  @PostMapping("/create")
  public void createPreset(User user, @RequestBody FeedMessagePreset feedMessagePreset) {
    feedMessagePreset.setUser(user);
    feedMessagePreset.setName("test");
    messagePresetRepository.save(feedMessagePreset);
    System.out.println();
  }


}
