package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresConnection {

    // Database credentials
    private static final String URL = "jdbc:postgresql://localhost:5432/TaskManagement";
    private static final String USER = "postgres";
    private static final String PASSWORD = "levi_ackerman";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //System.out.println("Connected to the PostgreSQL server successfully.");

            // Example: Query the database
            //String query = "SELECT id, status, category_name  from Task where user_id = 2";
            String query = "SELECT id, FirstName, LastName   ,Age from UserProfile ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the results
            /*while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String status = resultSet.getString("status");
                String category_name = resultSet.getString("category_name");

                System.out.println("User ID: " + id + ", status: " + status + ", category_name: " + category_name );
            }*/
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                int Age = resultSet.getInt("Age");
                System.out.println("User ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName + ", Age "+Age);
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to PostgreSQL database");
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
