package com.msg.examples.se.day4;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String [] args) {
        List<Integer> ints = new ArrayList<>();
        List<Double>randomDoubles;
        Double [] doubleArray  =new Double[21];
        Integer[] index=new Integer[]{0};
        String intsToString;
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);

        intsToString= ints.stream().map(value -> {
            String finalValue = "";
            if(value %2 == 0){
                finalValue += "e" + value;
            }else if(value %2 != 0){
                finalValue = "o" + value;
            }
            return finalValue;
            }).reduce("",(concat,crtElement)->{
                if(concat!= ""){
                    concat = concat+ "," + crtElement ;
                }else{
                    concat= concat + crtElement;
                }
                return concat;
          });
        System.out.println("-----Exercise 1-----");
        System.out.println("Generated string is: " + intsToString);
        Random randomGenerator = new Random();
        System.out.println("-----Exercise 2-----");
        System.out.println("Print 5 random double numbers: ");
        Stream.iterate(ThreadLocalRandom.current().nextDouble(0,10),n ->ThreadLocalRandom.current().nextDouble(0,10)).limit(5).forEach(System.out::println);
        randomDoubles= Stream.iterate(ThreadLocalRandom.current().nextDouble(0,10),n ->ThreadLocalRandom.current().nextDouble(0,10)).limit(10).collect(Collectors.toList());
        System.out.println("\nPrint 10 random double numbers from a list: ");
        for(Double d: randomDoubles){
            System.out.println(d);
        }
        System.out.println("\n");
        Stream.iterate(ThreadLocalRandom.current().nextDouble(0,10),n ->ThreadLocalRandom.current().nextDouble(0,10)).limit(20).forEach(value-> {
            index[0]++;
            doubleArray[index[0]]=value;
        });
        for (int i=1;i< doubleArray.length;i++)
            System.out.println("Place in array: "+ i+" - Value: "+doubleArray[i]);

    }

}

