package com.example.program.Controllers;

import com.example.program.Model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public TableView<Requirements> RequirementsTable;
    @FXML
    public TableColumn<Requirements, Integer> id_Requirements;
    @FXML
    public TableColumn<Requirements, String> Name_Requirements;
    @FXML
    public TableColumn<Requirements, String> PriorityRequirements;
    @FXML
    public TableColumn<Requirements, String> VersionRequirements;
    @FXML
    public TableColumn<Requirements, String> StatusRequirements;
    @FXML
    public TableColumn<Requirements, String> AuthorRequirements;
    @FXML
    public ComboBox<String> comboStatus;
    @FXML
    public ComboBox<String> comboPriority;
    @FXML
    public TextField textName;
    @FXML
    public TextField textVersion;
    @FXML
    public CheckBox checkAuthor;

    @FXML
    public VBox vboxNotForGuest;
    public Button btnDelete;

    public MainController(){
        //vboxNotForGuest.setVisible(false);
    }

    Users user = new Users();
    Requirements requirements=new Requirements();
    RequirementsDAO requirementsDAO = new RequirementsDAO();

    public void inputUser(Users user) {
        this.user = user;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(!LoginController.isUserIn)
            vboxNotForGuest.setVisible(false);

        comboStatus.getItems().setAll("Предложено", "Одобрено", "Утверждено", "Реализовано", "Верифицировано");
        comboPriority.getItems().addAll("Высокий", "Средний", "Низкий");
        try {
            tableView();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequirementsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

        });
        RequirementsTable.setRowFactory(tableView -> {
            final TableRow<Requirements> row = new TableRow<>();
            row.selectedProperty().addListener((observable) -> {
                final Requirements requirements = row.getItem();
                if (row.isHover() && requirements != null) {
                    textName.setText(requirements.getName());
                    textVersion.setText(requirements.getVersion());
                    switch (requirements.getPriority()) {
                        case "Высокий" -> comboPriority.setValue("Высокий");
                        case "Средний" -> comboPriority.setValue("Средний");
                        case "Низкий" -> comboPriority.setValue("Низкий");
                    }
                    switch (requirements.getStatus()) {
                        case "Предложено" -> comboStatus.setValue("Предложено");
                        case "Одобрено" -> comboStatus.setValue("Одобрено");
                        case "Утверждено" -> comboStatus.setValue("Утверждено");
                        case "Реализовано" -> comboStatus.setValue("Реализовано");
                        case "Верифицировано" -> comboStatus.setValue("Верифицировано");
                    }
                }
            });

            return row;
        });
    }
    private void tableView() throws SQLException {
        RequirementsTable.setItems(requirementsDAO.getRequirements());
        id_Requirements.setCellValueFactory(new PropertyValueFactory<>("id_Requirements"));
        Name_Requirements.setCellValueFactory(new PropertyValueFactory<>("Name"));
        PriorityRequirements.setCellValueFactory(new PropertyValueFactory<>("Priority"));
        VersionRequirements.setCellValueFactory(new PropertyValueFactory<>("Version"));
        StatusRequirements.setCellValueFactory(new PropertyValueFactory<>("status"));
        AuthorRequirements.setCellValueFactory(new PropertyValueFactory<>("author"));
    }
    public void clear(){
        textName.setText("");
        textVersion.setText("");
        comboStatus.setValue("");
        comboPriority.setValue("");
    }
    public void Add() throws SQLException {
        requirements=RequirementsTable.getSelectionModel().getSelectedItem();
        String author;
        author = user.getLogin();
        requirementsDAO.addRequirements(textName.getText(),comboPriority.getSelectionModel().getSelectedItem(),comboStatus.getSelectionModel().getSelectedItem(),author, textVersion.getText());
        tableView();
        clear();
    }

    public void Delete() throws SQLException {
        if (RequirementsTable.getSelectionModel().getSelectedItem() != null) {
            TableView.TableViewSelectionModel<Requirements> selectionModel = RequirementsTable.getSelectionModel();
            int myIndex = RequirementsTable.getSelectionModel().getSelectedIndex();
            int id = RequirementsTable.getItems().get(myIndex).getId_Requirements();
            requirementsDAO.deleteRequirements(id);
            System.out.println("id выбранной строки" + id);
            tableView();
            clear();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Выберете требование для удаления");
            alert.showAndWait();
        }
    }
    public void Update() throws SQLException {
        if (RequirementsTable.getSelectionModel().getSelectedItem() != null) {
            requirements=RequirementsTable.getSelectionModel().getSelectedItem();
            int myIndex = RequirementsTable.getSelectionModel().getSelectedIndex();
            int id = RequirementsTable.getItems().get(myIndex).getId_Requirements();
            String author;
            if(checkAuthor.isSelected()){
                author = user.getLogin();
            }else{
                author = requirements.getAuthor();
            }
            requirementsDAO.updateRequirements(textName.getText(),comboPriority.getSelectionModel().getSelectedItem(),comboStatus.getSelectionModel().getSelectedItem(),author, textVersion.getText(),requirements.getId_Requirements());
            System.out.println("id выбранной строки" + id);
            tableView();
            clear();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Выберете требование для удаления");
            alert.showAndWait();
        }
    }
}
