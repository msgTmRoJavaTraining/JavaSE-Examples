package com.msg.examples.se.DaySix;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.ChronoField.DAY_OF_YEAR;
import static java.time.temporal.ChronoUnit.YEARS;

public class TrainingAdjuster implements TemporalAdjuster {

    public Temporal adjustInto(Temporal temporal) {

        return temporal.plus(6,ChronoUnit.WEEKS).with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));


    }

    public static void main(String[] args){

        LocalDate now = LocalDate.now();
        LocalDate firstDay = Year.of(2019).atMonth(7).atDay(8);

        TrainingAdjuster lastDayAdjuster = new TrainingAdjuster();

        LocalDate lastTrainingDay = now.with((TemporalAdjuster) lastDayAdjuster.adjustInto(firstDay));
        System.out.println(lastTrainingDay);

        LocalDate startProject=lastTrainingDay.minus(2,ChronoUnit.WEEKS);


        if(startProject.getDayOfWeek() == DayOfWeek.FRIDAY){
            startProject = startProject.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }
        System.out.println(startProject);


    }


}
