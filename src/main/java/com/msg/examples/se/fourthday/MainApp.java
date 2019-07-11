package com.msg.examples.se.fourthday;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;


public class MainApp {
    public static void main(String args[]) {
        Integer[] numbers = {2, 3, 5, 11, 32, 54, 2341, 1, 0};

        System.out.println(MyFunctions.addLetter(2));
        System.out.println(MyFunctions.addLetter(3));
        List forWork=Arrays.asList(numbers);

        Object result =  forWork.stream().map(a->MyFunctions.addLetter((Integer)a)).reduce("",(b, c)->b+", "+c);
        System.out.println(result);
        List<Double> listOfRandomness=new ArrayList<>();

        int limit=5;
        System.out.println("5 random nums");
        MyFunctions.randomStream(limit).forEach(System.out::println);

        limit=10;
        System.out.println("10 random nums");
        MyFunctions.randomStream(limit).forEachOrdered(listOfRandomness::add);
        System.out.println(listOfRandomness);

        limit=20;
        double[] doubles = MyFunctions.randomStream(limit).toArray();
        System.out.println("20 random nums");
        for(int i=0;i<doubles.length;i++) System.out.println(doubles[i]);




    }
}

