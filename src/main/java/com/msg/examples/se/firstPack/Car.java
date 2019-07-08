package com.msg.examples.se.firstPack;

public class Car
{
    private int numberOfSeats;
    private String color;

    public Car()
    {
        this.color="black";
        this.numberOfSeats=4;
    }

    public Car(String color) {
        this.color = color;
        this.numberOfSeats=4;
    }

    public Car(int numberOfSeats, String color) {
        this.numberOfSeats = numberOfSeats;
        this.color = color;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {

        Car c1=new Car();
        Car c2=new Car("red");
        Car c3=new Car(7,"white");

        System.out.println("Color: "+c1.getColor() +" - number of seats: "+ c1.getNumberOfSeats());
        System.out.println("Color: "+c2.getColor() +" - number of seats: "+ c2.getNumberOfSeats());
        System.out.println("Color: "+c3.getColor() +" - number of seats: "+ c3.getNumberOfSeats());
    }
}
