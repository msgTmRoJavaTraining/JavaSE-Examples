package com.msg.examples.se.thirdDay;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String[] strArray = {"portocala", "bala", "ala"};
        Integer[] numbers = {660, 122, 500, 135, 16669, 15559};

        // Exercise 1
        MyStringLengthComparator MyStringComparator = new MyStringLengthComparator();
        Arrays.sort(strArray, MyStringComparator);
        Arrays.stream(strArray).forEach(System.out::println);

        // Exercise 2
        Comparator<String> numberOfVowelsInAStringComparator =
                Comparator.comparingInt(Main::getVowelsNumber);

        Arrays.sort(strArray, numberOfVowelsInAStringComparator);
        Arrays.stream(strArray).forEach(System.out::println);

        // Exercise 3
        System.out.println();
        Comparator<Integer> myDigitsComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return Integer.compare(getDigitsBiggerThan5Number(t1), getDigitsBiggerThan5Number(t2));
            }
        };

        Arrays.sort(numbers, myDigitsComparator);
        Arrays.stream(numbers).forEach(System.out::println);

        // Exercise 5
        System.out.println();
        Horse horse = new Horse("Roach");
        horse.run();

        Animal fox = new Animal() {
            @Override
            public void run() {
                System.out.println("I can run extremely fast!");
            }
        };
        fox.run();


        Animal Winnie = () -> System.out.println("Bear running slowly");
        Winnie.run();
    }

    private static int getVowelsNumber(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                count++;
            }
        }
        return count;
    }

    private static int getDigitsBiggerThan5Number(Integer number) {
        int count = 0;
        while (number != 0) {
            int digit;
            digit = number % 10;
            if (digit > 5) {
                count++;
            }
            number /= 10;
        }
        return count;
    }
}
