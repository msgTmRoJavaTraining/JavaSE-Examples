package com.msg.examples.se.datetime.Exercises;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.ChronoUnit.*;
public class Main {

    public static void main(String[] args){

        LocalDate startDate =  LocalDate.now().withDayOfMonth(8);

        DayTrainingAdjuster dayTrainingAdjuster = new DayTrainingAdjuster();

        LocalDate endDate = startDate.with(dayTrainingAdjuster);
        LocalDate projectStart = endDate.minusDays(11);

        System.out.println(endDate);
        System.out.println(projectStart);
    }
}
