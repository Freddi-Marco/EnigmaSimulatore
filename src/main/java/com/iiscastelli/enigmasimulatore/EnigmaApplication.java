package com.iiscastelli.enigmasimulatore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EnigmaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EnigmaApplication.class.getResource("enigma-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Imposta titolo e dimensioni della finestra
        stage.setTitle("Enigma");
        stage.setWidth(1200);
        stage.setHeight(800);
        stage.setMaximized(true);

        // Carica e imposta l'icona
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icon.png")));
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
