package com.example.program.Controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.program.DAO.ProjectDAO;
import com.example.program.HelloApplication;
import com.example.program.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ProjectController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Project> ProjectsTable;

    @FXML
    private TableColumn<Project, Integer> ID_project;

    @FXML
    private TableColumn<Project, String> project_name;

    @FXML
    private TableColumn<Project, String> DescriptionProject;
//    ProjectDAO projectDAO;
    public static Project project;
    @FXML
    void initialize() throws SQLException, URISyntaxException, IOException {
        project=new Project();
        project.Print();
        ProjectsTable.setItems(HomeViewController.daoFactory.getProjectDAO().getProject());
        ID_project.setCellValueFactory(new PropertyValueFactory<>("ID_project"));
        project_name.setCellValueFactory(new PropertyValueFactory<>("project_name"));
        DescriptionProject.setCellValueFactory(new PropertyValueFactory<>("Description"));
        ProjectsTable.setRowFactory(tableView -> {
            final TableRow<Project> row = new TableRow<>();
            row.selectedProperty().addListener((observable) -> {
                project=row.getItem();
                ActionEvent actionEvent = new ActionEvent();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main-view.fxml"));
                try {
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = (Stage) ProjectsTable.getScene().getWindow();
                    stage.setTitle("");
                    stage.hide();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            return row;
        });
    }
}

