package com.iiscastelli.enigmasimulatore;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class EnigmaController {
    @FXML
    private GridPane gridLuci;
    @FXML
    private GridPane gridTastiera;
    private Button[] buttons;
    private Circle[] luci;
    static private GestioneRotori gs;

    @FXML
    private Label welcomeText;

    private void inizializzaLuci() {
        luci = new Circle[27];
        char lettera = 'A';
        gridLuci.setVgap(10);
        gridLuci.setHgap(10);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                luci[i * 9 + j] = new Circle();
                luci[i * 9 + j].setFill(Paint.valueOf("#222222"));
                luci[i * 9 + j].setRadius(15);
                luci[i * 9 + j].setStroke(Color.WHITE);
                luci[i * 9 + j].setStrokeWidth(1);
                final char letteraF = lettera;
                gridLuci.add(luci[i * 9 + j], j, i);
                lettera++;
                if (lettera == '[') return;
            }
        }
    }

    private void inizializzaTastiera() {
        buttons = new Button[27];
        char lettera = 'A';
        gridTastiera.setVgap(10);
        gridTastiera.setHgap(10);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                buttons[i * 9 + j] = new Button("" + lettera);
                buttons[i * 9 + j].setPrefWidth(600 / 10);
                final char letteraF = lettera;
                buttons[i * 9 + j].setOnAction(e -> {
                    if (gs != null) {
                        final char codificato = gs.codifica(letteraF);
                        final int lampIdx = codificato - 'A';
                        for (int l = 0; l < 26; l++) {
                            if (l == lampIdx) {
                                luci[l].setFill(Color.YELLOW);
                            } else {
                                luci[l].setFill(Paint.valueOf("#222222"));
                            }
                        }
                    }
                });
                gridTastiera.add(buttons[i * 9 + j], j, i);
                lettera++;
                if (lettera == '[') return;
            }
        }
    }

    @FXML
    public void initialize() {
        gs = new GestioneRotori(0, 0, 1, 0, 2, 0, 1);
        inizializzaLuci();
        inizializzaTastiera();
    }

    @FXML
    public void onKeyPressed(KeyEvent event){
        if (event.getCode().isLetterKey()){
            int pos = event.getCode().getChar().charAt(0) - 'A';
            buttons[pos].fire();
            buttons[pos].requestFocus();
        }
    }
}