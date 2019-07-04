package com.msg.examples.se.jdbc;

import java.io.*;
import java.sql.*;

public class JDBCBlobOperations {
  public static void main(String args[]) {
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_training", "java.training", "JavaTraining1")) {
      // Write BLOB to database
      String sql = "update employees set resume_blob=? where email='john.doe@foo.com'";
      PreparedStatement updateStatement = connection.prepareStatement(sql);

      File theFile = new File("./JavaSE/src/resources/sample_resume.pdf");
      FileInputStream updateInput = new FileInputStream(theFile);
      updateStatement.setBinaryStream(1, updateInput);

      updateStatement.executeUpdate();

      // Read BLOB from database
      Statement selectStatement = connection.createStatement();
      sql = "select resume_blob from employees where email='john.doe@foo.com'";
      ResultSet result = selectStatement.executeQuery(sql);

      if (result.next()) {
        theFile = new File("./JavaSE/src/resources/resume_from_db.pdf");
        FileOutputStream output = new FileOutputStream(theFile);

        InputStream selectInput = result.getBinaryStream("resume_blob");
        byte[] buffer = new byte[1024];
        while (selectInput.read(buffer) > 0) {
          output.write(buffer);
        }

        System.out.println("\nSaved to file: " + theFile.getAbsolutePath());
      }
    } catch (SQLException | IOException exc) {
      exc.printStackTrace();
    }
  }
}
