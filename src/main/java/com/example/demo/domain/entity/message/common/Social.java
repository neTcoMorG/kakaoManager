package com.example.demo.domain.entity.message.common;

import com.example.demo.domain.entity.message.feed.FeedMessagePreset;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
public class Social {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long likeCount;
  private Long commentCount;
  private Long viewCount;
  private Long subscriberCount;
  @OneToOne
  @JoinColumn(name = "feed_message_preset_id")
  @ToString.Exclude
  private FeedMessagePreset feedMessagePreset;
}
