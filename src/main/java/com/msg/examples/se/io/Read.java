package com.msg.examples.se.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Read
{

    public static void main(String[] args) throws IOException{

        byte[] buffer = new byte[200];
        char c;
        try {

            File initialFile = new File("C:\\Users\\hachb\\IdeaProjects\\JavaSE-Examples\\target\\inputuri.txt");
            InputStream targetStream = new FileInputStream(initialFile);

            targetStream.read(buffer, 0, 200);

            for (byte b : buffer) {

                    c = (char) b;

                System.out.print(c);
            }
        }
            catch (IOException e)
            {

            }
    }

}
