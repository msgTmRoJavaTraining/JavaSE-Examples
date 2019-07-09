package com.msg.examples.se.secondDay;

import sun.rmi.server.InactiveGroupException;

public class CollectorGenericsTest {
    public static void main(String [] args){
        /*Collector<Integer> myCollection = new Collector<>();
        myCollection.addItem(1);
        myCollection.addItem(2);
        myCollection.addItem(3);
        System.out.print(myCollection.getElement(2));*/
        Collector<Double> myCollection = new Collector<>();
        myCollection.addItem(0.4);
        myCollection.addItem(0.5);
        myCollection.addItem(0.6);
        System.out.print(myCollection.getElement(2));
    }
}
