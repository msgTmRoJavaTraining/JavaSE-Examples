package com.msg.examples.se.datetime.Exercises;



import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;

 class QuarterQuery {
public static ChinesseQuarter findQuarter(TemporalAccessor date) {
    int year = date.get(ChronoField.YEAR);
    switch (checkChinese(year)) {

        case 1:
            return ChinesseQuarter.RAT;
        case 2:
            return ChinesseQuarter.OX;
        case 3:
            return ChinesseQuarter.TIGER;
        case 4:
            return ChinesseQuarter.RABBIT;
        case 5:
            return ChinesseQuarter.DRAGON;
        case 6:
            return ChinesseQuarter.SNAKE;
        case 7:
            return ChinesseQuarter.HORSE;
        case 8:
            return ChinesseQuarter.GOAT;
        case 9:
            return ChinesseQuarter.MONKEY;
        case 10:
            return ChinesseQuarter.ROOSTER;
        case 11:
            return ChinesseQuarter.DOG;
        case 12:
            return ChinesseQuarter.PIG;

    }
    return null;
}
public static int checkChinese(int variable){
            variable = variable - 2000;
            variable = variable % 12;
            variable = variable + 5;
            if(variable > 12)
                variable = variable - 12;

            return variable;
    }


public enum ChinesseQuarter {
    RAT,
    OX,
    TIGER,
    RABBIT,
    DRAGON,
    SNAKE,
    HORSE,
    GOAT,
    MONKEY,
    ROOSTER,
    DOG,
    PIG;
}
}


public class myQuery {


       public static void main(String[] args){


           System.out.println( LocalDate.now().query(QuarterQuery::findQuarter));
           System.out.println( LocalDate.now().plus(1,ChronoUnit.YEARS).query(QuarterQuery::findQuarter));
           System.out.println( LocalDate.now().plus(2,ChronoUnit.YEARS).query(QuarterQuery::findQuarter));
           System.out.println( LocalDate.now().plus(3,ChronoUnit.YEARS).query(QuarterQuery::findQuarter));
           System.out.println( LocalDate.now().plus(4,ChronoUnit.YEARS).query(QuarterQuery::findQuarter));


       }
}
