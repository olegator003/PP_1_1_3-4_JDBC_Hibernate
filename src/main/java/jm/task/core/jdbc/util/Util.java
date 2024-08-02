package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    //подключение
    private static final String URL = "jdbc:mysql://localhost:3306/userok";
    private static final String USER = "root";
    private static final String PASSWORD = "1337";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //System.out.println("Соединение с базой данных успешно установлено.");
        } catch (SQLException e) {
            System.err.println("Ошибка при подключении к базе данных: " + e.getMessage());
        }
        return connection;
    }

    //закрытие
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                //System.out.println("Соединение с базой данных закрыто.");
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
    }
}