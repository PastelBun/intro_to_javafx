package com.example.intro_to_javafx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageApplication extends Application {

    @Override
    public void start(Stage stage) {

        Image imageFile = new Image("file:humming.jpg");

        PixelReader pixels = imageFile.getPixelReader();

        int width = (int) imageFile.getWidth();
        int height = (int) imageFile.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter writer = targetImage.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                Color pixelColor = pixels.getColor(x, y);
                double red = pixelColor.getRed();
                double green = pixelColor.getGreen();
                double blue = pixelColor.getBlue();
                double opacity = pixelColor.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);

                writer.setColor(x, y, newColor);
            }
        }

        ImageView image = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
