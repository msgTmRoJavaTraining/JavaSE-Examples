package com.msg.examples.se.jdbc;

import java.sql.*;

public class JDBCExecuteQuery {

  public static void main(String args[]) {
    String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root", pass = "root";

    // 1. Get a connection to the database and create a statement
    try (Connection connection = DriverManager.getConnection(dbUrl, user, pass);
         Statement statement = connection.createStatement()) {

      // 2. Execute SQL query
      ResultSet resultSet = statement.executeQuery("select * from employees");

      // 3. Process the result set
      while (resultSet.next()) {
        System.out.println(resultSet.getString("last_name") + ", " + resultSet.getInt(6));
      }

      resultSet.close();
    } catch (SQLException exc) {
      exc.printStackTrace();
    }
  }
}
