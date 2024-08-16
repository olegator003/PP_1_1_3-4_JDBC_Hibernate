package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.Properties;

public class Util {

    //подключение
    private static final String URL = "jdbc:mysql://localhost:3306/userok";
    private static final String USER = "root";
    private static final String PASSWORD = "1337";
    private static final String DRIVER = "com.mysql.jdbc.Driver";


    public static Connection getConnectionJDBC() {
        Connection connection = null;
        try {
            // Проверка наличия драйвера
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Драйвер не найден: " + e.getMessage());
            throw new RuntimeException("Драйвер не найден", e);
        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //System.out.println("Соединение с базой данных успешно установлено.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnectionJDBC(Connection connection) {
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