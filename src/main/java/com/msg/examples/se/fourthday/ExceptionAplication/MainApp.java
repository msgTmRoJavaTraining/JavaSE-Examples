package com.msg.examples.se.fourthday.ExceptionAplication;

import com.msg.examples.se.exceptions.AvoidExceptionMasking;

import java.io.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Logger;

public class MainApp {

    private static final Logger LOGGER = Logger.getLogger(MainApp.class.getPackage().getName());

    public static void main(String args[])  {
        String str="";
        int contor=-1;

    try(BufferedReader rdr=new BufferedReader(new InputStreamReader(new FileInputStream("Fis.txt")))) {
        while ((str=rdr.readLine())!=null){
                contor++;
            try {
                if (str.contains("-") != true)
                    throw new InvalidLineFormatException(str,contor);
                else {
                    String[] part = str.split("-");
                    if (part[0].length() > part[1].length()) System.out.println(part[1]);
                    else if (part[0].length() < part[1].length()) System.out.println(part[0]);
                    else System.out.println("Egale");
                }
            }
            catch(InvalidLineFormatException e) {
                System.out.println(e.getMessage());
                LOGGER.info(e.getMessage());
            }
            }
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


    }
}

