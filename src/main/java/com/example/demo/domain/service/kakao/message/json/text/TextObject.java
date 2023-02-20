package com.example.demo.domain.service.kakao.message.json.text;

import com.example.demo.domain.service.kakao.message.json.common.Link;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class TextObject {
    private String object_type;
    private String text;
    private Link link;
    private String button_title;
}
