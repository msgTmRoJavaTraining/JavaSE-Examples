package com.msg.examples.se.io;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class FileVisitorEx extends SimpleFileVisitor<Path>
{

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attr) {
        System.out.printf("Begin Directory: %s%n", dir);
        return CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attr)
    {
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

}
