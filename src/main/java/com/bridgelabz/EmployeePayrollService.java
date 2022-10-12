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
            statement.execute("insert into employee_payroll(name,department,gender,basic_pay,deduction,taxable_pay,income_tax,net_pay,start)values('Swapnil','marketing','M',3000000.00,1000000.00,2000000.00,5000000.00,1500000.00,'2018-01-03')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_payroll_details");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " | " + resultSet.getString("name") + " | " + resultSet.getString("gender") + " | " + resultSet.getString("phone_number") + " | " + resultSet.getString("address") + " | " + resultSet.getString("department") + " | " + resultSet.getDouble("basic_pay") + " | " + resultSet.getDouble("deductions") + " | " + resultSet.getDouble("taxable_pay") + " | " + resultSet.getDouble("net_pay") + " | " + resultSet.getDouble("income_tax") + " | " + resultSet.getDate("start"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}