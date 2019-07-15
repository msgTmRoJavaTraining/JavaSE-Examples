package com.msg.examples.se.io.Exercises;

import java.io.*;

class Car implements Serializable{
    String brand;
    int year;
    float maxSpeed;
    transient double length;

    public Car(String brand, int year, float maxSpeed, double length) {
        this.brand = brand;
        this.year = year;
        this.maxSpeed = maxSpeed;
        this.length = length;
    }
}

public class Second {
    public static void printdata(Car object1) {

        System.out.println("Brand = " + object1.brand);
        System.out.println("Year = " + object1.year);
        System.out.println("Speed limit = " + object1.maxSpeed);
        System.out.println("Length = " + object1.length);
    }

    public static void main(String[] args) {
        Car object = new Car("BMW", 2015, 250, 2756.50);
        String filename = "cars.txt";

        // Serialization
        try {

            // Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized\n"+ "Data before Deserialization.");
            printdata(object);

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        object = null;

        // Deserialization
        try {

            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object = (Car) in.readObject();

            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                    + "Data after Deserialization.");
            printdata(object);

            // System.out.println("z = " + object1.z);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                    " is caught");
        }
    }
}
