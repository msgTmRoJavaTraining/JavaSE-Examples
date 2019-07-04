package com.msg.examples.se.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    private static final Logger LOGGER = Logger.getLogger(Streams.class.getPackage().getName());
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
    }
}
