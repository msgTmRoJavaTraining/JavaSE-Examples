package com.msg.examples.se.jdbc;

import java.sql.*;

public class JDBCUtil {

  public static void showSalaries(Connection connection, String department) throws SQLException {
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
      statement = connection.prepareStatement("select * from employees where department=?");
      statement.setString(1, department);

      resultSet = statement.executeQuery();
      display(resultSet);
    } catch (Exception exc) {
      exc.printStackTrace();
    }
  }

  public static void display(ResultSet myRs) throws SQLException {
    while (myRs.next()) {
      String lastName = myRs.getString("last_name");
      String firstName = myRs.getString("first_name");
      double salary = myRs.getDouble("salary");
      String department = myRs.getString("department");

      System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, department, salary);
    }
  }

  public static void close(Connection myConn, Statement myStmt,
                            ResultSet myRs) {
    try {
      if (myRs != null) {
        myRs.close();
      }

      if (myStmt != null) {
        myStmt.close();
      }

      if (myConn != null) {
        myConn.close();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
