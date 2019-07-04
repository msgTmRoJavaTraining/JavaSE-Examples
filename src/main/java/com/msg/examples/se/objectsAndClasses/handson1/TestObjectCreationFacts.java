package com.msg.examples.se.objectsAndClasses.handson1;

public class TestObjectCreationFacts {

    public static void main(String[] args) {
        House house;

//        System.out.println(house.getColor()); //compile time error - variable not initialized

        House house1 = new House("red", 3);
        System.out.println(house1.getColor());

        house = house1;
        System.out.println(house.getColor());

        house = new House();
        System.out.println("-----------------Empty constructor - no members are explicitly initialized-----------------");
        System.out.println(house.getMonthlyFee());
        System.out.println("-----------------Non-empty constructor - members are initialized-----------------");
        System.out.println(house1.getMonthlyFee());
    }

}

class House {
    private String color;
    private int numberOdResidents;

    House() {
    }

    House(String color, int numberOdResidents) {
        this.color = color;
        this.numberOdResidents = numberOdResidents;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfResidents() {
        return numberOdResidents;
    }

    public int getMonthlyFee() {
        int result;
//        System.out.println("Uninitialized local variable: " + result); //compile time error - not initialized
        System.out.println("Primitive class member: " + numberOdResidents); //it works
        System.out.println("Non-primitive class member: " + color); //it works
        if (numberOdResidents > 2) {
            result = numberOdResidents * 200;
        } else {
            result = numberOdResidents * 100 + 50;
        }
        System.out.println();
        return result;
    }
}
