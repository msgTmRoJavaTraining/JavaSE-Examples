package com.msg.examples.se.datetime.adjuster;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

import static java.time.temporal.ChronoField.DAY_OF_WEEK;
import static java.time.temporal.ChronoUnit.WEEKS;

public class LastDayOfCourse implements TemporalAdjuster
{


    @Override
    public Temporal adjustInto(Temporal temporal) {

        LocalDate lastDay=LocalDate.from(temporal).plus(6, WEEKS).minus(3,ChronoUnit.DAYS);

        return lastDay;
    }

    public static void main(String[] args) {

        LastDayOfCourse lastDayOfCourse =new LastDayOfCourse();

        LocalDate ld=Year.of(2019).atMonth(7).atDay(8).with(lastDayOfCourse);

        System.out.println("Ultima zi a cursului de java: "+ld);

        System.out.println();

        System.out.println("Prima zi a proiectului : "+ld.with((temporal) -> temporal.with(DAY_OF_WEEK, 1).minus(1, WEEKS)));

    }
}
