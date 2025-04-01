package com.iiscastelli.enigmasimulatore;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;

public class EnigmaController {
    public HBox hBoxRot;
    public HBox hBoxPos;
    public GridPane gridCavi;
    @FXML
    private GridPane gridLuci;
    @FXML
    private GridPane gridTastiera;
    private Button[] buttons;
    private Circle[] luci;
    private Circle[] cavi;
    private Label[] posLabels;
    static private GestioneRotori gr;
    static private PannelloScambiatore ps = new PannelloScambiatore();

    @FXML
    private TextArea textInputArea;
    @FXML
    private TextArea textOutputArea;

    private StringBuilder inputText = new StringBuilder();
    private StringBuilder outputText = new StringBuilder();

    @FXML
    private void svuotaIOText() {
        inputText.setLength(0);
        outputText.setLength(0);
        textInputArea.setText(inputText.toString());
        textOutputArea.setText(outputText.toString());
    }

    public static Color getCavoColor(int index) {
        switch (index) {
            case 1: return Color.BLUE;
            case 2: return Color.GREEN;
            case 3: return Color.ORANGE;
            case 4: return Color.PURPLE;
            case 5: return Color.YELLOW;
            case 6: return Color.BROWN;
            default: return Color.BLACK; // Colore di default per valori non validi
        }
    }


    private void aggiornaLabelPosRotori() {
        for (int i = 0; i < posLabels.length; i++) {
            posLabels[i].setText(String.valueOf(gr.getPosRotoreChar(i)));
        }
    }

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

            hBoxRot.getChildren().add(cb);

            final int iF = i;
            cb.setOnAction(e -> {
                gr.setRotore(iF, cb.getSelectionModel().getSelectedItem());
                svuotaIOText();
                gr.resetPosRotori();
                System.out.println("fatto");
            });
            cb.getSelectionModel().select(i % 3);
        }

        posLabels = new Label[3];

        for (int i = 0; i < 3; i++) {
            Label posLabel = new Label();
            posLabel.setAlignment(Pos.CENTER);
            posLabel.setPrefWidth(60);
            posLabel.setBackground(Background.fill(Color.WHITE));
            posLabel.setTextFill(Color.BLACK);
            posLabels[i] = posLabel;


            Button plusButton = new Button("+");
            Button minusButton = new Button("-");

            final int iF = i;
            plusButton.setOnAction(e -> {
                gr.setPosRotore(iF, gr.getPosRotore(iF) + 1);
                aggiornaLabelPosRotori();
                svuotaIOText();
            });

            minusButton.setOnAction(e -> {
                gr.setPosRotore(iF, gr.getPosRotore(iF) - 1);
                aggiornaLabelPosRotori();
                svuotaIOText();
            });

            hBoxPos.getChildren().add(minusButton);
            hBoxPos.getChildren().add(posLabel);
            hBoxPos.getChildren().add(plusButton);
        }

        aggiornaLabelPosRotori();
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



    private void inizializzaCavi() {
        cavi = new Circle[27];
        char lettera = 'A';
        gridLuci.setVgap(5);
        gridLuci.setHgap(10);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                cavi[i * 9 + j] = new Circle();
                cavi[i * 9 + j].setFill(Paint.valueOf("#222222"));
                cavi[i * 9 + j].setRadius(15);
                cavi[i * 9 + j].setStroke(Color.WHITE);
                cavi[i * 9 + j].setStrokeWidth(1);

                final char letteraF = lettera;

                cavi[i * 9 + j].setOnMouseClicked(e -> {
                    ps.select(letteraF);
                    aggiornaCavi();
                });

                Label letteraLabel = new Label(String.valueOf(letteraF));
                letteraLabel.setPrefWidth(300 / 10);
                letteraLabel.setPadding(new Insets(0, 0, 10, 0));
                letteraLabel.setTextAlignment(TextAlignment.CENTER);
                letteraLabel.setAlignment(Pos.CENTER);
                letteraLabel.setTextFill(Color.WHITE);
                gridCavi.add(letteraLabel, j, (i * 2) + 1);

                gridCavi.add(cavi[i * 9 + j], j, i * 2);

                lettera++;
                if (lettera == '[') return;
            }
        }
    }

    private void aggiornaCavi() {
        int[] layout = ps.ritornaLayout();

        for (int i = 0; i < layout.length; i++) {
            cavi[i].setFill(getCavoColor(layout[i]));
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
                        final char codificato = ps.scambia(gr.codifica(ps.scambia(letteraF)));
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
                        aggiornaLabelPosRotori();
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
        inizializzaCavi();
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