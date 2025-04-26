package org.dao;

import org.dto.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "htc2009noch";

        try (Connection connection =  DriverManager.getConnection(url, username, password)){
            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            employeeDAO.clearTable();

            employeeDAO.add(new Employee("Ivan", 32, "developer", 1500.0f));
            employeeDAO.add(new Employee("Dmytro", 52, "manager", 2100.0f));
            System.out.println(employeeDAO.getAll());

            employeeDAO.updateEmployee(new Employee(1, "Ivan", 35, "senior developer", 2000.0f));
            System.out.println(employeeDAO.getAll());

            employeeDAO.deleteEmployee(2);
            System.out.println(employeeDAO.getAll());
        }
    }
}
