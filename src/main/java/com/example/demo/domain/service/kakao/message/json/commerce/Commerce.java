package com.example.demo.domain.service.kakao.message.json.commerce;

import lombok.Data;

@Data
public class Commerce {
  private String product_name;
  private String regular_price;
  private String discount_price;
  private String discount_rate;
  private String fixedDiscountPrice;
  private String currency_unit;
  private String currency_unit_position;
}
