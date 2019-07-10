package com.msg.examples.se.thirdDay;

import com.msg.examples.se.interfaces.DigitsBigger5;

import java.util.Arrays;
import java.util.Comparator;

public class MainApp {

    public static void main(String args[]) {

        String[] str = new String[3];
        str[0] = "aaa";
        str[1] = "aa";
        str[2] = "aaaaa";

        Comparator<String> vowelComp =
                (str1, str2) -> Integer.compare(NumberOfVowels.noVowel(str1), NumberOfVowels.noVowel(str2));
        Arrays.sort(str, vowelComp);
        System.out.println(str[0]);
        System.out.println(str[1]);
        System.out.println(str[2]);

        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(DigitsBigger5.no5(o1), DigitsBigger5.no5(o2));
            }
        };

        Integer[] arr = {3213, 543543, 876867, 432432, 6543223};
        Arrays.sort(arr, cmp);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);

        Horse horse = new Horse();
        horse.run();
        Animal fox = new Animal() {

            public void run() {
                System.out.println("fashfash");
            }
        };
        fox.run();
        Animal bear = () -> System.out.println("bum");
        bear.run();

    }

}
