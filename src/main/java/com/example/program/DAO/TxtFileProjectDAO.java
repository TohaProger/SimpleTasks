package com.example.program.DAO;

import com.example.program.Model.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Scanner;

public class TxtFileProjectDAO implements ProjectDAO {
    @Override
    public ObservableList<Project> getProject() throws SQLException, URISyntaxException, IOException {
        Project project;// = new Project();
        ObservableList<Project> res = FXCollections.observableArrayList();
        FileReader read = new FileReader("src\\main\\resources\\com\\example\\program\\txtfile\\project.txt");
        Scanner scan = new Scanner(read);
        while (scan.hasNextLine()) {
            project = MappingProject(scan);
            res.add(project);
        }
        read.close();
        return res;
    }

    @Override
    public Project MappingProject(Object result) throws SQLException, URISyntaxException, IOException {
        Scanner scan = (Scanner) result;
        Project project = new Project();
        project.setID_project(scan.nextInt());
        project.setProject_name(scan.next());
        project.setDescription(scan.next());
        return project;
    }
}