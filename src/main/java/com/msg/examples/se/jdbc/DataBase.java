package com.msg.examples.se.jdbc;

import java.sql.*;

public class DataBase
{

    public static void main(String[] args) {

        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        String user = "root", pass = "root";

         try (Connection connection = DriverManager.getConnection(dbUrl, user, pass);
              Statement statement = connection.createStatement()) {

             ResultSet resultSet =statement.executeQuery("select * FROM employees");

                 for(int i=1;i<=resultSet.getMetaData().getColumnCount();i++)
                 System.out.println(resultSet.getMetaData().getColumnName(i));

             CallableStatement cst;

             cst=connection.prepareCall("{call delete_employees_with_higher_salary(?,?)}");

             cst.setDouble(1,5000);
             cst.registerOutParameter(2,Types.VARCHAR);
             cst.execute();

             String deletedN="";

             deletedN=cst.getString(2);
             System.out.println(deletedN);

        } catch (SQLException exc) {
            exc.printStackTrace();
        }

    }
}
