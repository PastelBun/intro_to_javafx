package com.example.intro_to_javafx;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class FinnishParties {
    public void FinnishParties() {
        NumberAxis xAxis = new NumberAxis(2006, 2018, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);

        xAxis.setLabel("Aasta");
        yAxis.setLabel("Häälte Protsent");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Eesti riigikogu valimised");

        XYChart.Series ERef= new XYChart.Series();
        ERef.setName("Eesti Reformierakond");
        ERef.getData().add(new XYChart.Data(2023, Double.valueOf("31.24")));

        XYChart.Series EKRE= new XYChart.Series();
        EKRE.setName("Eesti Konservatiivne Rahvaerakond");
        EKRE.getData().add(new XYChart.Data(2023, Double.valueOf("16.05")));

        XYChart.Series EK=new XYChart.Series();
        EK.setName("Eesti Keskerakond");
        EK.getData().add(new XYChart.Data(2023, Double.valueOf("15.28")));

        XYChart.Series EE200=new XYChart.Series();
        EE200.setName("Erakond Eesti 200");

    }
}
