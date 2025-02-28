package com.example.intro_to_javafx;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class Text_Statistics_part_2 extends Application {

    @Override
    public void start(Stage window) {
        BorderPane root = new BorderPane();
        HBox hBox = new HBox();
        TextField textField = new TextField();
        textField.setPromptText("Enter text here");
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            String[] words = newValue.split(" ");
            int letterCount = newValue.length();
            int wordCount = words.length;
            String longestWord = Arrays.stream(words).min((s1, s2) -> Integer.compare(s2.length(), s1.length()))
                    .get();
            hBox.getChildren().clear();
            Label letterCountLabel=new Label("Letters:" + letterCount);
            Label wordCountLabel= new Label( " Words:" + wordCount);
            Label longestWordLabel= new Label( " Longest Word:" + longestWord);
            hBox.getChildren().addAll(letterCountLabel, wordCountLabel, longestWordLabel);
        });
        root.setBottom(hBox);
        root.setTop(textField);

        Scene scene = new Scene(root, 400, 400);

        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(Text_Statistics_part_2.class);
    }
}