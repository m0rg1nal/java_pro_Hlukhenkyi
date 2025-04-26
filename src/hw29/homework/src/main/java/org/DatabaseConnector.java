package org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    String url = "jdbc:mysql://localhost:3306/company";
    String username = "root";
    String password = "htc2009noch";

    public void connect() throws SQLException {
        try (Connection connection =  DriverManager.getConnection(url, username, password)){
            System.out.println("Connection is successful");
        }
        catch (SQLException e){
            System.out.println("Connection failed");
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed successfully");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Connection close failed");
            }
        }
    }
}
