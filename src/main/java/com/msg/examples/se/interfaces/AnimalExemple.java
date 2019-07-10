package com.msg.examples.se.interfaces;
interface Animal{

    void run();
}

class Horse implements Animal{
    @Override
    public void run() {
        System.out.println("Horses run fast");
    }
}
class Fox implements Animal{

    @Override
    public void run() {
        System.out.println("Fox doesn't run");
    }
}
public class AnimalExemple {

    public static void main(String[] args){

        Animal animal1 = new Horse();
        animal1.run();


        Animal animal2 = new Fox(){
            @Override
            public void run(){
                System.out.println("Foxes run when they are attacked");
            }
        };
        animal2.run();


        Animal animal3 = ()->{
            System.out.println("Bears only walk");
        };
        animal3.run();

    }
}
