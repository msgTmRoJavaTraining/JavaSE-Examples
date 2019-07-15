package com.msg.examples.se.io;

import java.io.*;



    public class SerAndDeser{
        public static void printdata(Car object1) {

            System.out.println("type = " + object1.type);
            System.out.println("age = " + object1.age);
            System.out.println("a = " + object1.a);
            System.out.println("color = " + object1.color);
            System.out.println("door number = " + object1.doorNumber);
        }

        public static void main(String[] args) {
            Car object = new Car("Ford",20,2,"rosu",4);
            String filename = "shubham.txt";


            try{

                // Saving of object in a file
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);

                // Method for serialization of object
                out.writeObject(object);

                out.close();
                file.close();

                System.out.println("Object has been serialized\n"+ "Data before Deserialization.");
                printdata(object);

                // value of static variable changed
                object.doorNumber = 2000;
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


