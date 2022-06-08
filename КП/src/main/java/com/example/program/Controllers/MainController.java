package com.example.program.Controllers;

import com.example.program.HelloApplication;
import com.example.program.Model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;

public class MainController implements Initializable {
    @FXML
    public ComboBox<String> comboType;
    @FXML
    public TableView<Requirements> RequirementsTable;
    @FXML
    public TableColumn<Requirements, String> id_Requirements;
    @FXML
    public TableColumn<Requirements, String> Name_Requirements;
    @FXML
    public TableColumn<Requirements, String> PriorityRequirements;
    @FXML
    public TableColumn<Requirements, String> TypeRequirements;
    @FXML
    public TableColumn<Requirements, String> StatusRequirements;
    @FXML
    public TableColumn<Requirements, String> AuthorRequirements;
    @FXML
    public TableColumn<Requirements, String> ComplexityRequirements;
    @FXML
    public TableColumn<Requirements, String> SourceRequirements;
    @FXML
    public TableColumn<Requirements, String> ReasonRequirements;
    @FXML
    public TableColumn<Requirements, String> DescriptionRequirements;
    @FXML
    public TableColumn<Requirements, String> RiskAssessmentRequirements;
    @FXML
    public ComboBox<String> comboType1;
    @FXML
    public ComboBox<String> comboComplexity;
    @FXML
    public ComboBox<String> comboStatus;
    @FXML
    public ComboBox<String> comboPriority;
    @FXML
    public TextField textSource;
    @FXML
    public TextField textReason;
    @FXML
    public TextField textRiskAssessment;
    @FXML
    public CheckBox checkAuthor;
    @FXML
    public TextArea textDescription;
    @FXML
    public VBox vboxNotForGuest;
    @FXML
    public GridPane grid;
    public Button btnDelete;


    public MainController(){
        //vboxNotForGuest.setVisible(false);
    }

    public static Users user = new Users();
    public static Requirements requirements=new Requirements();
    public RequirementsDAO requirementsDAO = new RequirementsDAO();

