package com.msg.examples.se.exceptions.ExercitiiExceptii;

import com.sun.media.sound.InvalidFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(InvalidLineFormatException.class.getPackage().getName());

    private static int linie=0;

    public static void printingSentence()  throws InvalidLineFormatException
    {
        try(Scanner scanner=new Scanner(new File("C:\\Users\\hachb\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\exceptions\\ExercitiiExceptii\\input")))
        {
            while (scanner.hasNext())
            {

                String s=scanner.nextLine();
                if(!s.contains("-")) throw new InvalidLineFormatException("Avem o singura propozitie");
                else
                {
                    String array[]=s.split("-");

                    if(array[0].length()<array[1].length())
                    {
                        System.out.println(array[0]);
                        linie++;
                    }
                    else {
                        System.out.println(array[1]);
                        linie++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        try {
            printingSentence();
          }
        catch (InvalidLineFormatException e)
        {
            System.out.println(e);
            int a=linie+1;
            LOGGER.severe("Info Log at line "+a);
        }
    }
}
