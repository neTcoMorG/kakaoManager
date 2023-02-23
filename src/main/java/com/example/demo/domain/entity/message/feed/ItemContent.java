package com.example.demo.domain.entity.message.feed;

import com.example.demo.domain.entity.message.common.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class ItemContent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String profileText;
  private String profileImageUrl;
  private String titleImageText;
  private String titleImageUrl;
  private String titleImageCategory;
  private String sum;
  private String sumOp;

  @OneToMany(mappedBy = "itemContent", cascade = CascadeType.ALL)
  private List<Item> items;
}
