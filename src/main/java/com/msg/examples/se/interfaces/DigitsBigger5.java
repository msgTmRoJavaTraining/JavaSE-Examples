package com.msg.examples.se.interfaces;

import java.util.Comparator;

public class DigitsBigger5 {

    public static int no5(int num){
        int count=0;

        do{
            if(num % 10 > 5 ) {
                    System.out.println("num="+num+" count="+count);
                    count++;
                }
            num=num/10;
        }while(num!=0);
        return count;
    }


}
