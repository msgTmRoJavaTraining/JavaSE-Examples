package com.msg.examples.se.thirdDay;

import java.util.*;

public class Probleme {

    public static int vocale(String s) {
        int vowels = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                vowels++;
        }
        return vowels;
    }

    public static int digitsBiggerThanFive(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 10 > 5)
                count++;
            n = n / 10;
        }
        return count;
    }


    public static void main(String[] args) {
        ComparatorOne c1 = new ComparatorOne();


        if (c1.compare("Ana", "Ioana") == 1) {
            System.out.println("Ana e mai mare decat Ioana");
        }
        ;
        if (c1.compare("Ana", "Ioana") == -1) {
            System.out.println("Ana e mai mic decat Ioana");
        }
        ;
        if (c1.compare("Ana", "Ioana") == 0) {
            System.out.println("Ana e egal cu Ioana");
        }
        ;

        Comparator<String> c2 = (String s1, String s2) ->
                Integer.compare(vocale(s1), vocale(s2));

        ArrayList<String> s = new ArrayList<>(3);
        s.add("ana");
        s.add("ababbse");
        s.add("elmnk");
        s.add("aeiomddg");

        s.sort(c2);
        System.out.println(s);


        Comparator<Integer> c3 = new Comparator<Integer>(){
            @Override
           public int compare(Integer n1,Integer n2){
               return Integer.compare(digitsBiggerThanFive(n1),digitsBiggerThanFive(n2));
           }
       };

        ArrayList <Integer> a = new ArrayList<>();
        a.add(6789);
        a.add(67);
        a.add(6);

        a.sort(c3);
        System.out.println(a);


    }
}
