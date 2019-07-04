package com.msg.examples.se.datetime;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class BasicTime {

  public static void main(String args[]) {
    LocalDateTime now = LocalDateTime.now();
    System.out.println("Year: " + now.getYear() + " Month: " + now.getMonth() + " Hour: " + now.getHour() + " Minute: " + now.getMinute());
    System.out.println("SODay: " + LocalTime.now().toSecondOfDay() + " NODay: " + LocalTime.now().toNanoOfDay());
    System.out.println("DOWeek: " + now.getDayOfWeek() + " DOMonth: " + now.getDayOfMonth() + " DOYear: " + now.getDayOfYear());
    System.out.println(LocalTime.ofSecondOfDay(66666));

    System.out.println("Date at: " + Year.of(1983).atMonth(1).atDay(3).atTime(11, 5));
    System.out.println("Year leap: " + Year.from(now).isLeap());
    System.out.println(DayOfWeek.from(now).getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ro")));

    System.out.println(Instant.now().plus(10, ChronoUnit.DAYS));
  }
}
