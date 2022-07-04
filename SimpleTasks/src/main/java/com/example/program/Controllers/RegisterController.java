package com.example.program.Controllers;

import com.example.program.HelloApplication;
import com.example.program.DAO.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Класс-контроллер для регистрации
 */
public class RegisterController {
    //UserDAO sqLiteDAO = new UserDAO();
    /**
     * Конструктор
     */
    public  RegisterController(){

    }

    @FXML
    private TextField newLogin;
    @FXML
    private TextField newPassword;

    /**
     * Функция регистрации нового пользователя
     * @param actionEvent событие
     * @throws SQLException  исключение при работе с SQL-запросами
     * @throws IOException исключение потока для чтения данных
     */
    public void onRegister(ActionEvent actionEvent) throws SQLException, IOException {

        if (!Objects.equals(newLogin.getText(), "") && !Objects.equals(newPassword.getText(), ""))
        {
            HomeViewController.daoFactory.getUserDAO().addUser(newLogin.getText(),newPassword.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Вы успешно зарегистрированы");
            alert.setContentText("Открываем страницу входа");
            alert.showAndWait();
            HelloApplication.downloadScene("login-view.fxml", actionEvent, "Страница входа", 900, 600);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка регистрации");
            alert.setContentText("Заполните поля");
            alert.showAndWait();
        }

    }

    /**
     * Функция перехода на страницу авторизации
     * @param actionEvent событие
     * @throws SQLException  исключение при работе с SQL-запросами
     * @throws IOException исключение потока
     */
    public void onShowLogin(ActionEvent actionEvent) throws IOException, SQLException {
        HelloApplication.downloadScene("login-view.fxml", actionEvent, "Страница входа", 900, 600);
    }
}
