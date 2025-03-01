package com.example.intro_to_javafx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;

public class MultipleViews extends Application{
    @Override
    public void start(Stage window) {
        BorderPane first=new BorderPane();
        first.setTop(new Label("First view!"));
        Button toSecond=new Button("To the second view!");
        first.setCenter(toSecond);
        VBox second=new VBox();
        Button toThird=new Button("To the third view!");
        second.getChildren().add(toThird);
        second.getChildren().add(new Label("Second view!"));
        GridPane third=new GridPane();
        Button toFirst=new Button("To the first view!");
        third.add(new Label("Third view!"), 0, 0);
        third.add(toFirst, 1, 1);
        Scene scene1=new Scene(first,300,250);
        Scene scene2=new Scene(second,300,250);
        Scene scene3=new Scene(third,300,250);

        toFirst.setOnAction(e->window.setScene(scene1));
        toSecond.setOnAction(e->window.setScene(scene2));
        toThird.setOnAction(e->window.setScene(scene3));


        window.setScene(scene1);
        window.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }
}
