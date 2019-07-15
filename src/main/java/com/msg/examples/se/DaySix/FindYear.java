package com.msg.examples.se.DaySix;

import com.msg.examples.se.datetime.queries.QuarterQuery;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;

public class FindYear {

    public static Zodie findZodie(TemporalAccessor date){
        int year = date.get(ChronoField.YEAR);

        switch (calculeazaAn(year)){
            case 1:
                return Zodie.Rat;
            case 2:
                return Zodie.Ox;
            case 3:
                return Zodie.Tiger;
            case 4:
                return Zodie.Rabbit;
            case 5:
                return Zodie.Dragon;
            case 6:
                return Zodie.Snake;
            case 7:
                return Zodie.Horse;
            case 8:
                return Zodie.Goat;
            case 9:
                return Zodie.Monkey;
            case 10:
                return Zodie.Rooster;
            case 11:
                return Zodie.Dog;
            case 12:
                return Zodie.Pig;
        }
        return Zodie.Dog;
    }

    public static int calculeazaAn(int year){
        year=(year-2000)%12 + 5;
        if(year>12){
            year=year-12;
        }
        return year;
    }

    public enum Zodie{
        Rat,Ox,Tiger,Rabbit,Dragon,Snake,Horse,Goat,Monkey,Rooster,Dog,Pig
    }

    public static void main(String[] args){

        System.out.println("Chinese name next year: " + LocalDate.now().plus(1, ChronoUnit.YEARS).query(FindYear::findZodie));
        System.out.println("Chinese name next year: " + LocalDate.now().plus(2, ChronoUnit.YEARS).query(FindYear::findZodie));
        System.out.println("Chinese name next year: " + LocalDate.now().plus(3, ChronoUnit.YEARS).query(FindYear::findZodie));
        System.out.println("Chinese name next year: " + LocalDate.now().plus(4, ChronoUnit.YEARS).query(FindYear::findZodie));
        System.out.println("Chinese name next year: " + LocalDate.now().plus(5, ChronoUnit.YEARS).query(FindYear::findZodie));




    }



}
