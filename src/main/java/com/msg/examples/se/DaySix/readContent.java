package com.msg.examples.se.DaySix;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class readContent {

    public static void main(String[] args) {

        File file = new File("file.txt");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            byte[] bArray = new byte[(int) file.length()];
            int read_count = 0;
            while ((read_count = fis.read(bArray)) > 0) {
                System.out.println(new String(bArray, 0, read_count));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (Exception ex) {
            }
        }

    }
}
