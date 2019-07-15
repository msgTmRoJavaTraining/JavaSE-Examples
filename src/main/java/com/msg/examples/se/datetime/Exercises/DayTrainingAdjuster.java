package com.msg.examples.se.datetime.Exercises;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.DAY_OF_YEAR;
import static java.time.temporal.ChronoUnit.*;

public class DayTrainingAdjuster implements TemporalAdjuster {
    public Temporal adjustInto(Temporal input) {

        LocalDate trainingLastDay = LocalDate.from(input).plusWeeks(6).minusDays(3);

        if (trainingLastDay.getDayOfWeek() == DayOfWeek.SATURDAY ||
                trainingLastDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
            trainingLastDay = trainingLastDay.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }

        return trainingLastDay;

    }
}


