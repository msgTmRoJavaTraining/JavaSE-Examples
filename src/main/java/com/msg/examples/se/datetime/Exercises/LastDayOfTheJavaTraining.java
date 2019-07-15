package com.msg.examples.se.datetime.Exercises;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LastDayOfTheJavaTraining implements TemporalAdjuster {
    private LocalDate firstTrainingDay;

    @Override
    public Temporal adjustInto(Temporal input) {
        if (LocalDate.from(input).getDayOfWeek() != DayOfWeek.MONDAY) {
            firstTrainingDay = LocalDate.from(input).with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
            return firstTrainingDay;
        }
        else
        {
            return input.plus(6, ChronoUnit.WEEKS);
        }
    }
}
