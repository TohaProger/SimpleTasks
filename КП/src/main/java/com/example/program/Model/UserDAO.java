package com.example.program.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO{

    public UserDAO() {

    }
    public void createTableUser(){
        String createTableSQL = "CREATE TABLE User ("
                + "USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,  "
                + "LOGIN VARCHAR(20) NOT NULL, "
                + "PASSWORD VARCHAR(20) NOT NULL "
                + ")";
        execSQL(createTableSQL);
    }
    public void createTableRequirements(){
        String createTableSQL = "CREATE TABLE Requirements ("
                + "Requirements_ID INTEGER PRIMARY KEY AUTOINCREMENT,  "
                + "Priority VARCHAR(30) NOT NULL, "
                + "Name VARCHAR(30) NOT NULL, "
                + "Status VARCHAR(30) NOT NULL, "
                + "Author VARCHAR(30) NOT NULL, "
                + "Version VARCHAR(30) NOT NULL "
                + ")";
        execSQL(createTableSQL);
    }

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
    public void printAll() throws SQLException {
        String sql = "SELECT * FROM User";
        createConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int count = 0;
        while (result.next()){
            String login = result.getString(2);
            String pass = result.getString(3);
            String output = "User #%d: %s - %s ";
            System.out.println(String.format(output, ++count, login, pass));
        }
        connection.close();
    }
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
    public void addUser(String login, String password) throws SQLException {
        PreparedStatement  insert  = connection.prepareStatement("insert into User (LOGIN,PASSWORD)values(?,?)");
        insert.setString(1,login);
        insert.setString(2,password);
        insert.executeUpdate();
    }
    @Override
    public Entity getDeveloper(int id) throws SQLException {
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
    public Users Mapping(ResultSet result) throws SQLException {
        Users user = new Users();
        System.out.println("id = "+result.getInt(1));
        user.setId_User(result.getInt(1));
        user.setLogin(result.getString(2));
        user.setPassword(result.getString(3));
        return user;
    }
    public Connection getConnection () {
        return connection;
    }
    public boolean execSQL (final String sql) {
        boolean result = false;
        try {
            if (getConnection() != null) {
                Statement statement = getConnection().createStatement();
                statement.execute(sql);
                statement.close();
                statement = null;
                result = true;
            }
        } catch (SQLException e) {
            System.err.println ("SQLException : code = " + String.valueOf(e.getErrorCode()) +
                    " - " + e.getMessage());
            System.err.println ("\tSQL : " + sql);
        }
        return result;
    }

}
