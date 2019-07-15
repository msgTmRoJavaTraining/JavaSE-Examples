package com.msg.examples.se.io;



import java.io.*;

public class Car implements Serializable {
    private static final long serialversionUID =
            129348938L;
    transient int a;
    static int doorNumber;
    String type;
    String color;
    int age;

    // Default constructor
    public Car(String type, int age, int a, String color,int doorNumber) {
        this.type = type;
        this.age = age;
        this.a = a;
        this.color = color;
        this.doorNumber = doorNumber;
    }

}

