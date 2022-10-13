package com.example.program.Controllers;

import com.example.program.DAO.DAOFactory;
import com.example.program.HelloApplication;
import com.example.program.Model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Класс контроллер для авторизации
 */
public class LoginController implements Initializable {

    public static DAOFactory daoFactory;
    @FXML
    public ComboBox<String> comboBox;
    @FXML
    private TextField LoginText;
    @FXML
    private TextField PasswordText;
    public static Users user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().setAll(
                "Из базы данных",
                "Первый вариант"
        );
    }

    /**
     * Функция входа как пользователь
     *
     * @param actionEvent событие
     * @throws SQLException исключение при работе с SQL - запросами
     * @throws IOException  исключение потока для чтения данных
     */
    public void onLogin(ActionEvent actionEvent) throws SQLException, IOException {
        daoFactory = DAOFactory.getDAOFactory("quelquechosedetrescomplique");
        int selectedIndex = comboBox.getSelectionModel().getSelectedIndex();
        System.out.println("Выбранный метод загрузки: " + comboBox.getSelectionModel().getSelectedItem());
        if (selectedIndex == 2)
            daoFactory = DAOFactory.getDAOFactory("quelquechosedecomplique");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("project-list.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Список проектов");
        System.out.println(LoginText.getText());
        System.out.println(PasswordText.getText());
        if (LoginController.daoFactory.getUserDAO().Verification(LoginText.getText(), PasswordText.getText())) {
            user = LoginController.daoFactory.getUserDAO().findUser(LoginText.getText(), PasswordText.getText());
            System.out.println("LoginController user.login=" + user.getLogin());
            stage.hide();
            stage.setScene(scene);
            stage.show();
        } else {
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
     *
     * @param actionEvent событие
     * @throws IOException исключение потока для чтения данных
     */
    public void onShowRegister(ActionEvent actionEvent) throws IOException {
        HelloApplication.downloadScene("register-view.fxml", actionEvent, "Страница регистрации");
    }

    public static boolean isUserIn = true;

    /**
     * Функция для входа как гость
     *
     * @param actionEvent событие
     * @throws IOException исключение потока для чтения данных
     */
    public void onGuest(ActionEvent actionEvent) throws IOException {
        isUserIn = false;
        HelloApplication.downloadScene("project-list.fxml", actionEvent, "Только просмотр (гостевой вход)");
    }
}