package com.msg.examples.se.fifthDay.mySql;

import java.sql.*;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from employees");
        rs.next();
            for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
            System.out.println(rs.getMetaData().getColumnName(i));
        String deletedN="";
        CallableStatement cst;
        cst=con.prepareCall("{call delete_employees_above(?,?)}");
        cst.setDouble(1,55000);
        cst.registerOutParameter(2,Types.VARCHAR);
        cst.execute();

        deletedN=cst.getString(2);

        System.out.println(deletedN);



    }
}
