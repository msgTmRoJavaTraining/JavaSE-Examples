package com.msg.examples.se.interfaces;

public class Horse implements Animal {
    public void run() {
        System.out.println("This horse is running");
    }

}
class AnonymusAnimal
{
    public static void main(String[] args)
    {
        Animal fox=new Animal() {
            @Override
            public void run() {
                System.out.println("This fox is running");
            }
        };

        Animal bear= () -> System.out.println("This bear is runnig");


        Animal horse = new Horse();
        horse.run();
        bear.run();

        fox.run();
    }
}

