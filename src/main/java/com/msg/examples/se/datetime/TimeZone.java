package com.msg.examples.se.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZone {

  public static void main(String args[]) {
    System.out.println(ZonedDateTime.now(ZoneId.of("Europe/Paris")));
    System.out.println(ZonedDateTime.ofInstant(Instant.ofEpochSecond(1),  ZoneId.of("Europe/Paris")));
    System.out.println(ZonedDateTime.parse("2018-06-30T12:30:40+01:00[GMT+01:00]"));
    System.out.println(ZonedDateTime.parse("2018-06-30T12:30:40Z[UT]"));
    System.out.println(ZonedDateTime.parse("2018-06-30T12:30:40+01:00[Europe/London]"));

    ZoneId departure = ZoneId.systemDefault();
    ZoneId arrival = ZoneId.of("Asia/Tokyo");

    LocalDateTime departureTime = LocalDateTime.now();
    ZonedDateTime departureZoneTime = ZonedDateTime.of(departureTime, departure);
    ZonedDateTime arrivalZoneTime = departureZoneTime.withZoneSameInstant(arrival).plusHours(3).plusMinutes(30);

    DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  HH:mm");
    System.out.println(String.format("Departure: %s", departureZoneTime.format(format)));
    System.out.println(String.format("Arrival:   %s", arrivalZoneTime.format(format)));
  }
}
