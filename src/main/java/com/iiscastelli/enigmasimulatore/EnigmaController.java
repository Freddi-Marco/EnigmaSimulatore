package com.iiscastelli.enigmasimulatore;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EnigmaController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}