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
        ResultSet set = statement.executeQuery("Select * from Requirements ");
        Requirements requirements = new Requirements();
        while (set.next()) {
            requirements = MappringRequirements(set);
            res.add(requirements);
        }
        return res;
    }
    public ObservableList<Requirements> getRequirementsFilterType(String type) throws SQLException {
        createConnection();
        ObservableList<Requirements> res = FXCollections.observableArrayList();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("Select * from Requirements where Type='" + type+"'");
        Requirements requirements = new Requirements();
        while (set.next()) {
            requirements = MappringRequirements(set);
            res.add(requirements);
        }
        return res;
    }
    public Requirements MappringRequirements(ResultSet result) throws SQLException{
        Requirements requirements = new Requirements();
        System.out.println("id = "+result.getString(1));
        requirements.setId_Requirements(result.getString(1));
        requirements.setName(result.getString("Name"));
        System.out.println("Name = "+requirements.getName());
        requirements.setPriority(result.getString("Priority"));
        System.out.println("Priority = "+requirements.getPriority());
        requirements.setStatus(result.getString("Status"));
        System.out.println("Status = "+requirements.getPriority());
        requirements.setAuthor(result.getString("Author"));
        requirements.setComplexity(result.getString("Complexity"));
        System.out.println("Complexity = "+requirements.getComplexity());
        requirements.setType(result.getString("Type"));
        System.out.println("Type = "+requirements.getType());
        requirements.setSource(result.getString("Source"));
        requirements.setReason(result.getString("Reason"));
        requirements.setDescription(result.getString("Description"));
        requirements.setRiskAssessment(result.getString("RiskAssessment"));
        return requirements;
    }
    public void addRequirements(String Name, String Priority, String Status, String Author, String Type, String Complexity,
                                String Source, String Reason, String Description, String RiskAssessment, String Requirements_ID) throws SQLException {
        PreparedStatement insert  = connection.prepareStatement("insert into Requirements (Name,Priority,Status,Author,Complexity,Source,Reason,Description,RiskAssessment,Type,Requirements_ID)" +
                "values(?,?,?,?,?,?,?,?,?,?,?)");
        insert.setString(1,Name);
        insert.setString(2,Priority);
        insert.setString(3,Status);
        insert.setString(4,Author);
        insert.setString(5,Complexity);
        insert.setString(6,Source);
        insert.setString(7,Reason);
        insert.setString(8,Description);
        insert.setString(9,RiskAssessment);
        insert.setString(10,Type);
        insert.setString(11,Requirements_ID);
        insert.executeUpdate();
    }
    public void deleteRequirements(String id) throws SQLException {
        PreparedStatement insert  = connection.prepareStatement("delete from Requirements where Requirements_ID = ?");
        insert.setString(1, id);
        insert.executeUpdate();
    }
    public void updateRequirements(String Name, String Priority, String Status, String Author, String Type, String Complexity,
                                   String Source, String Reason, String Description, String RiskAssessment, String Requirements_ID) throws SQLException {
        PreparedStatement insert  = connection.prepareStatement("update Requirements set Name = ?,Priority = ?, Status = ?, Author=?, Type=?," +
                "Complexity=?, Source=?, Reason=?,Description=?,RiskAssessment=?  where Requirements_ID = ?");
        insert.setString(1,Name);
        insert.setString(2,Priority);
        insert.setString(3,Status);
        insert.setString(4,Author);
        insert.setString(5,Type);
        insert.setString(6,Complexity);
        insert.setString(7,Source);
        insert.setString(8,Reason);
        insert.setString(9,Description);
        insert.setString(10,RiskAssessment);
        insert.setString(11, Requirements_ID);
        insert.executeUpdate();
    }
}
