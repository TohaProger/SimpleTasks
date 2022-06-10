package com.example.program.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Абстрактный класс Dao
 */
public abstract class DAO {
    Connection connection = null;

    /**
     * Функция создания подключения к базе данных
     */
    public void createConnection(){
        try {
            String url = "jdbc:sqlite:managementsoftreq.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Конструктор
     */
    public DAO(){
        createConnection();
    }

    /**
     * Функция получения данных из БД
     * @return список сущностей
     * @throws SQLException исключение при работе с SQL-запросами
     */
    public List<Entity> getAllEntity() throws SQLException {
        return null;
    }

    /**
     * Поиск по id
     * @param id int
     * @return сущьность
     * @throws SQLException исключение при работе с SQL-запросами
     */
    public Entity getEntity(int id) throws SQLException {
        return null;
    }

    /**
     * Функция обнавление записи
     * @param Developer сущьность
     */
    public void updateEntitys(Entity Developer) throws SQLException {

    }

    /**
     * Функция удаления записи
     * @param Developer сущьность
     * @throws SQLException исключение при работе с SQL-запросами
     */

    public void deleteEntity(Entity Developer) throws SQLException {

    }
    /**
     * Функция добавления записи
     * @param Developer сущьность
     * @throws SQLException исключение при работе с SQL-запросами
     */
    public void addEntity(Entity Developer) throws SQLException {

    }
}
