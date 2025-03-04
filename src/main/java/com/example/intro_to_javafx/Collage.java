package com.example.intro_to_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Collage extends Application{
    @Override
    public void start(Stage stage) {

        Image monaLisa = new Image("file:monaLisa.jpg");

        PixelReader pixels = monaLisa.getPixelReader();
        int originalWidth = (int) monaLisa.getWidth();
        int originalHeight = (int) monaLisa.getHeight();
        int width = originalWidth/2;
        int height = originalHeight/2;

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter writer = targetImage.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color pixelColor = pixels.getColor(x*2, y*2);
                double red = 1.0-pixelColor.getRed();
                double green = 1.0-pixelColor.getGreen();
                double blue = 1.0-pixelColor.getBlue();
                double opacity =pixelColor.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);

                writer.setColor(x, y, newColor);
            }
        }

        ImageView image = new ImageView(targetImage);
        ImageView image2 = new ImageView(targetImage);
        ImageView image3 = new ImageView(targetImage);
        ImageView image4 = new ImageView(targetImage);
        image2.setX(width);
        image2.setY(0);
        image3.setX(width);
        image3.setY(height);
        image4.setX(0);
        image4.setY(height);
        image.setX(0);
        image.setY(0);
        Pane pane = new Pane();
        pane.getChildren().addAll(image, image2, image3, image4);

        stage.setScene(new Scene(pane, originalWidth, originalHeight));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
