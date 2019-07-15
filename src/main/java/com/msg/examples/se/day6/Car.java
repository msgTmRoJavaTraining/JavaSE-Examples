package com.msg.examples.se.day6;

import java.io.Serializable;

public class Car implements Serializable {
    private static final long serialversionUID = 123456777L;
    private String Brand;
    private double Price;
    private boolean hasSpareWheel;
    private int NumberOfSeats;
    transient int NumberOfDoors;

    public Car(String brand, double price, boolean hasSpareWheel, int numberOfSeats, int numberOfDoors) {
        Brand = brand;
        Price = price;
        this.hasSpareWheel = hasSpareWheel;
        NumberOfSeats = numberOfSeats;
        NumberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Brand='" + Brand + '\'' +
                ", Price=" + Price +
                ", hasSpareWheel=" + hasSpareWheel +
                ", NumberOfSeats=" + NumberOfSeats +
                ", NumberOfDoors=" + NumberOfDoors +
                '}';
    }
}
