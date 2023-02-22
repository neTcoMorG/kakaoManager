package com.example.demo.domain.entity.message.common;

import com.example.demo.domain.entity.message.feed.ItemContent;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String item;
  private String itemOp;

  @ManyToOne
  @JoinColumn(name = "item_content_id")
  private ItemContent itemContent;
}
