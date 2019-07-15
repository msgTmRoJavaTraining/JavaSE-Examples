package com.msg.examples.se.Day6;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class FileVisitor extends SimpleFileVisitor<Path> {
    File finalFile = new File("C:\\Users\\nicoll\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\Day6\\LogFile.txt");

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        String fileName = file.getFileName().toString();
        if (fileName.contains(".log")) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file.toString()));
                String data = br.readLine();
                BufferedWriter bw = new BufferedWriter(new FileWriter(finalFile,true));
                bw.append(data + "\n");
                bw.close();
                br.close();

            } catch (IOException e) {
                e.printStackTrace();


            }

        }
        return CONTINUE;
    }
}

