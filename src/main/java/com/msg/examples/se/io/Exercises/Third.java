package com.msg.examples.se.io.Exercises;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Third {
    public static final String CURRENTDIRECTORY="C:\\Users\\mihaer\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\io\\Exercises\\";
    public static void main(String[] args) throws IOException {
        try {
            throw new FileNotFoundException("Exception: FileNotFound");
        } catch (FileNotFoundException e) {
            byte[] message = e.getMessage().getBytes();
            byte[] stackTrace = (e.getStackTrace().toString()+"\n").getBytes();
            FileOutputStream out = new FileOutputStream(CURRENTDIRECTORY+"FNFE.log");
            out.write(message);
            out.write(stackTrace);
        }

        try {
            throw new IndexOutOfBoundsException("Exception: IndexOutOfBounds");
        } catch (IndexOutOfBoundsException e) {
            byte[] message = e.getMessage().getBytes();
            byte[] stackTrace = (e.getStackTrace().toString()+"\n").getBytes();
            FileOutputStream out = new FileOutputStream(CURRENTDIRECTORY+"IOBE.log");
            out.write(message);
            out.write(stackTrace);
        }

        try {
            throw new ArithmeticException("\nException: Arithmetic");
        } catch (ArithmeticException e) {
            byte[] message = e.getMessage().getBytes();
            byte[] stackTrace = (e.getStackTrace().toString()+"\n").getBytes();
            FileOutputStream out = new FileOutputStream(CURRENTDIRECTORY+"AE.log");
            out.write(message);
            out.write(stackTrace);

        }

        Path startingDir = Paths.get(CURRENTDIRECTORY);
        FileOutputStream out = new FileOutputStream(CURRENTDIRECTORY+"TOTAL.log");
        Files.walkFileTree(startingDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                if(file.toString().contains(".log")&&(!file.toString().contains("TOTAL")))
                {
                    File fileToRead = new File(file.toString());
                    byte[] array = new byte[(int) fileToRead.length()];
                    FileInputStream fis = new FileInputStream(fileToRead);
                    fis.read(array);
                    out.write(array);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
