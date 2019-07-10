package com.msg.examples.se.thirdDay;

import java.util.Comparator;

public class MyStringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return Integer.compare(str1.length(), str2.length());
    }
}
