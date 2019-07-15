package com.msg.examples.se.datetime.Exercises;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class firstOne {
    public static void main(String[] args) {
        LocalDate present = LocalDate.now();

        LocalDate lastDay = present.with(new LastDayOfTheJavaTraining());
        LocalDate firstProjectDay = lastDay.with(new FirstProjectDay());
        System.out.println(lastDay);
        System.out.println(firstProjectDay);
    }
}
