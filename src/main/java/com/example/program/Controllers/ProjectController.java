package com.example.program.Controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import com.example.program.HelloApplication;
import com.example.program.Model.*;
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
    private TableView<Project> ProjectsTable;

    @FXML
    private TableColumn<Project, Integer> ID_project;

    @FXML
    private TableColumn<Project, String> project_name;

    @FXML
    private TableColumn<Project, String> DescriptionProject;
    public static Project project;
    @FXML
    void initialize() throws SQLException, URISyntaxException, IOException {
        project=new Project();
        project.Print();
        ProjectsTable.setItems(LoginController.daoFactory.getProjectDAO().getProject());
        ID_project.setCellValueFactory(new PropertyValueFactory<>("ID_project"));
        project_name.setCellValueFactory(new PropertyValueFactory<>("project_name"));
        DescriptionProject.setCellValueFactory(new PropertyValueFactory<>("Description"));
        ProjectsTable.setRowFactory(tableView -> {
            final TableRow<Project> row = new TableRow<>();
            row.selectedProperty().addListener((observable) -> {
                project=row.getItem();
                //ActionEvent actionEvent = new ActionEvent();
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

