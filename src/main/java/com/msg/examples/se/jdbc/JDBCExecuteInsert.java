package com.msg.examples.se.jdbc;

import java.sql.*;

public class JDBCExecuteInsert {

  public static void main(String args[]) {
    String dbUrl = "jdbc:mysql://localhost:3306/java_training";
    String user = "java.training", pass = "JavaTraining1";

    // 1. Get a connection to the database and create a statement
    try (Connection connection = DriverManager.getConnection(dbUrl, user, pass);
         Statement statement = connection.createStatement()) {

      // 2. Insert a new employee
      System.out.println("Inserting a new employee to database\n");
      int rowsAffected = statement.executeUpdate(
              "insert into employees " +
                      "(last_name, first_name, email, department, salary) " +
                      "values " +
                      "('Wright', 'Eric', 'eric.wright@foo.com', 'HR', 33000.00)");
      System.out.println("Inserted " + rowsAffected + " rows in the database.");

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
