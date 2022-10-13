package com.example.program.Controllers;

import com.example.program.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.example.program.Controllers.MainController.requirements;

/**
 * Класс контроллер для шаблона требования
 */
public class TemplateController implements Initializable {

    @FXML
    public Label System;
    @FXML
    public Label function;
    @FXML
    public Label Unit;
    @FXML
    public Label Efficiency;
    @FXML
    public Label obj;
    @FXML
    public TextField textSystem;
    @FXML
    public TextField textFunction;
    @FXML
    public TextField textObject;
    @FXML
    public TextField textUnit;
    @FXML
    public TextField textEfficiency;
    public static String text;

    /**
     * Функция отображения введенного текста
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * Функция отображения введенного текста
     *
     */
    public void onText() {
        System.setText(textSystem.getText());
        function.setText(textFunction.getText());
        Unit.setText(textUnit.getText());
        obj.setText(textObject.getText());
        Efficiency.setText(textEfficiency.getText());
    }

    /**
     * Функция возвращения назад
     * @throws IOException исключение потока
     */
    public void onBack(ActionEvent actionEvent) throws IOException, SQLException {
        text = System.getText() + " должна " + function.getText() + " " + textObject.getText() + " каждые " + textEfficiency.getText() + " " + textUnit.getText();
        if ((!requirements.id_Requirements.toString().isEmpty())) {
            requirements.setTemplate(TemplateController.text);
            LoginController.daoFactory.getRequirementsDAO().updateTemplateEntity(requirements);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Выберете  требование");
            alert.showAndWait();
        }
        HelloApplication.downloadScene("Main-view.fxml", actionEvent, "");

    }
}
