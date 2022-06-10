package com.example.program.Controllers;

import com.example.program.HelloApplication;
import com.example.program.Model.RequirementsDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * Класс контроллер для шаблона требования
 */
public class TemplateController implements Initializable {

    @FXML
    public Label System;
    @FXML
    public Label function;
    @FXML
    public TextField textSystem;
    @FXML
    public TextField textFunction;
    public static String text;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Функция отображения введенного текста
     * @param event событие
     */
    public void onText(ActionEvent event) {
        System.setText(textSystem.getText());
        function.setText(textFunction.getText());
    }

    /**
     * Функция возвращения назад
     * @param actionEvent
     * @throws IOException исключение потока
     */
    public void onBack(ActionEvent actionEvent) throws IOException {
        text=System.getText()+" должна "+function.getText();
        HelloApplication.downloadScene("Main-view.fxml", actionEvent, "");
    }
}
