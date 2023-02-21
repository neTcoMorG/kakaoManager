package com.example.demo.domain.service.kakao.message.json.common;

import lombok.Data;

@Data
public class Link {
  private String web_url;
  private String mobile_web_url;
  private String android_execution_params;
  private String ios_execution_params;

  public boolean isNotBlankAnyOne(){
    if (web_url != null) return true;
    if (mobile_web_url != null) return true;
    if (android_execution_params != null) return true;
    if (ios_execution_params != null) return true;

    return false;
  }

  public Link(String web_url, String mobile_web_url, String android_execution_params, String ios_execution_params) {
    this.web_url = web_url;
    this.mobile_web_url = mobile_web_url;
    this.android_execution_params = android_execution_params;
    this.ios_execution_params = ios_execution_params;

    if (!isNotBlankAnyOne()) throw new IllegalArgumentException("Link 의 값 중 적어도 하나는 존재해야 합니다.");
  }
}
