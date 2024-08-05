package com.satge.satge;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database!");
            e.printStackTrace();
        }
    }
}
