package com.msg.examples.se.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TimeDuration {

  public static void main(String args[]) {
    LocalDate now = LocalDate.now();
    LocalDate party = now.with(Month.SEPTEMBER).withDayOfMonth(21);
    System.out.println("Party time: " + Period.between(now, party));

    LocalDateTime newYear = LocalDateTime.now().with(TemporalAdjusters.lastDayOfYear()).truncatedTo(ChronoUnit.DAYS);
    newYear = newYear.plus(1, ChronoUnit.DAYS);
    System.out.println("Champagne time: " + Duration.between(LocalDateTime.now(), newYear));

    System.out.println("Only " + ChronoUnit.HOURS.between(LocalDateTime.now(), newYear) + " hours left :D");
  }
}
