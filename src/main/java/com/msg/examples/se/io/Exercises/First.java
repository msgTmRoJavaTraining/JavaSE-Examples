package com.msg.examples.se.io.Exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class First {
    public static void main(String[] args) {
        byte[] array;
        String fileContent;
        File file;

        try {
            file = new File("fileToRead.txt");
            array = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(array);
            fileContent = new String(array);
            System.out.println(fileContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Verifica fisierul");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
