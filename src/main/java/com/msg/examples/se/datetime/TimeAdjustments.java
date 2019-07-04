package com.msg.examples.se.datetime;

import com.msg.examples.se.datetime.adjuster.PayDayAdjuster;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.ChronoField.DAY_OF_YEAR;
import static java.time.temporal.ChronoUnit.YEARS;

public class TimeAdjustments {

  public static void main(String args[]) {
    LocalDate now = LocalDate.now();
    System.out.println(now.with(TemporalAdjusters.firstDayOfNextYear()));
    System.out.println(now.with((temporal) -> temporal.with(DAY_OF_YEAR, 1).plus(1, YEARS)));
    System.out.println(now.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY)));

    PayDayAdjuster classAdjuster = new PayDayAdjuster();
    LocalDate nextPayday = now.minus(1, ChronoUnit.MONTHS).with(classAdjuster);
    System.out.println("Previous pay day: " + nextPayday);

    nextPayday = now.with(classAdjuster);
    System.out.println("Next pay day: " + nextPayday);
  }
}