    public void inputUser(Users user) {
        this.user = user;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboType.getItems().setAll("Функциональные", "Требования к интерфейсам", "Производительность", "Ограничения",
                "Технологические требования","Требования качества","Нефункциональные Требования эргономики");
        comboStatus.getItems().setAll("Предложено", "Одобрено", "Утверждено", "Реализовано", "Верифицировано");
        comboPriority.getItems().addAll("Высокий", "Средний", "Низкий");
        comboType1.getItems().setAll("Функциональные", "Требования к интерфейсам", "Производительность", "Ограничения",
                "Технологические требования","Требования качества","Нефункциональные Требования эргономики");
        comboComplexity.getItems().setAll("Высокая", "Средняя","Низкая");
        if(!LoginController.isUserIn) {
            vboxNotForGuest.setVisible(false);
            grid.setVisible(false);
        }
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
        try {
            tableView(requirementsDAO.getRequirements());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequirementsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

        });
        RequirementsTable.setRowFactory(tableView -> {
            final TableRow<Requirements> row = new TableRow<>();
            row.selectedProperty().addListener((observable) -> {
                requirements = row.getItem();
                textRiskAssessment.setText(requirements.getRiskAssessment());
                textSource.setText(requirements.getSource());
                textReason.setText(requirements.getReason());
                textDescription.setText(requirements.getDescription());
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
                switch (requirements.getType()) {
                    case "Функциональные" -> comboType1.setValue("Функциональные");
                    case "Требования к интерфейсам" -> comboType1.setValue("Одобрено");
                    case "Производительность" -> comboType1.setValue("Производительность");
                    case "Ограничения" -> comboType1.setValue("Ограничения");
                    case "Технологические требования" -> comboType1.setValue("Верифицировано");
                    case "Требования качества" -> comboType1.setValue("Требования качества");
                    case "Требования эргономики" -> comboType1.setValue("Требования эргономики");
                    default -> comboType1.setValue("");
                }
                switch (requirements.getComplexity()) {
                    case "Высокая" -> comboComplexity.setValue("Высокая");
                    case "Средняя" -> comboComplexity.setValue("Средняя");
                    case "Низкая" -> comboComplexity.setValue("Низкая");
                }
            });

            return row;
        });
    }
    private void tableView(ObservableList<Requirements> requirements) throws SQLException {
        RequirementsTable.setItems(requirements);
        id_Requirements.setCellValueFactory(new PropertyValueFactory<>("id_Requirements"));
        Name_Requirements.setCellValueFactory(new PropertyValueFactory<>("Name"));
        PriorityRequirements.setCellValueFactory(new PropertyValueFactory<>("Priority"));
        TypeRequirements.setCellValueFactory(new PropertyValueFactory<>("Type"));
        StatusRequirements.setCellValueFactory(new PropertyValueFactory<>("status"));
        ComplexityRequirements.setCellValueFactory(new PropertyValueFactory<>("Complexity"));
        SourceRequirements.setCellValueFactory(new PropertyValueFactory<>("Source"));
        ReasonRequirements.setCellValueFactory(new PropertyValueFactory<>("Reason"));
        RiskAssessmentRequirements.setCellValueFactory(new PropertyValueFactory<>("RiskAssessment"));
        DescriptionRequirements.setCellValueFactory(new PropertyValueFactory<>("Description"));
        AuthorRequirements.setCellValueFactory(new PropertyValueFactory<>("author"));
    }

    public void Add(ActionEvent actionEvent) throws IOException, SQLException {
        if(checkEmpty()) {
            UUID uuid = UUID.randomUUID();
            System.out.println(uuid.toString());
            String author;
            author = user.getLogin();

            requirementsDAO.addRequirements("Требование", comboPriority.getSelectionModel().getSelectedItem(),
                    comboStatus.getSelectionModel().getSelectedItem(), author, comboType1.getSelectionModel().getSelectedItem(),
                    comboComplexity.getSelectionModel().getSelectedItem(), textSource.getText(), textReason.getText(), textDescription.getText(),
                    textRiskAssessment.getText(), uuid.toString());
            tableView(requirementsDAO.getRequirements());
        }
    }

    public void Delete() throws SQLException {
        if (RequirementsTable.getSelectionModel().getSelectedItem() != null) {
            TableView.TableViewSelectionModel<Requirements> selectionModel = RequirementsTable.getSelectionModel();
            int myIndex = RequirementsTable.getSelectionModel().getSelectedIndex();
            String id = RequirementsTable.getSelectionModel().getSelectedItem().id_Requirements;
            requirementsDAO.deleteRequirements(id);
            System.out.println("id выбранной строки" + id);
            tableView(requirementsDAO.getRequirements());
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Выберете требование для удаления");
            alert.showAndWait();
        }
    }

    public void onFilter(ActionEvent event) throws SQLException {
        tableView(requirementsDAO.getRequirementsFilterType(comboType.getSelectionModel().getSelectedItem()));
        comboType.setValue("");
    }


    public boolean checkEmpty(){
        if(comboType1.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Выберете тип требования ");
            alert.showAndWait();
            return false;
        }
        if(comboStatus.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Выберете статус требования ");
            alert.showAndWait();
            return false;
        }
        if(comboPriority.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Выберете приоритет требования");
            alert.showAndWait();
            return false;
        }
        if(comboComplexity.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Выберете сложность требования");
            alert.showAndWait();
            return false;
        }
        if(textSource.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Введите источник требования");
            alert.showAndWait();
            return false;
        }
        if(textDescription.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Введите описание требования ");
            alert.showAndWait();
            return false;
        }
        if(textReason.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Введите причину требования");
            alert.showAndWait();
            return false;
        }
        if(textRiskAssessment.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Введите оценку риску требования ");
            alert.showAndWait();
            return false;
        }

        return true;
    }
    public void onReset(ActionEvent event) throws SQLException {
        tableView(requirementsDAO.getRequirements());
        comboType.setValue("");
    }

    public void Update(ActionEvent event) throws SQLException {
        if(checkEmpty()) {
            String id = requirements.id_Requirements;
            String author;
            if (checkAuthor.isSelected()) {
                author = user.getLogin();
            } else {
                author = requirements.getAuthor();
            }
            requirementsDAO.updateRequirements("Требование", comboPriority.getSelectionModel().getSelectedItem(),
                    comboStatus.getSelectionModel().getSelectedItem(), author, comboType1.getSelectionModel().getSelectedItem(),
                    comboComplexity.getSelectionModel().getSelectedItem(), textSource.getText(), textReason.getText(), textDescription.getText(),
                    textRiskAssessment.getText(), id);
            tableView(requirementsDAO.getRequirements());
        }
    }

    public void onTamplate(ActionEvent actionEvent) throws IOException {
        HelloApplication.downloadScene("Themplate.fxml", actionEvent, "Страница регистрации");
    }
}
