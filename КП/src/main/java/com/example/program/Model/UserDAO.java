package com.example.program.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Класс Dao для работы с БД
 */
public class UserDAO extends DAO{
    /**
     * Конструктор
     */
    public UserDAO() {

    }

    /**
     * Функция получения всех записей
     * @return список сущностей
     * @throws SQLException исключение при работе с SQL-запросами
     */
    @Override
    public List<Entity> getAllEntity()  throws SQLException {
        List <Entity> list = new ArrayList<Entity>();
        Users user = new Users();
        String sql = "SELECT * FROM User";
        createConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int count = 0;
        while (result.next()) {
            user=Mapping(result);
            list.add(user);
            ++count;
        }
        connection.close();
        return list;
    }


    /**
     * Функция верификации
     * @param login логин
     * @param password пароль
     * @return true or false
     * @throws SQLException исключение при работе с SQL-запросами
     */
    public boolean Verification(String login, String password) throws SQLException {
        createConnection();
        String sql = "SELECT * FROM User WHERE LOGIN='"+login+"' and PASSWORD='"+password+"';";
        System.out.println(sql);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int columns = result.getRow();
        int count = 0;
        while (result.next()) {

            ++count;
        }
        System.out.println(count);
        if(count==0){
            connection.close();
            return false;
        }
        else{
            connection.close();
            return true;
        }
    }

    /**
     *  Функция добавления записи
     * @param login  login
     * @param password password
     * @throws SQLException исключение при работе с SQL-запросами
     */
    public void addUser(String login, String password) throws SQLException {
        PreparedStatement  insert  = connection.prepareStatement("insert into User (LOGIN,PASSWORD)values(?,?)");
        insert.setString(1,login);
        insert.setString(2,password);
        insert.executeUpdate();
    }

    /**
     * Функция поиска поользователя по id
     * @param id int
     * @return пользователь
     * @throws SQLException исключение при работе с SQL-запросами
     */
    @Override
    public Entity getEntity(int id) throws SQLException {
        Users user = new Users();
        createConnection();
        String sql = "SELECT * FROM User WHERE USER_ID='"+id+";";
        System.out.println(sql);
        Statement statement = null;
        statement = connection.createStatement();
        ResultSet result = null;
        result = statement.executeQuery(sql);
        int count=0;
        while (result.next()) {
            ++count;
        }
        System.out.println(count);
        if(count==0){
            connection.close();
            return null;
        }
        else{
            user =Mapping(result);
            connection.close();
            return user;
        }
    }

    /**
     * Функция поиска поользователя по login, password
     * @param login  login
     *  @param password password
     * @return пользователь
     * @throws SQLException исключение при работе с SQL-запросами
     */
    public Users findUser(String login, String password) throws SQLException {
        Users user = new Users();
        createConnection();
        String sql = "SELECT * FROM User WHERE LOGIN='"+login+"' and PASSWORD='"+password+"';";
        System.out.println(sql);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int columns = result.getRow();
        int count = 0;
        while (result.next()) {
            user=Mapping(result);
            ++count;
        }
        System.out.println("число записей "+count);
        if(count==0){
            connection.close();
            System.out.println("count==0 ");
            return null;
        }
        else{
            System.out.println("count не равен 0 ");
            return user;
        }
    }

    /**
     * Функция поиска поользователя по login
     * @param login  logi
     * @return пользователь
     * @throws SQLException исключение при работе с SQL-запросами
     */
    public Users findUser(String login) throws SQLException {
        Users user = new Users();
        createConnection();
        String sql = "SELECT * FROM User WHERE LOGIN='"+login+"';";
        System.out.println(sql);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int columns = result.getRow();
        int count = 0;
        while (result.next()) {
            user=Mapping(result);
            ++count;
        }
        if(count==0){
            connection.close();
            return null;
        }
        else{
            return user;
        }
    }

    /**
     * Маппинг результата апроса
     * @param result
     * @return  Users
     * @throws SQLException исключение при работе с SQL-запросами
     */
    public Users Mapping(ResultSet result) throws SQLException {
        Users user = new Users();
        System.out.println("id = "+result.getInt(1));
        user.setId_User(result.getInt(1));
        user.setLogin(result.getString(2));
        user.setPassword(result.getString(3));
        return user;
    }
}
