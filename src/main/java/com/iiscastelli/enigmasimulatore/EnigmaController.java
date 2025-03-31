package com.iiscastelli.enigmasimulatore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;

public class EnigmaController {
    public HBox hBoxRot;
    public HBox hBoxPos;
    @FXML
    private GridPane gridLuci;
    @FXML
    private GridPane gridTastiera;
    private Button[] buttons;
    private Circle[] luci;
    static private GestioneRotori gr;

    @FXML
    private TextArea textInputArea;
    @FXML
    private TextArea textOutputArea;

    private StringBuilder inputText = new StringBuilder();
    private StringBuilder outputText = new StringBuilder();

    private void inizializzaChoiceBox() {
        String[] labelRotori = GestioneRotori.getRotoriLabels();
        String[] labelRiflessore = GestioneRotori.getRiflessoreLabels();
        for (int i = 0; i < 4; i++) {
            ChoiceBox<String> cb;
            if (i < 3)
                cb = new ChoiceBox<>(FXCollections.observableArrayList(labelRotori));
            else {
                cb = new ChoiceBox<>(FXCollections.observableArrayList(labelRiflessore));
            }

            hBoxPos.getChildren().add(cb);

            final int iF = i;
            cb.setOnAction(e -> {
                gr.setRotore(iF, cb.getSelectionModel().getSelectedItem());
                System.out.println("fatto");
            });
            cb.getSelectionModel().select(i % 3);
        }

        for (int i = 0; i < 3; i++) {
            ChoiceBox<String> cb;
        }
    }

    private void inizializzaLuci() {
        luci = new Circle[27];
        char lettera = 'A';
        gridLuci.setVgap(5);
        gridLuci.setHgap(10);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                luci[i * 9 + j] = new Circle();
                luci[i * 9 + j].setFill(Paint.valueOf("#222222"));
                luci[i * 9 + j].setRadius(15);
                luci[i * 9 + j].setStroke(Color.WHITE);
                luci[i * 9 + j].setStrokeWidth(1);

                final char letteraF = lettera;

                Label letteraLabel = new Label(String.valueOf(letteraF));
                letteraLabel.setPrefWidth(300 / 10);
                letteraLabel.setPadding(new Insets(0, 0, 10, 0));
                letteraLabel.setTextAlignment(TextAlignment.CENTER);
                letteraLabel.setAlignment(Pos.CENTER);
                letteraLabel.setTextFill(Color.WHITE);
                gridLuci.add(letteraLabel, j, (i*2)+1);

                gridLuci.add(luci[i * 9 + j], j, i*2);

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
                buttons[i * 9 + j].setPrefWidth(600 / 10.0);
                final char letteraF = lettera;
                buttons[i * 9 + j].setOnAction(e -> {
                    if (gr != null) {
                        final char codificato = gr.codifica(letteraF);
                        final int lampIdx = codificato - 'A';
                        for (int l = 0; l < 26; l++) {
                            if (l == lampIdx) {
                                luci[l].setFill(Color.YELLOW);
                            } else {
                                luci[l].setFill(Paint.valueOf("#222222"));
                            }
                        }
                        inputText.append(letteraF);
                        outputText.append(codificato);
                        textInputArea.setText(inputText.toString());
                        textOutputArea.setText(outputText.toString());
                        gridTastiera.requestFocus(); // Request focus on the keyboard grid
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
        gr = new GestioneRotori(0, 0, 1, 0, 2, 0, 0);
        inizializzaChoiceBox();
        inizializzaLuci();
        inizializzaTastiera();
        buttons[0].requestFocus(); // Ensure the first button has focus initially
        gridTastiera.requestFocus(); // Ensure the keyboard grid has focus initially
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