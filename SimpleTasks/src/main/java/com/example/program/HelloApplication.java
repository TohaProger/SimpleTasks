package com.example.program;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Класс приложения
 */
public class HelloApplication extends Application {
    /**
     * Функция загрузки
     * @param stage Stage
     * @throws IOException чтение потока данных
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Функция загрузки сцены (все окна, кроме первого)
     * @param str String
     * @param actionEvent событие
     * @param title String
     * @throws IOException чтение потока данных
     */
    public static void downloadScene(String str, ActionEvent actionEvent, String title, int v, int v1) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(str));
        Scene scene = new Scene(fxmlLoader.load(), v, v1);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.close();
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Главная функция приложения
     * @param args String[]
     */
    public static void main(String[] args) {
        launch();
    }
}