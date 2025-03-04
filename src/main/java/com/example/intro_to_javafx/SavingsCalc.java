package com.example.intro_to_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalc extends Application {

    private XYChart.Series<Number, Number> series;
    private XYChart.Series<Number, Number> seriesWithInterest;

    @Override
    public void start(Stage stage) {
        // Loo root-paigutus
        BorderPane root = new BorderPane();

        // Lisa LineChart koos x- ja y-telgedega
        NumberAxis xAxis = new NumberAxis(0, 31, 1);
        NumberAxis yAxis = new NumberAxis(0, 10000, 500);
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Over Time");
        lineChart.setAnimated(false); // Eemaldab animatsiooni

        // Lisa kaks andmeseeriat ("Savings" ja "Savings with interest")
        series = new XYChart.Series<>();
        series.setName("Savings");
        seriesWithInterest = new XYChart.Series<>();
        seriesWithInterest.setName("Savings with interest");

        lineChart.getData().add(series);
        lineChart.getData().add(seriesWithInterest);

        root.setCenter(lineChart);

        // Ülemine paigutus (kuusisese säästu liugur)
        BorderPane vBoxTop = new BorderPane();
        Label label = new Label("Monthly Savings");
        Slider slider = new Slider(25, 250, 25);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(25);
        slider.setMinorTickCount(5);
        slider.setShowTickLabels(true);
        Label explain = new Label(slider.getValue() + "€");

        vBoxTop.setLeft(label);
        vBoxTop.setCenter(slider);
        vBoxTop.setRight(explain);

        // Alumine paigutus (aastase intressimäära liugur)
        BorderPane vBoxBottom = new BorderPane();
        Label label2 = new Label("Yearly Interest Rate");
        Slider slider2 = new Slider(0, 10, 1);
        slider2.setShowTickMarks(true);
        slider2.setMajorTickUnit(1);
        slider2.setShowTickLabels(true);
        Label explain2 = new Label(slider2.getValue() + "%");

        vBoxBottom.setLeft(label2);
        vBoxBottom.setCenter(slider2);
        vBoxBottom.setRight(explain2);

        // Kuulajad liuguritele
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            explain.setText(String.format("%.0f€", newValue.doubleValue()));
            updateValues((int) slider.getValue(), (int) slider2.getValue(), yAxis);
        });

        slider2.valueProperty().addListener((observable, oldValue, newValue) -> {
            explain2.setText(String.format("%.0f%%", newValue.doubleValue()));
            updateValues((int) slider.getValue(), (int) slider2.getValue(), yAxis);
        });

        // Paigutus ja Scene
        VBox vBox = new VBox(vBoxTop, vBoxBottom);
        root.setTop(vBox);

        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.setTitle("Savings Calculator");
        stage.show();

        // Esialgsed väärtused
        updateValues((int) slider.getValue(), (int) slider2.getValue(), yAxis);
    }

    private void updateValues(int monthlySavings, int yearlyInterest, NumberAxis yAxis) {
        // Puhasta varasemad väärtused
        series.getData().clear();
        seriesWithInterest.getData().clear();
        series.getData().add(new XYChart.Data<>(0, 0));
        seriesWithInterest.getData().add(new XYChart.Data<>(0, 0));

        double totalSavings = 0;
        double totalSavingsWithInterest = 0;
        double monthlyRate = (double) yearlyInterest / 100 / 12;

        // Arvuta uuendatud väärtused
        for (int year = 1; year <= 30; year++) {
            // Lihtne sääst
            totalSavings += monthlySavings * 12;
            series.getData().add(new XYChart.Data<>(year, totalSavings));

            // Sääst koos intressidega
            totalSavingsWithInterest += monthlySavings * 12;
            totalSavingsWithInterest += totalSavingsWithInterest * monthlyRate * 12;
            seriesWithInterest.getData().add(new XYChart.Data<>(year, totalSavingsWithInterest));
        }

        // Uuenda y-telje parameetreid
        double maxY = Math.max(totalSavings, totalSavingsWithInterest);
        yAxis.setUpperBound(maxY + 1000);
        yAxis.setTickUnit((maxY + 1000) / 10);
    }

    public static void main(String[] args) {
        launch(args); // Käivitab JavaFX rakenduse
    }
}