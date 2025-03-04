package com.example.intro_to_javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Random;

public class VisDynData extends Application {
    @Override
    public void start(Stage stage) {
        // The class Random is used to randomize the dice rolls
        Random random = new Random();

        NumberAxis xAxis = new NumberAxis();
        // y-axes represents the average of the rolls. The average is always between [1-6]
        NumberAxis yAxis = new NumberAxis(1, 6, 1);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        // removing elements of the chart, e.g. circles on points
        lineChart.setLegendVisible(false);
        lineChart.setAnimated(false);
        lineChart.setCreateSymbols(false);

        // we create a variable representing the data and add it to the chart
        XYChart.Series average = new XYChart.Series();
        lineChart.getData().add(average);

        new AnimationTimer() {
            private long previous;
            private long sum;
            private long count;

            @Override
            public void handle(long current) {
                if (current - previous < 100_000_000L) {
                    return;
                }
                if (average.getData().size() > 100) {
                    average.getData().remove(0);
                    xAxis.setLowerBound(xAxis.getLowerBound() + 1);
                    xAxis.setUpperBound(xAxis.getUpperBound() + 1);
                }
                previous = current;

                // roll the dice
                int number = random.nextInt(6) + 1;

                // we grow the sum and increment the count
                sum += number;
                count++;

                // we add a new data point to the chart
                average.getData().add(new XYChart.Data(count, 1.0 * sum / count));

            }
        }.start();


        Scene scene = new Scene(lineChart, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
