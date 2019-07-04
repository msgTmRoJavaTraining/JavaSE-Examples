package com.msg.examples.se.datetime;

import com.msg.examples.se.datetime.queries.QuarterQuery;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TimeQuery {

  public static void main(String args[]) {
    System.out.println("Previous quarter: " + LocalDate.now().minus(3, ChronoUnit.MONTHS).query(QuarterQuery::findQuarter));
    System.out.println("Current quarter: " + LocalDate.now().query(QuarterQuery::findQuarter));
    System.out.println("Next quarter: " + LocalDate.now().plus(3, ChronoUnit.MONTHS).query(QuarterQuery::findQuarter));

    System.out.println("Vacation time: " + LocalDate.now().query(date -> {
      int month = date.get(ChronoField.MONTH_OF_YEAR);
      return month > 6 && month < 10;
    }));
  }
}
