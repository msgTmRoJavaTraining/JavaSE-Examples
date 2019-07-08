package com.msg.examples.se.firstDay;

public class Car {

       private int seats;
       private String color;

       public Car(){

           this.seats = 4;
           this.color  = "black";
       }

       public Car(String color){

           this.seats = 4;
           this.color = color;
       }

       public Car(String color,int seats){

           this.color = color;
           this.seats = seats;
       }
       public String toString(){

           return this.color+this.seats;
       }
}
