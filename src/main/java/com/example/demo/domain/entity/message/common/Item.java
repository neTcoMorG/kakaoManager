package com.example.demo.domain.entity.message.common;

import com.example.demo.domain.entity.message.feed.ItemContent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String item;
  private String itemOp;

  @ManyToOne
  @JoinColumn(name = "item_content_id")
  @ToString.Exclude
  private ItemContent itemContent;
}
