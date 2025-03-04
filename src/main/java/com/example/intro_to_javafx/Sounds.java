package com.example.intro_to_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Sounds extends Application {

    @Override
    public void start(Stage stage) {

        AudioClip sound = new AudioClip("file:bell.wav");
        sound.play();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}