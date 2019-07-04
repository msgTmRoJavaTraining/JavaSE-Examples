package com.msg.examples.se.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBCTransactions {

  public static void main(String args[]) {
    String department = "Engineering";
    Connection connection = null;
    CallableStatement statement = null;

    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_training", "java.training", "JavaTraining1");
      connection.setAutoCommit(false);

      System.out.println("Salaries BEFORE\n");
      JDBCUtil.showSalaries(connection, department);

      // Call stored procedure increase_salaries_for_department
      statement = connection.prepareCall("{call increase_salaries_for_department(?, ?)}");
      statement.setString(1, department);
      statement.setDouble(2, 10000);
      statement.execute();

      boolean ok = askUserIfOkToSave();
      if (ok) {
        connection.commit();
        System.out.println("\n>> Transaction COMMITTED.\n");
      } else {
        connection.rollback();
        System.out.println("\n>> Transaction ROLLED BACK.\n");
      }

      System.out.println("Salaries AFTER");
      JDBCUtil.showSalaries(connection, department);
    } catch (SQLException exc) {
      exc.printStackTrace();
    } finally {
      JDBCUtil.close(connection, statement, null);
    }
  }

  private static boolean askUserIfOkToSave() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Is it okay to save?  yes/no: ");
    String input = scanner.nextLine();

    scanner.close();

    return input.equalsIgnoreCase("yes");
  }

}
