package com.example.demo.domain.service.kakao.message.json.calendar;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SendMessageCalendarParam extends SendMessageParam {
  @Valid
  @NotNull(message = "calendarObject 는 필수 입력값 입니다.")
  CalendarObject calendarObject;

  public SendMessageCalendarParam(Long groupId, CalendarObject calendarObject) {
    super.groupId = groupId;
    this.calendarObject = calendarObject;
  }
}

