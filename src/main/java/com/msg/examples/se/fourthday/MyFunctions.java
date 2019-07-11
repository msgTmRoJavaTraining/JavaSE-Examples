package com.msg.examples.se.fourthday;

import java.util.Random;
import java.util.stream.DoubleStream;

public class MyFunctions {
    public static boolean isOdd(int num){
        return (num%2)==0 ? false:true;
    }
    public static String addLetter(int num){
        return isOdd(num) ? "o"+num : "e"+num;
    }
    public static double randomNum(double rangeMin,double rangeMax){
        Random r = new Random();
        return  rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }
    public static DoubleStream randomStream(int limit){
        return DoubleStream.iterate(MyFunctions.randomNum(0,10), rn->MyFunctions.randomNum(0,10)).limit(limit);
    }
}
