package com.example.demo.domain.entity.message.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Content {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;
  @Column(name = "description")
  private String description;
  @Column(name = "image_url")
  private String imageURL;
  @Column(name = "image_width")
  private Long imageWidth;
  @Column(name = "image_height")
  private Long imageHeight;

  @OneToOne(mappedBy = "content", cascade = CascadeType.ALL)
  private Link link;
}
