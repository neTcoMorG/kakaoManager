package com.example.demo.domain.service.kakao.message.json.text;

import com.example.demo.domain.service.kakao.message.json.common.Link;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import lombok.Data;

@Data
public class TextObject extends MessageObject {
    private String text;
    private Link link;
    private String button_title;

    public TextObject(String object_type, String text, Link link, String button_title) {
        super.object_type = object_type;
        this.text = text;
        this.link = link;
        this.button_title = button_title;
    }
}
