package com.msg.examples.se.io.ThirdExercise;

import com.msg.examples.se.io.JohnyFileWalker;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class VisitorClass extends SimpleFileVisitor<Path> {



    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\borozi\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\io\\ThirdExercise");
        String strr = "C:\\Users\\borozi\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\io\\ThirdExercise\\concatFile.log";
        StringBuffer str = new StringBuffer(0);
        try {


        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException
            {
                String firstLine = Files.newBufferedReader(file, Charset.defaultCharset()).readLine();
                str.append(firstLine+"\n");
                return FileVisitResult.CONTINUE;
            }
        }); }catch (IOException ex){
            System.out.println(ex);
        }
          System.out.println(str);
        try(FileWriter f1 = new FileWriter(strr)){

            f1.write(str.toString());
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
