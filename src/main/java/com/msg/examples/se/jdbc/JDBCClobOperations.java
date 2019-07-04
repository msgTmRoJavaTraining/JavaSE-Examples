package com.msg.examples.se.jdbc;

import java.io.*;
import java.sql.*;

public class JDBCClobOperations {
  public static void main(String args[]) {
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_training", "java.training", "JavaTraining1")) {
      // Write CLOB to database
      String sql = "update employees set resume_clob=? where email='john.doe@foo.com'";
      PreparedStatement updateStatement = connection.prepareStatement(sql);

      File theFile = new File("./JavaSE/src/resources/sample_resume.txt");
      FileReader updateInput = new FileReader(theFile);
      updateStatement.setCharacterStream(1, updateInput);

      updateStatement.executeUpdate();

      // Read CLOB from database
      Statement selectStatement = connection.createStatement();
      sql = "select resume_clob from employees where email='john.doe@foo.com'";
      ResultSet result = selectStatement.executeQuery(sql);

      if (result.next()) {
        theFile = new File("./JavaSE/src/resources/resume_from_db.txt");
        FileWriter output = new FileWriter(theFile);

        Reader selectInput = result.getCharacterStream("resume_clob");
        int theChar;
        while ((theChar = selectInput.read()) > 0) {
          output.write(theChar);
        }
        output.flush();

        System.out.println("\nSaved to file: " + theFile.getAbsolutePath());
      }
    } catch (SQLException | IOException exc) {
      exc.printStackTrace();
    }
  }
}
