package com.msg.examples.se.Day6;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TempAdjuster implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal givenDate) {
        LocalDate input =  LocalDate.from(givenDate);
        input = input.plus(6, ChronoUnit.WEEKS);
        if(input.getDayOfWeek()!= DayOfWeek.FRIDAY){
            input = input.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }
        return input;
    }

}
