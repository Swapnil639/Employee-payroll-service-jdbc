package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeePayrollService {
    public static void main(String[] args) throws SQLException {
        System.out.println("Status of connecting database to java code: ");

        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "Swapnil123";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection done!!");
        } catch (Exception  e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}