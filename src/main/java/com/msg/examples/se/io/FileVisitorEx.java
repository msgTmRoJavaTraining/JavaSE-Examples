package com.msg.examples.se.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class FileVisitorEx extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attr) {
        System.out.printf("Begin Directory: %s%n", dir);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {

        //file.getFileName().toString().contains(".log");
        if (attr.isSymbolicLink()) {


            System.out.printf("Symbolic link: %s ", file);
        } else if (attr.isRegularFile()) {
            System.out.printf("Regular file: %s ", file);
        } else {
            System.out.printf("Other: %s ", file);
        }
        System.out.println("(" + attr.size() + "bytes)");
        return CONTINUE;
    }

    public static void main(String[] args) {

        try {
            Path startingDir = Paths.get("..");
            Files.walkFileTree(startingDir, new FileVisitorEx());
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}