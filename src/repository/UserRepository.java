package repository;
import model.User;
import java.sql.*;
import java.util.*;

public class UserRepository {

    public static List<User> getAllUsers(){
        LoadRepository.loadProperties();
        List<User> users = new ArrayList<>();
        String sql = "SELECT *FROM users";
        try(
                Connection connection = DriverManager.getConnection(
                        LoadRepository.properties.getProperty("database_url"),
                        LoadRepository.properties.getProperty("database_username"),
                        LoadRepository.properties.getProperty("database_password")
                );
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
                )
        {
            while (resultSet.next()){
                users.add(
                    new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("user_uuid"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_email"),
                        resultSet.getString("user_password"),
                        resultSet.getBoolean("is_deleted"),
                        resultSet.getBoolean("is_verified")
                    )
                );
            }
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return users;
    }
    public static List<User> createUser() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input Name : ");
            String name = scanner.nextLine();
            System.out.print("Input Email : ");
            String email = scanner.nextLine();
            System.out.print("Input Password : ");
            String password = scanner.nextLine();

            // Load database properties
            LoadRepository.loadProperties();
            // UUID
            UUID uuid = UUID.randomUUID();


            // Establish connection
            try (Connection connection = DriverManager.getConnection(
                    LoadRepository.properties.getProperty("database_url"),
                    LoadRepository.properties.getProperty("database_username"),
                    LoadRepository.properties.getProperty("database_password"))) {

                // Prepare statement
                String sql = "INSERT INTO users (user_uuid, user_name, user_email, user_password) VALUES (?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setObject(1, uuid);
                    statement.setString(2, name);
                    statement.setString(3, email);
                    statement.setString(4, password);

                    // Execute the query
                    statement.executeUpdate();
                }
            }
            System.out.println("User created successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

}
