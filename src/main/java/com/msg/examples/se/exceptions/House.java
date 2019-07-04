package com.msg.examples.se.exceptions;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class House {
    public void openDoor() throws IOException {
        System.out.println("door opened");
        throw new IOException("Door opened wrongly");
    }
}

class LittleHouse extends House {
//    @Override
//    public void openDoor() throws Exception {
//        System.out.println("Cannot throw a more general exception");
//    }

//    @Override
//    public void openDoor() throws FileNotFoundException {
//        System.out.println("Can throw a more specific exception");
//    }

//    @Override
//    public void openDoor() throws EOFException, FileNotFoundException {
//        System.out.println("Can throw multiple more specific exceptions");
//    }

//    @Override
//    public void openDoor() {
//        System.out.println("Can omit throwing an exception");
//    }

}

@SuppressWarnings("ALL")
class TestExceptions {
    public static void main(String[] args) {
        try {
            //code that might throw exceptions
            LittleHouse littleHouse = new LittleHouse();
            littleHouse.openDoor();
        } catch (FileNotFoundException | EOFException e) {
            //emergency action for missing files and end of file
        } catch (IOException e) {
            //emergency action for all other I/O problems
            e.printStackTrace();
        }
    }
}

