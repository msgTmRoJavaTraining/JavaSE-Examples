package com.msg.examples.se.io;

import lombok.Data;

import java.io.*;

@Data
class Car implements Serializable
{

        int doors;
        String name;
        transient boolean wheels;
        static int passengers;

    public Car(int doors, String name, int wheels,int passengers)
    {
        this.doors = doors;
        this.name = name;
        this.wheels = true;
        Car.passengers=passengers;
    }
}

class SerializationAndDeserialization1
{
    public static void printdata(Car object1) {

        System.out.println("name = " + object1.name);
        System.out.println("doors = " + object1.doors);
        System.out.println("wheels = " + object1.wheels);
        System.out.println("passengers = " + Car.passengers);
    }

    public static void main(String[] args) {

        Car object =new Car(4,"MB",5,5);
        String fileName="car.txt";

        try {
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized\n"+ "Data before Deserialization.");
            printdata(object);

            // value of static variable changed
            Car.passengers = 7;
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        object = null;

        // Deserialization
        try {

            // Reading the object from a file
            FileInputStream file = new FileInputStream(fileName);
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
            System.out.println("ClassNotFoundException" + " is caught");
        }

    }
}
