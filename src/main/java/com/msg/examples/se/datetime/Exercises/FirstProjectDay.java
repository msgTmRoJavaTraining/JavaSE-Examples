package com.msg.examples.se.datetime.Exercises;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class FirstProjectDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal input) {
        return input.minus(2, ChronoUnit.WEEKS);
    }
}
