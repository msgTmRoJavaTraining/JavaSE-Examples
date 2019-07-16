package com.msg.examples.se.DaySix;

import com.msg.examples.se.io.JohnyFileWalker;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class VisitAllFiles extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attr) {
        System.out.printf("Begin Directory: %s%n", dir);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
        if(file.toString().contains(".log")){

            FileInputStream fis = new FileInputStream(String.valueOf(file));
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            String line=null;
            StringBuilder s = new StringBuilder();

            while ((line = in.readLine()) != null) {
                s.append(line);
                line = in.readLine();
            }
            String string= s.toString();

                BufferedWriter writer = new BufferedWriter(new FileWriter("final.txt",true));
                writer.append(string);
                writer.append("\n");
                writer.close();
            }

        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException ex) {
        System.out.printf("End Directory: %s%n%n", dir);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException ex) {
        System.out.println(ex);
        return CONTINUE;  // or TERMINATE
    }

    public static void main(String[] args) {
        try {
            Path startingDir = Paths.get("..");
            Files.walkFileTree(startingDir, new VisitAllFiles());
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

}
