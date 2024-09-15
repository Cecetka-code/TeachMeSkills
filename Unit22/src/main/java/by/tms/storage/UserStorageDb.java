package by.tms.storage;

import by.tms.entity.User;
import by.tms.jdbcConnection.JdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserStorageDb {

    private static final String SELECT_ALL = "SELECT * FROM table";

    private static final String INSERT = "INSERT INTO table (name, username, password) VALUES (?, ?, ?)";

    private static final String DELETE = "DELETE FROM table WHERE username=? AND password=?";

    private static final String SELECT_BY_USER = "SELECT * FROM table WHERE username=?";

    private static final String UPDATE = "UPDATE table SET name=?, password=? WHERE username=?";

    private final JdbcConnection connection = new JdbcConnection();


    public boolean save(User user) {
        try (Connection con = connection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            int result = preparedStatement.executeUpdate();
            return result!=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<User> selectAll(){
        List<User> list = new ArrayList<>();
        try (Connection con = connection.getConnection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()) {
                User temp= new User();
                temp.setUsername(resultSet.getString("username"));
                temp.setPassword(resultSet.getString("password"));
                temp.setName(resultSet.getString("name"));
                list.add(temp);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public User find(String username) {
        User user = null;
        try (Connection con = connection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(SELECT_BY_USER)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            user=new User();
            while (resultSet.next()) {
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public boolean delete(User user) {
        try (Connection con = connection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(DELETE)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            return preparedStatement.executeUpdate()!=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(User user, String newName, String newPassword){
        try (Connection con = connection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newPassword);
            preparedStatement.setString(3, user.getUsername());
            return preparedStatement.executeUpdate()!=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
