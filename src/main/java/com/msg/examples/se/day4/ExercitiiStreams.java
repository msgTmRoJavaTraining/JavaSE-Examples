package com.msg.examples.se.day4;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ExercitiiStreams {
    public static void main(String[] args) {
        //Exercitiul 1
        String finalProccessedString = Stream.of(1,2,3,4,5,6,7,8,9,10).map((x) -> {
            if(x % 2 == 0) {
                return "o" + x;
            } else return "e" + x;
        }).reduce("", (parsedString, newString) -> parsedString + newString);

        System.out.println("Ziua 4 - primul exercitiu de la Streams\n" + finalProccessedString);

        //Exercitiul 2
        System.out.println("\nZiua 4 - al doilea exercitiu de la Streams");
        System.out.println("Partea 1, printare simpla");
        Stream.generate(() -> ThreadLocalRandom.current().nextDouble(0, 10))
                .limit(5).forEach((number) -> System.out.print(new DecimalFormat("#.00").format(number) + " "));

        System.out.println("\nPartea 2, folosind o lista");
        List<Double> randomDoubleList = Stream.generate(() -> ThreadLocalRandom.current().nextDouble(0, 10))
                .limit(10).collect(Collectors.toList());

        for(Double d : randomDoubleList) {
            System.out.print(new DecimalFormat("#.00").format(d) + " ");
        }

        System.out.println("\nPartea 3, folosind un array");
        double[] randomDoubleArray = DoubleStream.generate(() -> ThreadLocalRandom.current().nextDouble(0, 10))
                .limit(20).toArray();

        for(double item : randomDoubleArray) {
            System.out.print(new DecimalFormat("#.00").format(item) + " ");
        }
    }
}
