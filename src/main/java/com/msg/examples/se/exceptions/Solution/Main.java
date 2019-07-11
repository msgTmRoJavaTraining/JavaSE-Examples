package com.msg.examples.se.exceptions.Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class Main {
    public static void main(String[] args) {
        String line;
        String[] sentences;
        String firstSentence;
        String secondSentence;
        int line_number = 0;

        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                try {
                    if (!line.contains("-")) throw new InvalidLineFormatException(line);
                    else {
                        sentences = line.split("-");
                        firstSentence = sentences[0];
                        secondSentence = sentences[1];
                        if (firstSentence.length() < secondSentence.length()) {
                            System.out.println("The shortest sentence for line " + line_number + " is: " + firstSentence);
                        } else {
                            System.out.println("The shortest sentence for line " + line_number + " is: " + secondSentence);
                        }
                        line_number++;
                    }
                    System.out.println();
                } catch (InvalidLineFormatException e) {
                    System.out.println(e.getMessage());
                    LOGGER.warning("Line number: "+line_number);
                }
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
