package com.example.demo.domain.service.kakao.message.json;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SendMessageRequest {
    private List<String> receiver_uuids;
    private String template_object;
}
