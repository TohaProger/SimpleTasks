package com.example.program.Controllers;

import com.example.program.HelloApplication;
import com.example.program.Model.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField LoginText;
    @FXML
    private TextField PasswordText;
    UserDAO userDAO = new UserDAO();

    public void onLogin(ActionEvent actionEvent) throws SQLException, IOException {
        userDAO.printAll();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("");
        MainController main = fxmlLoader.getController();
        System.out.println(LoginText.getText());
        System.out.println(PasswordText.getText());
        if (userDAO.Verification(LoginText.getText(),PasswordText.getText()))
        {

            main.inputUser(userDAO.findUser(LoginText.getText(),PasswordText.getText()));
            stage.hide();
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            LoginText.clear();
            PasswordText.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка авторизации");
            alert.setContentText("Неверные данные");
            alert.showAndWait();
        }
    }

    public void onShowRegister(ActionEvent actionEvent) throws IOException {
        HelloApplication.downloadScene("register-view.fxml", actionEvent, "Страница регистрации");
    }

    public static boolean isUserIn = true;

    public void onGuest(ActionEvent actionEvent) throws IOException {
        isUserIn = false;

        HelloApplication.downloadScene("Main-view.fxml", actionEvent, "Только просмотр (гостевой вход)");
    }
}