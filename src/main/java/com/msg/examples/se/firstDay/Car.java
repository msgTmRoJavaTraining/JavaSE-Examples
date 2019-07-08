package com.msg.examples.se.firstDay;

public class Car {
    private int seatNumber;
    private String carColor;

    public Car() {
        carColor = "Black";
        seatNumber = 4;
    }

    public Car(String color) {
        seatNumber = 4;
        carColor = color;
    }

    public Car(int seats, String color) {
        seatNumber = seats;
        carColor = color;
    }

    @Override
    public String toString() {
        return "Car {" +
                "seatNumber=" + seatNumber +
                ", carColor='" + carColor + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("Classic White");
        Car car3 = new Car(7, "Navy Blue");

        System.out.println("Masinile din showroom sunt urmatoarele:\n");
        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(car3.toString());
    }
}
