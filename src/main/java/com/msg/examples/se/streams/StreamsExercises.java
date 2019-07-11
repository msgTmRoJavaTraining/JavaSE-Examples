package com.msg.examples.se.streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamsExercises {
    public static void main(String[] args) {

        // Exercise 1
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(44);

        list.stream().forEach((a) -> System.out.println(a));
        // Or
        list.stream().forEach(System.out::println);
        // Or
        list.forEach(System.out::println);

        System.out.println(commaSeparatedString(list));

        // Exercise 2
        System.out.println("\nStreaming 5 random doubles:");
        Random randomGenerator = new Random();
        Stream.iterate(ThreadLocalRandom.current().nextDouble(0, 10), n -> ThreadLocalRandom.current().nextDouble(0, 10)).limit(5).forEach(System.out::println);

        System.out.println("\nCreating a list with 10 random doubles:");
        ArrayList<Double> listOfRandomDoubles = new ArrayList<>();
        Stream.iterate(randomGenerator.nextDouble() * 10, n -> randomGenerator.nextDouble() * 10).limit(10).forEach(value -> listOfRandomDoubles.add(value));
        Iterator<Double> iterator = listOfRandomDoubles.iterator();

        int cnt = 0;
        while (iterator.hasNext()) {
            cnt++;
            System.out.println("Place: " + cnt + " - Value: " + iterator.next());
        }


        System.out.println();
        double[] randomDoubleArray = new Random().doubles(20, 0, 10).toArray();
        for (double d : randomDoubleArray
        ) {
            System.out.println(d);
        }
    }

    private static String commaSeparatedString(List<Integer> numbers) {
        Stream<Integer> integerStream = numbers.stream();

        String result = "";

        String finalResult = integerStream.map((b) -> b.toString()).reduce(result, (a, b) -> {
            if (a == "") {
                if (evenOrOdd(Integer.parseInt(b)))
                    return a + "e" + b;
                else
                    return a + "o" + b;
            } else {
                if (evenOrOdd(Integer.parseInt(b)))
                    return a + ",e" + b;
                else
                    return a + ",o" + b;
            }
        });

        return finalResult;
    }

    private static boolean evenOrOdd(Integer a) {
        if (a % 2 == 0) return true;
        else return false;
    }
}
