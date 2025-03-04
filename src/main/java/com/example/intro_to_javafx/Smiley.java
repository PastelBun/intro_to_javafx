package com.example.intro_to_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;


public class Smiley extends Application {
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        Canvas canvas=new Canvas(400, 400);
        GraphicsContext gc=canvas.getGraphicsContext2D();
        ColorPicker color=new ColorPicker();
        root.setCenter(canvas);
        root.setRight(color);
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 400, 400);
        gc.setFill(Color.BLACK);
        gc.fillRect(20, 20 ,40, 40);
        gc.fillRect(100, 20, 40, 40);
        gc.fillRect(20, 100, 120, 20);
        gc.fillRect(0, 80, 20, 20);
        gc.fillRect(140, 80, 20, 20);

        Scene view = new Scene(root);

        stage.setScene(view);
        stage.show();
    }
    public static void main(String[] args) {
        launch(Smiley.class);
    }
}
