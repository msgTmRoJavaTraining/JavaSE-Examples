package com.msg.examples.se.firstDay;

public class Car {
    private int noSeats;
    private String color;
    public Car(){
        this.noSeats = 4;
        this.color = "black";
    }
    public Car(String color){
        this.noSeats = 4;
        this.color = color;
    }
    public Car(int noSeats, String color){
        this.noSeats= noSeats;
        this.color= color;
    }

    public int getNoSeats() {
        return noSeats;
    }

    public String getColor() {
        return color;
    }

    public void setNoSeats(int noSeats) {
        this.noSeats = noSeats;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "noSeats=" + noSeats +
                ", color='" + color + '\'' +
                '}';
    }

}
