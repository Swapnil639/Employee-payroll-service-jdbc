package com.bridgelabz;

import java.sql.*;

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
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SUM(basic_pay), AVG(basic_pay), MAX(basic_pay), MIN(basic_pay) FROM employee_payroll_details WHERE gender = 'M' GROUP BY gender ");
            while (resultSet.next()) {
                System.out.println("Sum of all basic salary " + resultSet.getDouble("SUM(basic_pay)") + "\n" + "Average of all basic salary " + resultSet.getDouble("AVG(basic_pay)") + "\n" + "Min of all basic salary " + resultSet.getDouble("MIN(basic_pay)") + "\n" + "MAX of all basic salary " + resultSet.getDouble("MAX(basic_pay)"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}