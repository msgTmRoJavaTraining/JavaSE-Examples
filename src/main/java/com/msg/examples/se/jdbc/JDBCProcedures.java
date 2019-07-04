package com.msg.examples.se.jdbc;

import java.sql.*;

public class JDBCProcedures {

  public static void main(String args[]) {
    String department = "Engineering";
    Connection connection = null;
    CallableStatement statement = null;
    ResultSet resultSet = null;

    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_training", "java.training", "JavaTraining1");

      // Call stored procedure get_count_for_department
      statement = connection.prepareCall("{call get_count_for_department(?, ?)}");
      statement.setString(1, department);
      statement.registerOutParameter(2, Types.INTEGER);
      statement.execute();

      int theCount = statement.getInt(2);
      System.out.println("\nThe count = " + theCount + "\n");

      // Call stored procedure get_employees_for_department
      statement = connection.prepareCall("{call get_employees_for_department(?)}");
      statement.setString(1, department);
      statement.execute();

      resultSet = statement.getResultSet();
      JDBCUtil.display(resultSet);

      // Call stored procedure greet_the_department
      statement = connection.prepareCall("{call greet_the_department(?)}");
      statement.registerOutParameter(1, Types.VARCHAR);
      statement.setString(1, department);
      statement.execute();

      String theResult = statement.getString(1);
      System.out.println("\nThe result = " + theResult);

      // Call stored procedure increase_salaries_for_department
      statement = connection.prepareCall("{call increase_salaries_for_department(?, ?)}");
      statement.setString(1, department);
      statement.setDouble(2, 10000);
      statement.execute();

      System.out.println("\nSalaries AFTER");
      JDBCUtil.showSalaries(connection, department);
    } catch (SQLException exc) {
      exc.printStackTrace();
    } finally {
      JDBCUtil.close(connection, statement, resultSet);
    }
  }

}
