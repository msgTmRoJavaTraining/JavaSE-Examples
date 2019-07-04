package com.msg.examples.se.datetime.adjuster;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class PayDayAdjuster implements TemporalAdjuster {

  public Temporal adjustInto(Temporal input) {
    LocalDate payDay = LocalDate.from(input).with(TemporalAdjusters.lastDayOfMonth());

    if (payDay.getDayOfWeek() == DayOfWeek.SATURDAY ||
            payDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
      payDay = payDay.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
    }

    return payDay;
  }
}