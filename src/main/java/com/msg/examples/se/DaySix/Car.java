package com.msg.examples.se.DaySix;

import java.io.*;

public class Car implements Serializable {

    transient int x;
    double speed;
    String color;
    int year;

    public Car(int x,double speed,String color, int year){
        this.x=x;
        this.speed=speed;
        this.color=color;
        this.year=year;
    }
}


