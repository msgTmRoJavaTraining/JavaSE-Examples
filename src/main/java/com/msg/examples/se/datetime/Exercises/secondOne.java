package com.msg.examples.se.datetime.Exercises;

import java.time.LocalDate;

public class secondOne {
    public static void main(String[] args) {

        for(int i=0;i<5;i++)
        {
            int year=LocalDate.now().getYear()+i;
            System.out.println(LocalDate.now().withYear(year).query(ChineseYear::findChineseYear));
        }
    }
}
