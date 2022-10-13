package com.example.program.DAO;

import com.example.program.Model.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteProjectDAO implements ProjectDAO {
    @Override
    public ObservableList<Project> getProject() throws SQLException, URISyntaxException, IOException {
        Connection connection = SQLiteDAOFactory.createConnection();
        ObservableList<Project> res = FXCollections.observableArrayList();
        assert connection != null;
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("Select * from projects ");
        Project project;// = new Project();
        while (set.next()) {
            project = MappingProject(set);
            res.add(project);
        }
        return res;
    }

    @Override
    public Project MappingProject(Object result) throws SQLException, URISyntaxException, IOException {
        ResultSet resultSet = (ResultSet) result;
        Project project = new Project();
        project.setID_project(resultSet.getInt("ID_project"));
        project.setProject_name(resultSet.getString("project_name"));
        project.setDescription(resultSet.getString("Description"));
        return project;
    }
}