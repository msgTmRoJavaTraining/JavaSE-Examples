package com.msg.examples.se.io.archive;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

public class ZipStream {

  public static void main(final String[] args) throws IOException {
    final String sourceFile = "JavaSE/src/main/resources";
    final String destinationFile = "JavaSE/src/main/dirCompressed.zip";
    final FileOutputStream fos = new FileOutputStream(destinationFile);
    final ZipOutputStream zipOut = new ZipOutputStream(fos);
    final File fileToZip = new File(sourceFile);

    zipFile(fileToZip, fileToZip.getName(), zipOut);
    zipOut.close();
    fos.close();

    unzipFile(destinationFile);
  }

  private static void zipFile(final File fileToZip, final String fileName, final ZipOutputStream zipOut) throws IOException {
    if (fileToZip.isHidden()) {
      return;
    }
    if (fileToZip.isDirectory()) {
      final File[] children = fileToZip.listFiles();
      for (final File childFile : children) {
        zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
      }
      return;
    }
    final FileInputStream fis = new FileInputStream(fileToZip);
    final ZipEntry zipEntry = new ZipEntry(fileName);
    zipOut.putNextEntry(zipEntry);
    final byte[] bytes = new byte[1024];
    int length;
    while ((length = fis.read(bytes)) >= 0) {
      zipOut.write(bytes, 0, length);
    }
    fis.close();
  }

  private static void unzipFile(String zipFile) throws IOException {
    int buffer = 2048;
    File file = new File(zipFile);

    ZipFile zip = new ZipFile(file);
    String newPath = zipFile.substring(0, zipFile.length() - 4);

    new File(newPath).mkdir();
    Enumeration zipFileEntries = zip.entries();

    while (zipFileEntries.hasMoreElements()) {
      ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
      String currentEntry = entry.getName();
      File destFile = new File(newPath, currentEntry);
      File destinationParent = destFile.getParentFile();
      destinationParent.mkdirs();

      if (!entry.isDirectory()) {
        BufferedInputStream is = new BufferedInputStream(zip.getInputStream(entry));
        int currentByte;

        byte data[] = new byte[buffer];
        FileOutputStream fos = new FileOutputStream(destFile);
        BufferedOutputStream dest = new BufferedOutputStream(fos, buffer);

        while ((currentByte = is.read(data, 0, buffer)) != -1) {
          dest.write(data, 0, currentByte);
        }
        dest.flush();
        dest.close();
        is.close();
      }

      if (currentEntry.endsWith(".zip")) {
        unzipFile(destFile.getAbsolutePath());
      }
    }
  }

}
