package com.msg.examples.se.streams;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    private static final Logger LOGGER = Logger.getLogger(Streams.class.getPackage().getName());


    public static boolean isEven(int a)
    {
        return a%2==0;
    }

    public static String commaSeparated(ArrayList<Integer>list)
    {
        int []nr=new int[1];
        nr[0]=0;
        String rez=list.stream().map(a->{
            if(nr[0]==0)
            {
                nr[0]++;
                if(isEven(a))
                return "e"+a;
                 else
                return "o"+a;
            }
            else {
                if (isEven(a))
                    return ",e" + a;
                else
                    return ",o" + a;
            }
        }).reduce("",(a1,b)->a1+b);

        return rez;

    }



    public static void main(String[] args) {
        String[] strs = {"ana", "are", "mere"};
        //count the number of elements of the str array
        System.out.println(Arrays.stream(strs).count());

        //total number of characters of str array
        System.out.println(Stream.of(strs).map(String::length).reduce(0 , (sum, lastLength) -> sum + lastLength));

        List<String> strings = Arrays.asList(strs);
        //print all elements of the strings array having the length different than 3
        strings.stream().filter(str -> str.length() != 3).forEach(System.out::println);


        //----------------------reduce examples--------------------
        OptionalInt reduced =
                IntStream.range(1, 4).reduce((a, b) -> a + b);
        reduced.ifPresent(System.out::println);

        int reducedTwoParams =
                IntStream.range(1, 4).reduce(10, (a, b) -> a + b);
        System.out.println(reducedTwoParams);

        int reducedParams = Stream.of(1, 2, 3)
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    LOGGER.info("combiner was called - seq stream");
                    return a + b;
                });
        System.out.println(reducedParams + " combiner was not called");

        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    LOGGER.info("combiner was called - parallel stream");
                    return a + b;
                });
        System.out.println(reducedParallel + " combiner is called with parallel streams");

        Random rand=new Random();
        Stream<Double> streamInf = Stream.iterate(0.0,n->10*rand.nextDouble()).skip(1).limit(5);

        System.out.println();
        streamInf.forEach(System.out::println);

        System.out.println("============Lista cu 10 elem================");

        Stream<Double> streamList=Stream.iterate(0.0,n->10.0* rand.nextDouble()).skip(1).limit(10);

        List<Double> listaDouble =  streamList.collect(Collectors.toList());

        listaDouble.forEach(System.out::println);

        System.out.println("============vector cu 20 elem================");

        Stream<Double> streamArray=Stream.iterate(0.0,n->10.0 * rand.nextDouble()).skip(1).limit(20);

        Double[] stringArray = streamArray.toArray(Double[]::new);

        for(Double d:stringArray)
            System.out.println(d);

        ArrayList<Integer> listaInt=new ArrayList<>();
        listaInt.add(1);
        listaInt.add(2);
        listaInt.add(6);
        listaInt.add(33);
        listaInt.add(99);
        listaInt.add(40);


        System.out.println();
        System.out.println(commaSeparated(listaInt));
    }
}

