package com.example.demo.domain.service.kakao.message.json.calendar;
import lombok.Data;

import java.util.List;

@Data
public class SendMessageCalendarParam {
  List<String> receiver;
  CalendarObject calendarObject;
}

