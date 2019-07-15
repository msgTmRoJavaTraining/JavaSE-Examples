package com.msg.examples.se.datetime;

import com.msg.examples.se.datetime.queries.YearQuery;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class ChineseYear
{

    public static void main(String[] args) {

        Random num=new Random();
        int n=num.nextInt(7);


        for(int i=n;i<n+5;i++)
        {
            System.out.println(LocalDate.now().plus(i,ChronoUnit.YEARS).query(YearQuery::findChineseYear));
        }
    }

}
