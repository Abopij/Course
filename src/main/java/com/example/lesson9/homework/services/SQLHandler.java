package com.example.lesson9.homework.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// общий класс для исполнения SQL запросов в БД
public class SQLHandler {

    private static Connection connection;
    private static Statement statement;
    protected static boolean execute(String query) {
        boolean flag = false;
        try {
            connect();
            try {
                statement.executeUpdate(query);
                flag = true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            disconnect();
        }

        return flag;
    }

    private static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
