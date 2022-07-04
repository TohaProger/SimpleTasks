package com.example.program.DAO;

import com.example.program.Model.Project;
import com.example.program.Model.Requirements;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Scanner;

public class TxtFileReqiurementsDAO implements RequirementsDAO{
//    @Override
//    public ObservableList<Project> getProject() throws SQLException, URISyntaxException, IOException {
//        Project project = new Project();
//        ObservableList<Project> res = FXCollections.observableArrayList();
//        FileReader read = new FileReader("src\\main\\resources\\com\\example\\program\\txtfile\\requirements.txt");
//        Scanner scan = new Scanner(read);
//        while (scan.hasNextLine()){
//            project=MappringProject(scan);
//            res.add(project);
//        }
//        read.close();
//        return res;
//    }
//
//    @Override
//    public Project MappringProject(Object result) throws SQLException, URISyntaxException {
//        Scanner scan = (Scanner) result;
//        Project project = new Project();
//        project.setID_project(scan.nextInt());
//        project.setProject_name(scan.next());
//        project.setDescription(scan.next());
//        return project;
//    }

    @Override
    public ObservableList<Requirements> getRequirements(int id_Project) throws SQLException, URISyntaxException, IOException {
        Requirements project = new Requirements();
        ObservableList<Requirements> res = FXCollections.observableArrayList();
        FileReader read = new FileReader("src\\main\\resources\\com\\example\\program\\txtfile\\requirements.txt");
        Scanner scan = new Scanner(read);
        while (scan.hasNextLine()){
            project=MappringRequirements(scan);
            res.add(project);
        }
        read.close();
        return res;
    }

    @Override
    public ObservableList<Requirements> getRequirementsFilterType(String type) throws SQLException, URISyntaxException {
        return null;
    }

    @Override
    public Requirements MappringRequirements(Object result1) throws SQLException, URISyntaxException {
        return null;
    }

    @Override
    public void addEntity(Requirements requirement) throws SQLException {

    }

    @Override
    public void deleteEntity(Requirements requirement) throws SQLException {

    }

    @Override
    public void updateEntitys(Requirements requirement) throws SQLException {

    }

    @Override
    public void updateTemplateEntitys(Requirements requirement) throws SQLException {

    }
}
