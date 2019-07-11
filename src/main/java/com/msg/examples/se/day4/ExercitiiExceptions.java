package com.msg.examples.se.day4;

import com.msg.examples.se.exceptions.AvoidExceptionMasking;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class ExercitiiExceptions {
    private static final Logger LOGGER = Logger.getLogger(AvoidExceptionMasking.class.getPackage().getName());

    public static void main(String[] args) {
        int counter = 1;
        ArrayList<FileModel> propozitii = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("C:\\Users\\astana\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\day4\\input.txt"))){
            while(scanner.hasNext()) {
                try {
                    String line = scanner.nextLine();
                    if(line.contains("-")) {
                        String[] parts = line.split("-");

                        propozitii.add(new FileModel(counter, parts[0]));
                        propozitii.add(new FileModel(counter, parts[1]));

                        getShortestSentenceForLine(propozitii, counter++);
                    } else {
                        throw new InvalidLineFormatException("Format invalid detectat!", line, counter);
                    }
                } catch (InvalidLineFormatException e) {
                    LOGGER.warning("ERROR ON LINE: " + e.getLineNumber() + " -> " + e.getGivenSentence());
                }
            }

        } catch (FileNotFoundException e) {
            e.getLocalizedMessage();
        }
    }

    private static void getShortestSentenceForLine(ArrayList<FileModel> propozitii, int counter) {
            FileModel message = propozitii.stream().filter(x -> x.getLine() == counter).min(Comparator.comparing(x -> x.getMessage().length())).get();
            System.out.println(message.getMessage() + ", linia " + counter + ", " + message.getMessage().length() + " caractere");
    }
}
