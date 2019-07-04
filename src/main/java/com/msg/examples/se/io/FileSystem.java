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
      tempFile.deleteOnExit();

      Path target = Paths.get(".");
      Files.copy(Paths.get(tempFile.getAbsolutePath()), target.resolve(tempFile.getName()), StandardCopyOption.REPLACE_EXISTING);
      Files.move(Paths.get(tempFile.getAbsolutePath()), target.resolve(tempFile.getName() + "-moved"), StandardCopyOption.ATOMIC_MOVE);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
