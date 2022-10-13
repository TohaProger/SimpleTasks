package com.example.program.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDAOFactory extends DAOFactory {
    static Connection connection = null;
    /**
     * Функция создания подключения к базе данных
     */
    public static Connection createConnection(){
        try {
            String url = "jdbc:sqlite:managementsoftreq.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public ProjectDAO getProjectDAO() {
        return new SQLiteProjectDAO();
    }

    @Override
    public RequirementsDAO getRequirementsDAO() {
        return new SQLiteRequirementsDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new SQLiteUserDAO();
    }
}
