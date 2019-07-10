package com.msg.examples.se.thirdDay;

import java.util.Comparator;

public class NumberOfVowels implements Comparator<String> {


    public static int noVowel(String str) {
        String vowel = "AEIOUaeiou";

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (vowel.indexOf(str.charAt(i)) != -1)
                count++;
        }
        return count;
    }


    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(NumberOfVowels.noVowel(o1),NumberOfVowels.noVowel(o2));

    }
}