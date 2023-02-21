package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FriendDto {
  public FriendDto(){}
  private String nickname;
  private String profileImageUrl;
  private String uuid;

}
