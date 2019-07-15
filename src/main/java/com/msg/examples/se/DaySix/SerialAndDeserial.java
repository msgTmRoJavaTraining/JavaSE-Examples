package com.msg.examples.se.DaySix;

import java.io.*;

public class SerialAndDeserial {
    public static void printdata(Car car) {

        System.out.println("color = " + car.color);
        System.out.println("year = " + car.year);
        System.out.println("x = " + car.x);
        System.out.println("speed = " + car.speed);
    }

    public static void main(String[] args) {
        Car car = new Car(10,150.0,"red",2007);
        String filename = "cars.txt";

        // Serialization
        try {
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(car);

            out.close();
            file.close();

            System.out.println("Object has been serialized\n"+ "Data before Deserialization.");
            printdata(car);

            // value of static variable changed
            //car.y = 2000;
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        car = null;

        // Deserialization
        try {

            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            car = (Car) in.readObject();

            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                    + "Data after Deserialization.");
            printdata(car);

            // System.out.println("z = " + object1.z);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                    " is caught");
        }
    }
}
