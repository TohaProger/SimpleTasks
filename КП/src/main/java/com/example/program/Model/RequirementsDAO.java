package com.example.program.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RequirementsDAO extends DAO {
    public RequirementsDAO(){

    }
    public ObservableList<Requirements> getRequirements() throws SQLException {
        createConnection();
        ObservableList<Requirements> res = FXCollections.observableArrayList();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("Select * from Requirements");
        Requirements requirements = new Requirements();
        while (set.next()) {
            requirements = MappringRequirements(set);
            res.add(requirements);
        }
        return res;
    }
    public Requirements MappringRequirements(ResultSet result) throws SQLException{
        Requirements requirements = new Requirements();
        System.out.println("id = "+result.getInt(1));
        requirements.setId_Requirements(result.getInt(1));
        requirements.setName(result.getString("Name"));
        System.out.println("Name = "+requirements.getName());
        requirements.setPriority(result.getString("Priority"));
        System.out.println("Priority = "+requirements.getPriority());
        requirements.setStatus(result.getString("Status"));
        System.out.println("Priority = "+requirements.getPriority());
        requirements.setAuthor(result.getString("Author"));
        requirements.setVersion(result.getString("Version"));
        return requirements;
    }
    public void addRequirements(String Name, String Priority, String Status, String Author, String Version) throws SQLException {
        PreparedStatement insert  = connection.prepareStatement("insert into Requirements (Name,Priority,Status,Author,Version)" +
                "values(?,?,?,?,?)");
        insert.setString(1,Name);
        insert.setString(2,Priority);
        insert.setString(3,Status);
        insert.setString(4,Author);
        insert.setString(5,Version);
        insert.executeUpdate();
    }
    public void deleteRequirements(int id) throws SQLException {
        PreparedStatement insert  = connection.prepareStatement("delete from Requirements where Requirements_ID = ?");
        insert.setInt(1, id);
        insert.executeUpdate();
    }
    public void updateRequirements(String Name, String Priority, String Status, String Author, String Version,int id) throws SQLException {
        PreparedStatement insert  = connection.prepareStatement("update Requirements set Name = ?,Priority = ?, Status = ?, Author=?, Version=? where Requirements_ID = ?");
        insert.setString(1,Name);
        insert.setString(2,Priority);
        insert.setString(3,Status);
        insert.setString(4,Author);
        insert.setString(5,Version);
        insert.setInt(6, id);
        insert.executeUpdate();
    }
}
