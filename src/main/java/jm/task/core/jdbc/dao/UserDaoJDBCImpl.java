package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection = null;
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try{
            connection = Util.getConnection();
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("INSERT INTO user (name, lastname, age) VALUES ('Bruce', 'Lee', 36)");
            System.out.println("User с именем - 'Bruce' успешно добавлен:)");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Util.closeConnection(connection);
        }
    }

    public void dropUsersTable() {
        try{
            connection = Util.getConnection();
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("DELETE FROM User WHERE Id = 3");
            System.out.printf("Deleted %d rows", rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {

        return List.of();
    }

    public void cleanUsersTable() {

    }
}
