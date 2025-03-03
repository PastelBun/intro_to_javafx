package com.example.intro_to_javafx;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiChart extends javafx.application.Application{
    @Override
    public void start(Stage stage){
        NumberAxis xAxis = new NumberAxis(2006, 2018, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        XYChart.Series shanghaiData= new XYChart.Series();
        shanghaiData.setName(null);
    shanghaiData.getData().add(new XYChart.Data(2007, 73));
    shanghaiData.getData().add(new XYChart.Data(2008, 68));
    shanghaiData.getData().add(new XYChart.Data(2009, 72));
    shanghaiData.getData().add(new XYChart.Data(2010, 72));
    shanghaiData.getData().add(new XYChart.Data(2011, 74));
    shanghaiData.getData().add(new XYChart.Data(2012, 73));
    shanghaiData.getData().add(new XYChart.Data(2013, 76));
    shanghaiData.getData().add(new XYChart.Data(2014, 73));
    shanghaiData.getData().add(new XYChart.Data(2015, 67));
    shanghaiData.getData().add(new XYChart.Data(2016, 56));
    shanghaiData.getData().add(new XYChart.Data(2017, 56));

    lineChart.getData().add(shanghaiData);

    Scene scene = new Scene(lineChart, 640, 480);
    stage.setScene(scene);
    stage.setTitle("Shanghai ranking");
    stage.show();
    }
}
