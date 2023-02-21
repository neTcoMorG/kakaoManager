package com.example.demo.domain.service.kakao.message.json.text;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Link;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class TextObject extends MessageObject {
    @NotBlank(message = "text 는 필수 입력값 입니다.")
    private String text;
    @Valid
    @NotNull(message = "link 는 필수 입력값 입니다.")
    private Link link;
    private String button_title;
    @Valid
    private List<Button> buttons;

    public TextObject(String object_type, String text, Link link, String button_title) {
        super.object_type = object_type;
        this.text = text;
        this.link = link;
        this.button_title = button_title;
    }
}
