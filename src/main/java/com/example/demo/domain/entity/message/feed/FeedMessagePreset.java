package com.example.demo.domain.entity.message.feed;

import com.example.demo.domain.entity.message.common.Button;
import com.example.demo.domain.entity.message.common.Content;
import com.example.demo.domain.entity.message.common.MessagePreset;
import com.example.demo.domain.entity.message.common.Social;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@DiscriminatorValue("feed")
public class FeedMessagePreset extends MessagePreset {
  @JoinColumn(name = "content_id")
  @OneToOne
  @ToString.Exclude
  private Content content;
  @JoinColumn(name = "item_content_id")
  @OneToOne
  @ToString.Exclude
  private ItemContent itemContent;

  @OneToOne(mappedBy = "feedMessagePreset")
  private Social social;
  @OneToMany(mappedBy = "feedMessagePreset")
  private List<Button> buttons;
}
