package com.example.demo.domain.service.kakao.message.json.calendar;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import lombok.Data;

@Data
public class SendMessageCalendarParam extends SendMessageParam {
  CalendarObject calendarObject;

  public SendMessageCalendarParam(Long groupId, CalendarObject calendarObject) {
    super.groupId = groupId;
    this.calendarObject = calendarObject;
  }
}

