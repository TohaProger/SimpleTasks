package com.example.program.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO {
    Connection connection = null;
    public void createConnection(){
        try {
            String url = "jdbc:sqlite:managementsoftreq.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public DAO(){
        createConnection();
    }
    public List<Entity> getAllEntity() throws SQLException {
        return null;
    }

    public Entity getDeveloper(int id) throws SQLException {
        return null;
    }

    public void updateDeveloper(Entity Developer) {

    }

    public void deleteDeveloper(Entity Developer) {

    }
}
