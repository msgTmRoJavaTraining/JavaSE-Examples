package com.msg.examples.se.dayFour;

import com.msg.examples.se.exceptions.AvoidExceptionMasking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;

public class MyExceptions {
    private static final Logger LOGGER = Logger.getLogger(MyExceptions.class.getPackage().getName());


    public static void main(String[] args) {
        int count=1;
        try (Scanner scanner = new Scanner(new File("C:\\Users\\leucul\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\dayFour\\input.txt"))) {
            while (scanner.hasNext()) {
                String s1 = scanner.nextLine();
                count++;


                if(!s1.contains("-")){
                    throw new InvalidLineFormatException(s1);
                }
                String linie = scanner.nextLine();


                String[] propozitie = linie.split("-");
                if(propozitie[0].length()>propozitie[1].length())
                    System.out.println(propozitie[1]);
                else{
                    System.out.println(propozitie[0]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(InvalidLineFormatException e){
            LOGGER.severe(String.valueOf(count));
            System.out.println(e.getMessage());
        }
    }
}

