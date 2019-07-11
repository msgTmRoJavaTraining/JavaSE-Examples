package com.msg.examples.se.dayFour;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static jdk.nashorn.internal.objects.NativeArray.reduce;

public class MyStreams {

    public static void main(String[] args){

        // Problema 1

        List<Integer> list= Arrays.asList(1,2,3,4,5);

        Optional<String> commaSeparated = list.stream().map(a->{
            if(a%2==0){
                return "e" + a;
            }

            return "o" + a;

        }).reduce((x, y) -> x +"," + y);
        System.out.println(commaSeparated);


        // Problema 2


        System.out.println("\nStreaming 5 random doubles:");
        Random randomGenerator = new Random();
        Stream.iterate(ThreadLocalRandom.current().nextDouble(0,10), n -> ThreadLocalRandom.current().nextDouble(0,10)).limit(5).forEach(System.out::println);


        System.out.println("\nCreating a list with 10 random doubles:");
        ArrayList<Double> listOfRandomDoubles=new ArrayList<>();
        Stream.iterate(randomGenerator.nextDouble()*10, n -> randomGenerator.nextDouble()*10).limit(10).forEach(value -> listOfRandomDoubles.add(value));

        Iterator<Double> iterator=listOfRandomDoubles.iterator();

        int cnt=0;
        while (iterator.hasNext()){
            cnt++;
            System.out.println("Place: "+cnt+" - Value: "+iterator.next());
        }

        System.out.println("\nCreating an array with 20 random doubles:");
        Integer[] cnt2=new Integer[]{0};
        Double[] arrayOfRandomDoubles=new Double[21];
        Stream.iterate(randomGenerator.nextDouble()*10, n -> randomGenerator.nextDouble()*10).limit(20).forEach(value -> { cnt2[0]++;arrayOfRandomDoubles[cnt2[0]]=value;});


        for (int i=1;i< arrayOfRandomDoubles.length;i++)
            System.out.println("Place in array: "+ i+" - Value: "+arrayOfRandomDoubles[i]);

    }








}
