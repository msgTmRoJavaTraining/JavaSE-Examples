package com.msg.examples.se.secondDay;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        ArrayListV1<Double> list =new ArrayListV1<>();
        list.addElement(2.56);
        list.addElement(3.20);
        list.addElement(4.50);
        System.out.println(list.getElement(2));
    }
}
