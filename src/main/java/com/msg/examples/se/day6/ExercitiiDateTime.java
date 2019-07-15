package com.msg.examples.se.day6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class ExercitiiDateTime {
    public static void main(String[] args) {
        //Exercitiul 1
        System.out.println("Exercitiul 1 - Java Training end date and project start date");
        exercitiul1();


        //Exercitiul 2
        System.out.println("\nExercitiul 2 - Chinese Zodiac Calculator");
        exercitiul2();
    }

    private static void exercitiul1() {
        JavaTrainingTimeAdjuster javaTrainingTimeAdjuster = new JavaTrainingTimeAdjuster();
        LocalDate startDate = Year.of(2019).atMonth(7).atDay(8);

        LocalDate endDateForJavaTraining = LocalDate.now().with((TemporalAdjuster) javaTrainingTimeAdjuster.adjustInto(startDate));
        System.out.println("End Date for Java Training: " + endDateForJavaTraining);

        LocalDate startTimeForProject = endDateForJavaTraining.minusWeeks(2);
        System.out.println("Start Date for Project: " + startTimeForProject.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
    }

    private static void exercitiul2() {
        for (int i = 0; i < 5; i++) {
            LocalDate currentYear = LocalDate.now().plus(i, ChronoUnit.YEARS);
            System.out.println("Semnul Zodiac Chinezesc pentru anul " + currentYear.getYear() + " este " + currentYear.query(ChineseZodiacQuery::findZodiacSign));
        }
    }
}
