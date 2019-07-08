package com.msg.examples.se.firstDay;

public class Car {

    private int seatsNumber;
    private String color;

    public Car(){
        seatsNumber=4;
        color="Black";
    }

    public Car(String color){
        this.color=color;
        seatsNumber=4;
    }


    public Car(String color,int seatsNumber){
        this.color=color;
        this.seatsNumber=seatsNumber;
    }

    public String toString(){
        return "Car" + " " +color + " "+seatsNumber;
    }

    public static void main(String[] args){

        Car c1=new Car();
        Car c2=new Car("Red");
        Car c3=new Car("Blue",5);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());


    }


}
