package com.msg.examples.se.thirdDay;

import java.util.Comparator;

public class ComparatorForStrings implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int returnval=-2;
        if(s1.length()== s2.length()) {
            returnval= 0;
        }else if(s1.length()>s2.length()){
            returnval= 1;
        }else if(s1.length()<s2.length()){
            returnval= -1;
        }
        return returnval;
    }



}
