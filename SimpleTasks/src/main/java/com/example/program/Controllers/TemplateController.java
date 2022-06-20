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
    RequirementsDAO requirementsDAO;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        requirementsDAO=new RequirementsDAO();
    }

    /**
     * Функция отображения введенного текста
     * @param event событие
     */
    public void onText(ActionEvent event) {
        System.setText(textSystem.getText());
        function.setText(textFunction.getText());
        Unit.setText(textUnit.getText());
        obj.setText(textObject.getText());
        Efficiency.setText(textEfficiency.getText());
    }

    /**
     * Функция возвращения назад
     * @param actionEvent
     * @throws IOException исключение потока
     */
    public void onBack(ActionEvent actionEvent) throws IOException, SQLException {
        text=System.getText()+" должна "+function.getText()+" "+textObject.getText()+" каждые "+textEfficiency.getText()+" "+textUnit.getText();
        if((!requirements.id_Requirements.toString().isEmpty())){
            requirements.setTemplate(TemplateController.text);
            requirementsDAO.updateTemplateEntitys(requirements);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Выберете  требование");
            alert.showAndWait();
        }
        HelloApplication.downloadScene("Main-view.fxml", actionEvent, "");
        
    }
}
