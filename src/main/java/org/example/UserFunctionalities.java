package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
public class UserFunctionalities {



    public void AddUser(UserProfile userProfile) {
        String insertQuery = "INSERT INTO UserProfile (id, FirstName, LastName, Age) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, userProfile.getId());
            preparedStatement.setString(2, userProfile.GetFirstName());
            preparedStatement.setString(3, userProfile.GetLastName());
            preparedStatement.setInt(4, userProfile.GetAge());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void CreateTask(Task task)
    {
        String insertQuery = "INSERT INTO Task (id ,  description  ,  from_date , to_date ,  status , category_name ,  category_id , user_id) VALUES (?, ?, ?, ? , ? , ? , ? , ?)";

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, task.getId());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setDate(3, Date.valueOf(task.getFrom_date()));
            preparedStatement.setDate(4, Date.valueOf(task.getto_date()));
            preparedStatement.setString(5,task.getStatus().name());
            preparedStatement.setString(6,task.getCategory_name());
            preparedStatement.setInt(7,task.getCategory_id());
            preparedStatement.setInt(8,task.getUserProfile_id());





            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new task was inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DelteTask(int taskid , int user_id){
        String insertQuery = "delete from Task where id = ? and user_id = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1 , taskid);
            preparedStatement.setInt(2 ,user_id );
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Task deleted successfully!");
            } else {
                System.out.println("No task found with the given ID for the specified user.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void UpdateStatus(int taskid , int userid , Status newstatus)
    {
        String insertQuery = " update Task set status = ? where id = ? and user_id = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1 , newstatus.name());
            preparedStatement.setInt(2 ,taskid);
            preparedStatement.setInt(3 ,userid);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Task status updated successfully!");
            } else {
                System.out.println("No task found with the given ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void ViewAllUsers()
    {
        Connection connection = null;
        try {
            // Establish the connection
            connection =ConnectionManager.getConnection();

            String query = "SELECT id, FirstName, LastName   ,Age from UserProfile ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

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
