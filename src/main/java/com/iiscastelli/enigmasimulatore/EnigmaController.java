package com.iiscastelli.enigmasimulatore;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EnigmaController {
    @FXML
    private Label welcomeText;

    @FXML
    public void initialize() {
        GestioneRotori gs = new GestioneRotori(0, 0, 1, 0, 2, 0, 1);
        System.out.println(gs.codifica('a'));
        System.out.println(gs.codifica('a'));
        System.out.println(gs.codifica('a'));
        System.out.println(gs.codifica('a'));
        System.out.println(gs.codifica('a'));

    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}