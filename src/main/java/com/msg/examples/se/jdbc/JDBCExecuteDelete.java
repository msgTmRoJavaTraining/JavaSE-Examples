package com.msg.examples.se.jdbc;

import java.sql.*;

public class JDBCExecuteDelete {

  public static void main(String args[]) {
    String dbUrl = "jdbc:mysql://localhost:3306/java_training";
    String user = "java.training", pass = "JavaTraining1";

    // 1. Get a connection to the database and create a statement
    try (Connection connection = DriverManager.getConnection(dbUrl, user, pass);
         Statement statement = connection.createStatement()) {

      // 2. UPDATE the employee
      System.out.println("\nDELETING THE EMPLOYEE: John Doe\n");

      int rowsAffected = statement.executeUpdate(
              "delete from employees " +
                      "where last_name='Doe' and first_name='John'");
      System.out.println("Deleted " + rowsAffected + " rows in the database.");

      ResultSet resultSet = statement.executeQuery("select * from employees order by last_name");
      while (resultSet.next()) {
        System.out.println(resultSet.getString("last_name") + ", " + resultSet.getInt(6));
      }

      resultSet.close();
    } catch (SQLException exc) {
      exc.printStackTrace();
    }
  }
}
