package com.msg.examples.se.thirdDay;
import java.util.*;

public interface Animal {
    void run();
}
class Horse implements Animal{

    @Override
    public void run() {
        System.out.println("That's how a horse runs");
    }
}

class Anonima{
    public static void main(String [] args){

        Horse horse=new Horse();
        horse.run();

        Animal fox=new Animal(){
            @Override
            public void run(){
                System.out.println("Fox runs");
            }
        };
        fox.run();

        Animal bear=()-> System.out.println("Bear runs");
        bear.run();
        }
}


