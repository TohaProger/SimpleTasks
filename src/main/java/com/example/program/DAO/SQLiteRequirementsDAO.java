package com.example.program.DAO;

import com.example.program.Model.Requirements;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.URISyntaxException;
import java.sql.*;

public class SQLiteRequirementsDAO implements RequirementsDAO {
    Connection connection = SQLiteDAOFactory.createConnection();

    @Override
    public ObservableList<Requirements> getRequirements(int id_Project) throws SQLException, URISyntaxException {
        ObservableList<Requirements> res = FXCollections.observableArrayList();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("Select * from Requirements where Project=" + id_Project);
        Requirements requirements;// = new Requirements();
        while (set.next()) {
            requirements = MappingRequirements(set);
            res.add(requirements);
        }
        return res;
    }

    @Override
    public ObservableList<Requirements> getRequirementsFilterType(String type) throws SQLException, URISyntaxException {
        ObservableList<Requirements> res = FXCollections.observableArrayList();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("Select * from Requirements where Type='" + type + "'");
        Requirements requirements;// = new Requirements();
        while (set.next()) {
            requirements = MappingRequirements(set);
            res.add(requirements);
        }
        return res;
    }

    @Override
    public Requirements MappingRequirements(Object result1) throws SQLException, URISyntaxException {
        ResultSet result = (ResultSet) result1;
        Requirements requirements = new Requirements();
        requirements.setId_Requirements(result.getString("Requirements_ID"));
        requirements.setName(result.getString("Name"));
        requirements.setPriority(result.getString("Priority"));
        requirements.setStatus(result.getString("Status"));
        requirements.setAuthor(result.getString("Author").trim());
        requirements.setComplexity(result.getString("Complexity"));
        requirements.setType(result.getString("Type"));
        requirements.setSource(result.getString("Source"));
        requirements.setReason(result.getString("Reason"));
        requirements.setDescription(result.getString("Description"));
        requirements.setRiskAssessment(result.getString("RiskAssessment"));
        requirements.setProject(result.getString("Project"));
        requirements.setTemplate(result.getString("Template"));
        return requirements;
    }

    @Override
    public void addEntity(Requirements requirement) throws SQLException {
        PreparedStatement insert = connection.prepareStatement("insert into Requirements (Name,Priority,Status," +
                "Author,Type,Complexity,Source,Reason,Description,RiskAssessment,Requirements_ID,Project)" +
                "values(?,?,?,?,?,?,?,?,?,?,?,?)");
        insert.setString(1, requirement.getName());
        insert.setString(2, requirement.getPriority());
        insert.setString(3, requirement.getStatus());
        insert.setString(4, requirement.getAuthor());
        insert.setString(5, requirement.getType());
        insert.setString(6, requirement.getComplexity());
        insert.setString(7, requirement.getSource());
        insert.setString(8, requirement.getReason());
        insert.setString(9, requirement.getDescription());
        insert.setString(10, requirement.getRiskAssessment());
        insert.setString(11, requirement.getId_Requirements());
        insert.setString(12, requirement.getProject());
        insert.executeUpdate();
    }

    @Override
    public void deleteEntity(Requirements requirement) throws SQLException {
        PreparedStatement insert = connection.prepareStatement("delete from Requirements where Requirements_ID = ?");
        insert.setString(1, requirement.getId_Requirements());
        insert.executeUpdate();
    }

    @Override
    public void updateEntity(Requirements requirement) throws SQLException {
        PreparedStatement insert = connection.prepareStatement("update Requirements set Name = ?, Priority = ?, " +
                "Status = ?, Author=?, Type=?, " +
                "Complexity=?, Source=?, Reason=?, Description=?, RiskAssessment=?  where Requirements_ID = ?");
        insert.setString(1, requirement.getName());
        insert.setString(2, requirement.getPriority());
        insert.setString(3, requirement.getStatus());
        insert.setString(4, requirement.getAuthor());
        insert.setString(5, requirement.getType());
        insert.setString(6, requirement.getComplexity());
        insert.setString(7, requirement.getSource());
        insert.setString(8, requirement.getReason());
        insert.setString(9, requirement.getDescription());
        insert.setString(10, requirement.getRiskAssessment());
        insert.setString(11, requirement.getId_Requirements());
        insert.executeUpdate();
    }

    @Override
    public void updateTemplateEntity(Requirements requirement) throws SQLException {
        PreparedStatement insert = connection.prepareStatement("update Requirements set Template = ? where Requirements_ID = ?");
        insert.setString(1, requirement.getTemplate());
        insert.setString(2, requirement.getId_Requirements());
        insert.executeUpdate();
    }
}
