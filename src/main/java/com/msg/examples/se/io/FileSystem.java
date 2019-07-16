package com.msg.examples.se.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class FileSystem {

  public static void main(String args[]) {


    File[] roots = File.listRoots();
    System.out.println(Arrays.toString(roots));

    try {
      File tempFile = File.createTempFile("myTemp", ".tmp");
      System.out.println("Created file: " + tempFile.getAbsolutePath());

      Files.copy(Paths.get(tempFile.getAbsolutePath()), Paths.get(tempFile.getParentFile().getAbsolutePath() + "/copy1_" + tempFile.getName()));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
