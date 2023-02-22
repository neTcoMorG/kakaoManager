package com.example.demo.domain.entity.message.common;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Link {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "web_url")
  private String webUrl;
  @Column(name = "mobile_web_url")
  private String mobileWebUrl;
  @Column(name = "android_execution_parmas")
  private String androidExecutionParams;
  @Column(name = "ios_execution_params")
  private String iosExecutionParams;

  @OneToOne
  @JoinColumn(name = "content_id")
  private Content content;

}
