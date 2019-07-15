package com.msg.examples.se.Day6;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import static java.time.temporal.ChronoUnit.YEARS;

public class Main {
    public static void main(String[] args) {
        TempAdjuster classAdjuster = new TempAdjuster();
        LocalDate startProject;
        LocalDate now = LocalDate.of(2019,7, 8);
        LocalDate lastDayOfTraining;
        if(now.getDayOfWeek()!= DayOfWeek.MONDAY){
            now=now.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        }
        lastDayOfTraining = now.with(classAdjuster);
        System.out.println("Last day of training is: " + lastDayOfTraining);
        startProject= lastDayOfTraining.minus(2, ChronoUnit.WEEKS);
        if(startProject.getDayOfWeek()!= DayOfWeek.MONDAY){
            startProject = startProject.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }
        System.out.println("Project start date is: " + startProject);
        System.out.println("The chinese sign for the year " + now.plus(2,YEARS).getYear()+  " is : "+ now.plus(2, YEARS).query(YearQuery::findChineseYear));
    }
}
