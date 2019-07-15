package com.msg.examples.se.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class JohnyFileWalker extends SimpleFileVisitor<Path> {

  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attr) {
    System.out.printf("Begin Directory: %s%n", dir);
    return CONTINUE;
  }

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
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
      Files.walkFileTree(startingDir, new JohnyFileWalker());
    } catch (IOException ex) {
      System.out.println(ex);
    }
  }
}
