package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class categoryFunctionalities {

    public void craeteCategory(Category category)
    {
        String insertQuery = "INSERT INTO category (id, name) VALUES ( ?, ?)";

        try (Connection connection =  ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1,category.getId() );
            preparedStatement.setString(2, category.getType());


            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new category was inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
