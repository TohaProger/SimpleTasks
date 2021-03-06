package com.example.program.Controllers;

import com.example.program.HelloApplication;
import com.example.program.DAO.UserDAO;
import com.example.program.Model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Класс контроллер для авторизации
 */
public class LoginController {

    @FXML
    private TextField LoginText;
    @FXML
    private TextField PasswordText;
    public static Users user;
    /**
     * Функция входа как пользователь
     * @param actionEvent событие
     * @throws SQLException  исключение при работе с SQL-запросами
     * @throws IOException исключение потока для чтения данных
     */
    public void onLogin(ActionEvent actionEvent) throws SQLException, IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("project-list.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("");
        MainController main = new MainController();
        System.out.println(LoginText.getText());
        System.out.println(PasswordText.getText());
        if (HomeViewController.daoFactory.getUserDAO().Verification(LoginText.getText(),PasswordText.getText()))
        {
            user=HomeViewController.daoFactory.getUserDAO().findUser(LoginText.getText(),PasswordText.getText());
            System.out.println("LoginController user.login="+user.getLogin());
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
    /**
     * Функция для открытия окна регистрации
     * @param actionEvent событие
     * @throws IOException исключение потока для чтения данных
     */
    public void onShowRegister(ActionEvent actionEvent) throws IOException {
        HelloApplication.downloadScene("register-view.fxml", actionEvent, "Страница регистрации", 900, 600);
    }

    public static boolean isUserIn = true;

    /**
     * Функция для входа как гость
     * @param actionEvent событие
     * @throws IOException исключение потока для чтения данных
     */
    public void onGuest(ActionEvent actionEvent) throws IOException {
        isUserIn = false;
        HelloApplication.downloadScene("project-list.fxml", actionEvent, "Только просмотр (гостевой вход)", 900, 600);
    }
}