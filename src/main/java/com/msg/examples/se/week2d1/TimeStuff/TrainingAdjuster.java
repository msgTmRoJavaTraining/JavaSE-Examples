package com.msg.examples.se.week2d1.TimeStuff;

import com.msg.examples.se.datetime.TimeAdjustments;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;


public class TrainingAdjuster implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        if (((LocalDate)temporal).getDayOfWeek() ==DayOfWeek.SATURDAY ||
                ((LocalDate)temporal).getDayOfWeek() ==DayOfWeek.SUNDAY)
            temporal=temporal.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        if (((LocalDate)temporal).getDayOfWeek() !=DayOfWeek.MONDAY)
           temporal=temporal.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        return temporal;
    }
}
