package com.example.program.Controllers;

import com.example.program.DAO.DAOFactory;
import com.example.program.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeViewController{
    public static DAOFactory daoFactory;

    public void onDataBase(ActionEvent event) throws IOException {
        daoFactory = DAOFactory.getDAOFactory(2);
        HelloApplication.downloadScene("login-view.fxml", event, "Страница входа", 900, 600);
    }
    public void onTxt(ActionEvent event) throws IOException  {
        daoFactory = DAOFactory.getDAOFactory(1);
        HelloApplication.downloadScene("login-view.fxml", event, "Страница входа", 900, 600);
    }
}
