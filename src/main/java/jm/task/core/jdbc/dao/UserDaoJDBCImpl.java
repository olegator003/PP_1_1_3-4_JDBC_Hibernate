package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection = null;
    Statement statement = null;
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS user " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " name VARCHAR(255), " +
                    " lastname VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            statement.executeUpdate(sql);
            System.out.println("Table user created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Util.closeConnection(connection);
        }
    }

    public void dropUsersTable() {
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            String sql = "DROP TABLE IF EXISTS user";
            statement.executeUpdate(sql);
            System.out.println("Table user dropped");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Util.closeConnection(connection);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try{
            connection = Util.getConnection();

            String query = "INSERT INTO user (name, lastname, age) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            int rows = preparedStatement.executeUpdate();
            System.out.println("User с именем - " + name + " успешно добавлен:)");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Util.closeConnection(connection);
        }
    }

    public void removeUserById(long id) {
        try{
            connection = Util.getConnection();

            String query = "DELETE FROM user WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            int rows = preparedStatement.executeUpdate();
            System.out.println("User успешно удавлен:)");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Util.closeConnection(connection);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        connection = Util.getConnection();

        try(Statement statement = connection.createStatement();) {
            ResultSet results = statement.executeQuery("SELECT * FROM user");
            while (results.next()) {
                User user = new User();
                user.setName(results.getString("name"));
                user.setLastName(results.getString("lastname"));
                user.setAge(results.getByte("age"));
                users.add(user);
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Util.closeConnection(connection);
        }
        return users;
    }

    public void cleanUsersTable() {
        try {
            connection = Util.getConnection();
            String query = "TRUNCATE TABLE user";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            System.out.println("Таблица пользователей очищена.");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Util.closeConnection(connection);
        }
    }
}
