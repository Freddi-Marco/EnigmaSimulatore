package com.iiscastelli.enigmasimulatore;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EnigmaController {
    @FXML
    private Label welcomeText;

    @FXML
    public void initialize() {
        Rotore rotore = new Rotore("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 0);
        for (int i = 0; i < 1; i++) {
            rotore.ruota();
            System.out.println(rotore.traduci('a'));
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}