package com.msg.examples.se.datetime.queries;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;

public class YearQuery
{
    public static YearDivision findChineseYear(TemporalAccessor date)
    {
        int var= LocalDate.from(date).getYear()-2000;
        var=var%12+5;
        if(var>12)
            var=var-12;

        switch (var)
        {
            case 1:
            {
                return YearDivision.RAT;
            }
            case 2:
            {
                return YearDivision.OX;
            }
            case 3:
            {
                return YearDivision.TIGER;
            }

            case 4:
            {
                return YearDivision.RABBIT;
            }

            case 5:
            {
                return YearDivision.DRAGON;
            }
            case 6:
            {
                return YearDivision.SNAKE;
            }
            case 7:
            {
                return YearDivision.HORSE;
            }
            case 8:
            {
                return YearDivision.GOAT;
            }
            case 9:
            {
                return YearDivision.MONKEY;
            }
            case 10:
            {
                return YearDivision.ROOSTER;
            }
            case 11:
            {
                return YearDivision.DOG;
            }
            case 12:
            {
                return YearDivision.PIG;
            }

           default: return YearDivision.PIG;
        }

    }

    public enum YearDivision {

        RAT,OX,TIGER,RABBIT,DRAGON,SNAKE,HORSE,GOAT,MONKEY,ROOSTER,DOG,PIG
     }

}
