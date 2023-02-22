package com.example.demo.domain.entity.message.common;

import com.example.demo.domain.entity.message.feed.FeedMessagePreset;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Button {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "feed_message_preset_id")
  private FeedMessagePreset feedMessagePreset;

}
