package com.example.program.DAO;

import com.example.program.Model.Users;

import java.io.IOException;
import java.sql.*;
import java.util.List;

/**
 * Класс Dao для работы с БД
 */
public interface UserDAO {


    /**
     * Функция получения всех записей
     *
     * @return список сущностей
     * @throws SQLException исключение при работе с SQL - запросами
     */

    List<Users> getAllEntity() throws SQLException, IOException;

    /**
     * Функция верификации
     *
     * @param login    логин
     * @param password пароль
     * @return true or false
     * @throws SQLException исключение при работе с SQL - запросами
     */
    boolean Verification(String login, String password) throws SQLException, IOException;

    /**
     * Функция добавления записи
     *
     * @param login    login
     * @param password password
     * @throws SQLException исключение при работе с SQL - запросами
     */
    void addUser(String login, String password) throws SQLException, IOException;

    /**
     * Функция поиска пользователя по id
     *
     * @param id int
     * @return пользователь
     * @throws SQLException исключение при работе с SQL-запросами
     */

    Users findUserByID(int id) throws SQLException;

    /**
     * Функция поиска пользователя по login, password
     *
     * @param login    login
     * @param password password
     * @return пользователь
     * @throws SQLException исключение при работе с SQL - запросами
     */
    Users findUser(String login, String password) throws SQLException;

    /**
     * Функция поиска пользователя по login
     *
     * @param login login
     * @return пользователь
     * @throws SQLException исключение при работе с SQL - запросами
     */
    Users findUser(String login) throws SQLException;

    /**
     * Маппинг результата апроса
     *
     * @return Users
     * @throws SQLException исключение при работе с SQL - запросами
     */
    Users Mapping(Object result) throws SQLException, IOException;
}