package com.msg.examples.se.exceptions.subException;



import java.io.*;
import java.util.*;
import java.util.logging.Logger;

class InvalidLineFormatException extends Exception{

    public InvalidLineFormatException(String errorMessage){
        super(errorMessage);
    }
}
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getPackage().getName());
    public static String printMin(List <String> lst){
        int index = 0;
        int length = lst.get(0).length();
        for(String str:lst){
            if(str.length() < length){
                index = lst.indexOf(str);
                length = str.length();
            }
        }
        return lst.get(index);
    }
    public static void main(String[] args) throws Exception{
        List<String> myList = new ArrayList<String>();
        try(Scanner scanner = new Scanner(new File("C:\\Users\\borozi\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\exceptions\\subException\\input.txt"))){

            String line;
            while(scanner.hasNext()){
                line = scanner.nextLine();
                myList.add(line);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        for(String str:myList){

            System.out.println(str);
        }

        System.out.println(Main.printMin(myList));

        String tmpString = "";
        try {
            for (String str : myList) {
                if (!str.contains("-")) {
                    tmpString = str;
                    throw new InvalidLineFormatException("Linie cu Format Invalid");

                }
            }
        }catch (InvalidLineFormatException e){
            LOGGER.severe(tmpString+" at line "+(myList.indexOf(tmpString)+1));
        }



    }
}
