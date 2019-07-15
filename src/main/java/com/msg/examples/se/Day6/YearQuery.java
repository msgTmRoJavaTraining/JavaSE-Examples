package com.msg.examples.se.Day6;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class YearQuery {

    public static ChineseYears findChineseYear(TemporalAccessor date) {
        int year = date.get(ChronoField.YEAR);
        int calculateIndex;
        calculateIndex = ((int)(year-2000)/12)+5;
        if(calculateIndex>12){
            calculateIndex = calculateIndex -12;
        }

        switch (calculateIndex){
            case 1 :
                return ChineseYears.Rat;
            case 2:
                return ChineseYears.Ox;
            case 3:
                return ChineseYears.Tiger;
            case 4:
                return ChineseYears.Rabbit;
            case 5:
                return ChineseYears.Dragon;
            case 6:
                return ChineseYears.Snake;
            case 7:
                return ChineseYears.Horse;
            case 8:
                return ChineseYears.Goat;
            case 9:
                return ChineseYears.Monkey;
            case 10:
                return ChineseYears.Rooster;
            case 11:
                return ChineseYears.Dog;
            case 12:
                return ChineseYears.Pig;
                default:
                    return null;
        }


    }

    public enum ChineseYears {
        Rat,Ox
        ,Tiger
        ,Rabbit
        ,Dragon
        ,Snake
        ,Horse
        ,Goat
        ,Monkey
        ,Rooster
        ,Dog
        ,Pig;
    }
}
