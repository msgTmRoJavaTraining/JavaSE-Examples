package com.msg.examples.se.jdbc;

import java.sql.*;

public class DatabaseExercises {

    public static void main(String[] args) {

        String department = "Engineering";
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;
        String str = "";

        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root", pass = "root";
        try {
            connection = DriverManager.getConnection(dbUrl, user, pass);

            PreparedStatement ps=connection.prepareStatement("select * from employees");
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println("Column Name: " + rsmd.getColumnName(i));


                statement = connection.prepareCall("{call delete_employee_specified_amount(?,?)}");
                statement.setDouble(1, 5000);
                statement.registerOutParameter(2, Types.VARCHAR);
                statement.execute();

                 str = statement.getString(2);
            }
        }catch(SQLException exc){
                exc.printStackTrace();
            } finally{
                JDBCUtil.close(connection, statement, resultSet);
            }
             System.out.println(str);
    }
}
