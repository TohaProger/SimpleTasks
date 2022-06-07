package com.example.program.Controllers;

import com.example.program.HelloApplication;
import com.example.program.Model.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class RegisterController {
    UserDAO sqLiteDAO = new UserDAO();
    public  RegisterController(){

    }
    @FXML
    private TextField newLogin;
    @FXML
    private TextField newPassword;
    public void onRegister(ActionEvent actionEvent) throws SQLException, IOException {
//        sqLiteDAO.createDB();
        if (!Objects.equals(newLogin.getText(), "") && !Objects.equals(newPassword.getText(), ""))
        {
            sqLiteDAO.addUser(newLogin.getText(),newPassword.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Вы успешно зарегистрированы");
            alert.setContentText("Открываем страницу входа");
            alert.showAndWait();
            HelloApplication.downloadScene("login-view.fxml", actionEvent, "Страница входа");
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка регистрации");
            alert.setContentText("Заполните поля");
            alert.showAndWait();
        }

    }

    public void onShowLogin(ActionEvent actionEvent) throws IOException, SQLException {
        HelloApplication.downloadScene("login-view.fxml", actionEvent, "Страница входа");
    }
}
