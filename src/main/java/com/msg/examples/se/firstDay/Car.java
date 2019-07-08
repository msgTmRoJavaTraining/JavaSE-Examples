package com.msg.examples.se.firstDay;

public class Car {
    private String color;
    private int seatsNumber;

    public Car(String color, int seatsNumber) {
        this.color = color;
        this.seatsNumber = seatsNumber;
    }

    public Car(String color) {
        this.color = color;
        this.seatsNumber=4;
    }

    public Car() {
        this.color="black";
        this.seatsNumber=4;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", seatsNumber=" + seatsNumber +
                '}';
    }
}
