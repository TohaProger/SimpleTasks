package com.example.program.Controllers;

import com.example.program.HelloApplication;
import com.example.program.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * Класс Main контроллера
 */
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
    public TableColumn<Requirements, String> TemplateRequirements;
    @FXML
    public ComboBox<String> comboType1;
    @FXML
    public ComboBox<ComplexityRequirement> comboComplexity;
    @FXML
    public ComboBox<StatusRequirement> comboStatus;
    @FXML
    public ComboBox<PriorityRequirement> comboPriority;
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
    public static String url;
    /**
     * Конструктор
     */
    public MainController(){
        //vboxNotForGuest.setVisible(false);
    }

    public static Users user = new Users();
    public static Requirements requirements=new Requirements();
    public RequirementsDAO requirementsDAO = new RequirementsDAO();

    /**
     * Функция определения вошёл ли пользователь
     * @param user пользователя
     */
    public void inputUser(Users user) {
        this.user = user;
    }

    /**
     * Функция инициализации
     * @param location URL
     * @param resources ресурсы
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TypeRequirement[] allType = TypeRequirement.values();
        for(TypeRequirement type : allType) {
            comboType.getItems().add(type.toString());
            comboType1.getItems().add(type.toString());
        }
        comboStatus.setItems( FXCollections.observableArrayList( StatusRequirement.values()));
        comboPriority.getItems().addAll(PriorityRequirement.values());
        comboComplexity.getItems().setAll(ComplexityRequirement.values());
        if(!LoginController.isUserIn) {
            vboxNotForGuest.setVisible(false);
            grid.setVisible(false);
        }
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
        try {
            tableView(requirementsDAO.getRequirements(ProjectController.project.getID_project()));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
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
                    case "Высокий" -> comboPriority.setValue(PriorityRequirement.valueOf("pr1"));
                    case "Средний" -> comboPriority.setValue(PriorityRequirement.valueOf("pr2"));
                    case "Низкий" -> comboPriority.setValue(PriorityRequirement.valueOf("pr3"));
                }
                switch (requirements.getStatus()) {
                    case "Предложено" -> comboStatus.setValue(StatusRequirement.valueOf("st1"));
                    case "Одобрено" -> comboStatus.setValue(StatusRequirement.valueOf("st2"));
                    case "Утверждено" -> comboStatus.setValue(StatusRequirement.valueOf("st3"));
                    case "Реализовано" -> comboStatus.setValue(StatusRequirement.valueOf("st4"));
                    case "Верифицировано" -> comboStatus.setValue(StatusRequirement.valueOf("st5"));
                }
                switch (requirements.getType()) {
                    case "Функциональные" -> comboType1.setValue("Функциональные");
                    case "Требования к интерфейсам" -> comboType1.setValue("Требования к интерфейсам");
                    case "Производительность" -> comboType1.setValue("Производительность");
                    case "Ограничения" -> comboType1.setValue("Ограничения");
                    case "Технологические требования" -> comboType1.setValue("Технологические требования");
                    case "Требования качества" -> comboType1.setValue("Требования качества");
                    case "Требования эргономики" -> comboType1.setValue("Требования эргономики");
                    default -> comboType1.setValue("");
                }
                switch (requirements.getComplexity()) {
                    case "Высокая" -> comboComplexity.setValue(ComplexityRequirement.valueOf("sl1"));
                    case "Средняя" -> comboComplexity.setValue(ComplexityRequirement.valueOf("sl2"));
                    case "Низкая" -> comboComplexity.setValue(ComplexityRequirement.valueOf("sl3"));
                }
            });

            return row;
        });
    }

    /**
     * Функция отображения в таблице
     * @param requirements отсортированный список требований
     * @throws SQLException
     */
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
        TemplateRequirements.setCellValueFactory(new PropertyValueFactory<>("Template"));
    }

    /**
     * Функция добавления требования
     * @param actionEvent событие
     * @throws IOException исключение потока для чтения данных
     * @throws SQLException исключение при работе с SQL-запросами
     * @throws URISyntaxException исключение при получении URL
     */
    public void Add(ActionEvent actionEvent) throws IOException, SQLException, URISyntaxException {
        if(checkEmpty()) {
            String author;
            author = user.getLogin();
            requirements.setNewId_Requirements();
            requirements.setDescription(textDescription.getText());
            requirements.setReason(textReason.getText());
            requirements.setAuthor(author);
            requirements.setComplexity(comboComplexity.getSelectionModel().getSelectedItem().toString());
            requirements.setType(comboType1.getSelectionModel().getSelectedItem());
            requirements.setName("Требование");
            requirements.setPriority(comboPriority.getSelectionModel().getSelectedItem().toString());
            requirements.setStatus(comboStatus.getSelectionModel().getSelectedItem().toString());
            requirements.setSource(textSource.getText());
            requirements.setProject(Integer.toString(ProjectController.project.getID_project()));
            requirements.setRiskAssessment(textRiskAssessment.getText());
            requirementsDAO.addEntity(requirements);
            tableView(requirementsDAO.getRequirements(ProjectController.project.getID_project()));
            clear();
        }
    }

    /**
     * Функция удаления требования
     * @throws SQLException исключение при работе с SQL-запросами
     * @throws URISyntaxException исключение при получении URL
     */
    public void Delete() throws SQLException, URISyntaxException {
        if (RequirementsTable.getSelectionModel().getSelectedItem() != null) {
            TableView.TableViewSelectionModel<Requirements> selectionModel = RequirementsTable.getSelectionModel();
            int myIndex = RequirementsTable.getSelectionModel().getSelectedIndex();
            requirementsDAO.deleteEntity(RequirementsTable.getSelectionModel().getSelectedItem());
            tableView(requirementsDAO.getRequirements(ProjectController.project.getID_project()));
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Выберете требование для удаления");
            alert.showAndWait();
        }
    }
    /**
     * Функция фиьтрации требования
     * @param event событие
     * @throws SQLException исключение при работе с SQL-запросами
     * @throws URISyntaxException исключение при получении URL
     */
    public void onFilter(ActionEvent event) throws SQLException, URISyntaxException {
        tableView(requirementsDAO.getRequirementsFilterType(comboType.getSelectionModel().getSelectedItem()));
        comboType.setValue("");
    }

    /**
     * Функция проверки пустых полей
     * @return результат проверки true или false
     */
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

    /**
     * Отчистка от фольтраии
     * @param event событие
     * @throws SQLException исключение при работе с SQL-запросами
     * @throws URISyntaxException исключение при получении URL
     */
    public void onReset(ActionEvent event) throws SQLException, URISyntaxException {
        tableView(requirementsDAO.getRequirements(ProjectController.project.getID_project()));
        comboType.setValue("");
    }

    /**
     * Отчистка полей ввода
     */
    public void clear(){
        comboType1.setValue("");
        comboPriority.getSelectionModel().clearSelection();
        comboStatus.getSelectionModel().clearSelection();
        comboComplexity.getSelectionModel().clearSelection();
        textReason.setText("");
        textSource.setText("");
        textDescription.setText("");
        textRiskAssessment.setText("");
    }

    /**
     * Функция обновления требования
     * @param event событие
     * @throws SQLException исключение при работе с SQL-запросами
     * @throws URISyntaxException исключение при получении URL
     */
    public void Update(ActionEvent event) throws SQLException, URISyntaxException {
        if(checkEmpty()) {
            String id = requirements.getId_Requirements();
            String author;
            if (checkAuthor.isSelected()) {
                author = user.getLogin();
            } else {
                author = requirements.getAuthor();
            }

            requirements.setDescription(textDescription.getText());
            requirements.setReason(textReason.getText());
            requirements.setAuthor(author);
            requirements.setComplexity(comboComplexity.getSelectionModel().getSelectedItem().toString());
            requirements.setType(comboType1.getSelectionModel().getSelectedItem());
            requirements.setName("Требование");
            requirements.setPriority(comboPriority.getSelectionModel().getSelectedItem().toString());
            requirements.setStatus(comboStatus.getSelectionModel().getSelectedItem().toString());
            requirements.setSource(textSource.getText());
            requirements.setRiskAssessment(textRiskAssessment.getText());
            requirementsDAO.updateEntitys(requirements);
            tableView(requirementsDAO.getRequirements(ProjectController.project.getID_project()));
            clear();
        }
    }

    /**
     * Функция от
     * @param actionEvent событие
     * @throws IOException исключение потока для чтения данных
     */
    public void onTamplate(ActionEvent actionEvent) throws IOException, SQLException {
        HelloApplication.downloadScene("Themplate.fxml", actionEvent, "Страница шаблона");
    }

    public void selectSourceTab(MouseEvent mouseEvent) throws IOException {
        if(mouseEvent.getClickCount() == 2) {
            url = RequirementsTable.getSelectionModel().getSelectedItem().getSource();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PDF.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }
}
