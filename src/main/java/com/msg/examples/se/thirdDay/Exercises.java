package com.msg.examples.se.thirdDay;

import com.msg.examples.se.collections.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Exercises {

    public static void main(String[] args) {
        //Exercitiul 1
        exercitiul1("Abracadabra", "Anual");

        //Exercitiul 2
        exercitiul2();

        //Exercitiul 3
        exercitiul3();

        //Exercitiul 4
        exercitiul4();
    }

    private static void exercitiul1(String string1, String string2) {
        MyComparator myComparator = new MyComparator();

        System.out.println("Primul exercitiu:");
        switch (myComparator.compare(string1, string2)) {
            case 1:
                System.out.println(string1 + " are mai multe litere decat " + string2);
                break;

            case -1:
                System.out.println(string2 + " are mai multe litere decat " + string1);
                break;

            case 0:
                System.out.println(string1 + " si " + string2 + " au acelasi numar de litere");
                break;
        }
    }

    private static int getNumberOfVowels(String givenString) {
        int count = 0;

        for (int i = 0; i < givenString.length(); i++) {
            char c = givenString.toLowerCase().charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }

        return count;
    }

    private static void exercitiul2() {
        Comparator<String> lambdaVowelComparator =
                (string1, string2) -> Integer.compare(getNumberOfVowels(string1), getNumberOfVowels(string2));

        ArrayList<String> myVowelsList = new ArrayList<>();
        myVowelsList.add("Hamburger");
        myVowelsList.add("Apa");
        myVowelsList.add("Sticla");
        myVowelsList.add("Raffaello");

        System.out.println("\nExercitiul 2 - Lista nesortata");
        for (String s : myVowelsList) System.out.println(s);

        myVowelsList.sort(lambdaVowelComparator);
        System.out.println("\nExercitiul 2 - Lista sortata");
        for (String s : myVowelsList) System.out.println(s);
    }

    private static void exercitiul3() {
        Comparator<Integer> numberOfDigitsComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer1, Integer integer2) {
                return Integer.compare(biggerThan5Digits(String.valueOf(integer1)), biggerThan5Digits(String.valueOf(integer2)));
            }
        };

        ArrayList<Integer> myIntegerList = new ArrayList<>();
        myIntegerList.add(12300);
        myIntegerList.add(5687);
        myIntegerList.add(40591);
        myIntegerList.add(793);

        System.out.println("\nExercitiul 3 - Lista nesortata");
        for (Integer i : myIntegerList) System.out.println(i);

        myIntegerList.sort(numberOfDigitsComparator);
        System.out.println("\nExercitiul 3 - Lista sortata");
        for (Integer i : myIntegerList) System.out.println(i);
    }

    private static int biggerThan5Digits(String number) {
        int count = 0;

        for (int i = 0; i < number.length(); i++) {
            if (Integer.parseInt(String.valueOf(number.charAt(i))) > 5) count++;
        }

        return count;
    }

    private static void exercitiul4() {
        System.out.println("\nExercitiul 4");

        Horse horse = new Horse();
        horse.run();

        Animal fox = new Animal() {
            @Override
            public void run() {
                System.out.println("The fox runs in the night.");
            }
        };

        fox.run();

        Animal bear = () -> System.out.println("The bear runs in the forest.");
        bear.run();
    }
}
