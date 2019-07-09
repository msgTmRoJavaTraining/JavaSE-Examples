package com.msg.examples.se.firstDay;

public class Car {
    private int seats;
    private String color;


    public Car()
    {
        this.seats=4;
        this.color="black";
    }
    public Car(String color)
    {
        this.color=color;
        this.seats=4;
    }
    public Car(int seats,String color)
    {
        this.seats=seats;
        this.color=color;
    }

    public int getSeats() {
        return seats;
    }

    public String getColor() {
        return color;
    }
}
