//package com.msg.examples.se.io;
//
//import java.io.IOException;
//import java.nio.file.*;
//import java.nio.file.attribute.BasicFileAttributes;
//
//import static java.nio.file.FileVisitResult.CONTINUE;
//
//public class FileVisitorEx extends SimpleFileVisitor<Path> {
//
//    @Override
//    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attr) {
//        System.out.printf("Begin Directory: %s%n", dir);
//        return CONTINUE;
//    }
//
//    @Override
//    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
//
//        //file.getFileName().toString().contains(".log");
//        if (attr.isSymbolicLink()) {
//
//
//            System.out.printf("Symbolic link: %s ", file);
//        } else if (attr.isRegularFile()) {
//            System.out.printf("Regular file: %s ", file);
//        } else {
//            System.out.printf("Other: %s ", file);
//        }
//        System.out.println("(" + attr.size() + "bytes)");
//        return CONTINUE;
//    }
//
//    public static void main(String[] args) {
//
//        try {
//            Path startingDir = Paths.get("..");
//            Files.walkFileTree(startingDir, new FileVisitorEx());
//        } catch (IOException ex) {
//            System.out.println(ex);
//        }
//    }
//}

package com.msg.examples.se.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

import static java.nio.file.FileVisitResult.CONTINUE;

class FiliVisitor extends SimpleFileVisitor<Path> {

    private static String readLineByLineJava8(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public static void main(String[] args) {

        try {

            Path startingDir = Paths.get("..");
            Files.walkFileTree(startingDir, new FiliVisitor());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {


        String path1 = "C:\\Users\\hachb\\IdeaProjects\\JavaSE-Examples\\one.log";
        String path2 = "C:\\Users\\hachb\\IdeaProjects\\JavaSE-Examples\\two.log";
        String path3 = "C:\\Users\\hachb\\IdeaProjects\\JavaSE-Examples\\three.log";


        BufferedWriter writer = new BufferedWriter(new FileWriter("file3.txt"));

        if (file.toString().contains(".log")) {
            String s = "";
            if (readLineByLineJava8(path1).contains("Exception")) {
                s = readLineByLineJava8(path1);
            }
            if (readLineByLineJava8(path2).contains("Exception")) {
                s = s.concat(readLineByLineJava8(path2));
            }
            if (readLineByLineJava8(path3).contains("Exception")) {

                s = s.concat(readLineByLineJava8(path3));
                System.out.println(s);

            }

            writer.write(s);
            writer.close();
        }

        return CONTINUE;
    }
}