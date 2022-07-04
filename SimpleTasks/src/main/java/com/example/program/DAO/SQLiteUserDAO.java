package com.example.program.DAO;

import com.example.program.Model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteUserDAO implements UserDAO {
    Connection connection= SQLiteDAOFactory.createConnection();

    @Override
    public List<Users> getAllEntity() throws SQLException {
        List <Users> list = new ArrayList<Users>();
        Users user = new Users();
        String sql = "SELECT * FROM User";

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

    @Override
    public boolean Verification(String login, String password) throws SQLException {
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

    @Override
    public int addUser(String login, String password) throws SQLException {
        PreparedStatement insert  = connection.prepareStatement("insert into User (LOGIN,PASSWORD)values(?,?)");
        insert.setString(1,login);
        insert.setString(2,password);
        insert.executeUpdate();
        return findUser(login,password).getId_User();
    }

    @Override
    public Users findUserByID(int id) throws SQLException {
        Users user;
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

    @Override
    public Users findUser(String login, String password) throws SQLException {
        Users user = new Users();
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

    @Override
    public Users findUser(String login) throws SQLException {
        Users user = new Users();

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

    @Override
    public Users Mapping(Object result) throws SQLException {
        ResultSet resultSet = (ResultSet) result;
        Users user = new Users();
        user.setId_User(resultSet.getInt(1));
        user.setLogin(resultSet.getString(2));
        user.setPassword(resultSet.getString(3));
        return user;
    }
}
