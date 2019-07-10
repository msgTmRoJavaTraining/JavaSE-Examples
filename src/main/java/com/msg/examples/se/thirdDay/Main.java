package com.msg.examples.se.thirdDay;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String [] args){
        List<String> array = new ArrayList<>();
        List<Integer>arrayInteger = new ArrayList<>();
        String s1 = "aeiou";
        String s2 = "aaa";
        int n1 = 35678;
        int n2 = 34;
        int n3 = 987667;
        int n4= 67;
        int n5 = 16;
        arrayInteger.add(n1);
        arrayInteger.add(n2);
        arrayInteger.add(n3);
        arrayInteger.add(n4);
        arrayInteger.add(n5);
        array.add(s1);
        array.add(s2);
        ComparatorForStrings cp = new ComparatorForStrings();
        switch(cp.compare(s1,s2)){
            case 0 : System.out.println(s1 + " is equal in length than " + s2); break;
            case 1 : System.out.println(s1 + " is bigger in length than " + s2); break;
            case -1 : System.out.println(s1 + " is less in length than " + s2); break;
            case -2 : System.out.println("Length compare failed!"); break;
        }

        Comparator<String> stringComparatorWithLambda =
                (String o1, String o2) ->{ int count1, count2;
                    count1 = Main.countVowels(o1);
                    count2 = Main.countVowels(o2);
                    return Integer.compare(count1,count2);
                };
        array.sort(stringComparatorWithLambda);
        System.out.println("Array of strings sorted by number of vowels: ");
        for(String s: array){
            System.out.println(s);
        }
        Comparator<Integer> integerComparatorAnnonymousClass = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int digitsOk1, digitsOk2;
                digitsOk1= Main.countDigitsBiggerThan5(o1);
                digitsOk2= Main.countDigitsBiggerThan5(o2);
                return Integer.compare(digitsOk1,digitsOk2);
            }
        };
        arrayInteger.sort(integerComparatorAnnonymousClass);
        System.out.println(" \nArray of integers sorted by number of digits bigger than 5: ");
        for(Integer i: arrayInteger){
            System.out.println(i);
        }

        Horse h1 = new Horse();
        h1.run();
        Animal foxObject = new Fox(){
            @Override
            public void run() {
                System.out.println("Foxes don't run!");
            }
        };
        foxObject.run();
        Animal bearObject = () -> System.out.println("Bear runs fast");
        bearObject.run();
    }
    private static int countDigitsBiggerThan5(int n){
        int result= 0;
        while(n != 0) {
            n /= 10;
            if (n > 5) {
                result++;
            }
        }
            return result;
    }
    private static int countVowels(String s){
        int contor=0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'u')
            {
                contor++;
            }
        }
        return contor;
    }

}
