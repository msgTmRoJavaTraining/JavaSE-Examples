package com.msg.examples.se.week2d1;

import com.msg.examples.se.datetime.TimeAdjustments;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        for(int i=0;i<5;i++) {
            LocalDateTime yr=LocalDateTime.now();
            System.out.println("Year: "+(yr.get(ChronoField.YEAR)+i)+" is the year of: " + ChineseZodiac.signOfYear(yr.withYear(yr.get(ChronoField.YEAR)+i)));
        }

        LocalDate training=LocalDate.now().withYear(2019).withMonth(7).withDayOfMonth(8);
        TrainingAdjuster adj=new TrainingAdjuster();
        training=(LocalDate)adj.adjustInto(training);
        System.out.println("Start: "+training);
        System.out.println("Firs day of project "+training.plusWeeks(4));
        System.out.println("Last day of training "+training.plusWeeks(6));


        //        System.out.print("Start: ");
//
//
//
//        for(int i=0;i<6;i++) {
//        if(i==4 || i==5) System.out.print("Project week: ");
//            System.out.println(training);
//            training=training.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
//
//
//        }


    }
}
