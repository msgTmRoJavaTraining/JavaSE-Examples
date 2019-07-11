package com.msg.examples.se.dayFour;

import com.msg.examples.se.exceptions.AvoidExceptionMasking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class AnotherException {

    private static final Logger LOGGER = Logger.getLogger(AvoidExceptionMasking.class.getPackage().getName());
    public static void main(String[] s){

        try(Scanner scanner = new Scanner(new File("C:\\Users\\leucul\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\dayFour\\input.txt"))) {

            while (scanner.hasNext()) {

                    String s1 = scanner.nextLine();
                if(!s1.contains("-")){
                    throw new InvalidLineFormatException(s1);
                }
            }
        }
        catch(InvalidLineFormatException e){

            System.out.println(e.getMessage());
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }




    }



}
