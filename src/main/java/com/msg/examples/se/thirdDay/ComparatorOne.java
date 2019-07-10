package com.msg.examples.se.thirdDay;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorOne implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }

}










