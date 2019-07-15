package com.msg.examples.se.day6;

import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class JavaTrainingTimeAdjuster implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        return temporal.plus(6, ChronoUnit.WEEKS).with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
    }
}
