package com.example.demo.domain.service.kakao.message.json;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TextObject {
    private String objectType;
    private String text;
    private String link;
}
