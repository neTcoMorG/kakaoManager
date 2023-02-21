package com.example.demo.domain.service.kakao.message.json.commerce;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Commerce {
  private String product_name;
  @NotBlank
  @Pattern(regexp = "^[0-9]+$", message = "regular_price 는 숫자만 입력가능합니다.")
  private String regular_price;
  @Pattern(regexp = "^[0-9]+$", message = "discount_price 는 숫자만 입력가능합니다.")
  private String discount_price;
  @Pattern(regexp = "^[0-9]+$", message = "discount_rate 는 숫자만 입력가능합니다.")
  private String discount_rate;
  @Pattern(regexp = "^[0-9]+$", message = "fixedDiscountPrice 는 숫자만 입력가능합니다.")
  private String fixedDiscountPrice;
  private String currency_unit;
  @Pattern(regexp = "^[0-9]+$", message = "currency_unit_position 는 숫자만 입력가능합니다.")
  private String currency_unit_position;
}
