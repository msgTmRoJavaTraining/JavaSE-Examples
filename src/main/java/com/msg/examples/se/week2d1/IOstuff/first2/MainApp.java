package com.msg.examples.se.week2d1.IOstuff.first2;



import java.io.*;

public class MainApp {
    static void printCar(Car car) {
        System.out.println(car.getColor() + " " + car.getMarca() + " " + car.getSeats() + " " + car.getCid());

    }

    public static void main(String[] args) throws IOException {
        FileInputStream rdr = new FileInputStream("ex1file");
        int buffer = (int) new File("ex1file").length();
        byte[] byteArr = new byte[buffer];
        rdr.read(byteArr);
        String words = new String(byteArr);
        System.out.println(words);

        Car car1 = new Car("Audi", 5, "red", "ssidsa");
        Car car2 = new Car("Dacia", 5, "green", "oihi");

        String seriFile = "serialz.txt";
        try {
            FileOutputStream file = new FileOutputStream(seriFile);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(car1);
            out.close();
            file.close();

            System.out.println("Object has been serialized\n" + "Data before Deserialization.");
            printCar(car1);
            System.out.println(Car.getSerialversionUID());
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        try {
            FileInputStream file = new FileInputStream(seriFile);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            car1 = (Car) in.readObject();
            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                    + "Data after Deserialization.");
            printCar(car1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
