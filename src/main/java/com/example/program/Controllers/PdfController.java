package com.example.program.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ResourceBundle;

public class PdfController implements Initializable {
    @FXML
    WebView browser;
    WebEngine webEngine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        webEngine = browser.getEngine();

        System.out.println("url=" + MainController.url);
        webEngine.load("https://drive.google.com/viewerng/viewer?embedded=true&url=" + MainController.url);
    }
}
