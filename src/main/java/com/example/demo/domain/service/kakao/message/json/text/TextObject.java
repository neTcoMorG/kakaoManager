package com.example.demo.domain.service.kakao.message.json.text;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class TextObject {
    private String object_type;
    private String text;
    private Map<String, String> link;
    private String button_title;
}
