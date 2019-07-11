package com.msg.examples.se.day4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainException {
    private static final Logger LOGGER = Logger.getLogger(MainException.class.getPackage().getName());

    public static void main(String []args)  {
        InputStream in = null;
        Exception exception = null;
        String [] lines;
        String minString= "";
        try{
            in = new FileInputStream("C:\\Users\\nicoll\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\day4\\input.txt");
            List<String> content = new ArrayList<>();
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\nicoll\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\day4\\input.txt"));
                String line = reader.readLine();
                int contorLines = 0;
                while(line!= null){
                    String text = line;
                    contorLines +=1;
                    lines = text.split("-");
                    minString = lines[0];
                    try {
                        boolean contains = line.contains("-");
                        if(!contains)throw new InvalidLineFormatException(line);

                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                        LOGGER.severe("Line no" + contorLines);
                    }
                    for (int i = 0;i< lines.length; i++) {
                        content.add(lines[i]);
                        if(lines[i].length()< minString.length() && lines[i]!= null){
                            minString = lines[i];
                        }
                    }
                    System.out.println(minString);
                    line = reader.readLine();
                }
            }
            catch (IOException e)
            {
                System.out.println("File is corrupted!");
            }
        } catch (FileNotFoundException e) {
            exception = e;
        } finally {
            if(exception == null){
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("Can't close file!");
                }
            }
        }
    }
}
