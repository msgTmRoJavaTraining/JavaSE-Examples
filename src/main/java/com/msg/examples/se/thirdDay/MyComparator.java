package com.msg.examples.se.thirdDay;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {

    @Override
    public int compare(String firstString, String secondString) {
        return Integer.compare(firstString.length(), secondString.length());
    }
}
