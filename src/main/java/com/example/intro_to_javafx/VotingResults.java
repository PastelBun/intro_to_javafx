package com.example.intro_to_javafx;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class VotingResults extends javafx.application.Application{
    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(2010, 2024, 1);
        NumberAxis yAxis = new NumberAxis(0, 32, 1);

        xAxis.setLabel("Aasta");
        yAxis.setLabel("Häälte Protsent");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Eesti riigikogu valimised");

        XYChart.Series ER= new XYChart.Series();
        ER.setName("Eesti Reformierakond");
        ER.getData().add(new XYChart.Data(2023, Double.valueOf("31.24")));
        ER.getData().add(new XYChart.Data(2019, Double.valueOf("28.8")));
        ER.getData().add(new XYChart.Data(2015, Double.valueOf("27.7")));
        ER.getData().add(new XYChart.Data(2011, Double.valueOf("28.6")));

        XYChart.Series EKRE= new XYChart.Series();
        EKRE.setName("Eesti Konservatiivne Rahvaerakond");
        EKRE.getData().add(new XYChart.Data(2023, Double.valueOf("16.05")));
        EKRE.getData().add(new XYChart.Data(2019, Double.valueOf("17.8")));
        EKRE.getData().add(new XYChart.Data(2015, Double.valueOf("8.1")));

        XYChart.Series EK=new XYChart.Series();
        EK.setName("Eesti Keskerakond");
        EK.getData().add(new XYChart.Data(2023, Double.valueOf("15.28")));
        EK.getData().add(new XYChart.Data(2019, Double.valueOf("23")));
        EK.getData().add(new XYChart.Data(2015, Double.valueOf("24.8")));
        EK.getData().add(new XYChart.Data(2011, Double.valueOf("23.3")));

        XYChart.Series EE200=new XYChart.Series();
        EE200.setName("Erakond Eesti 200");
        EE200.getData().add(new XYChart.Data(2023, Double.valueOf("13.33")));
        EE200.getData().add(new XYChart.Data(2019, Double.valueOf("4.5")));

        XYChart.Series SDE=new XYChart.Series();
        SDE.setName("Sotsiaaldemokraatlik Erakond");
        SDE.getData().add(new XYChart.Data(2023, Double.valueOf("9.27")));
        SDE.getData().add(new XYChart.Data(2019, Double.valueOf("9.8")));
        SDE.getData().add(new XYChart.Data(2015, Double.valueOf("15.2")));
        SDE.getData().add(new XYChart.Data(2011, Double.valueOf("17.1")));

        XYChart.Series IE=new XYChart.Series();
        IE.setName("Isamaa Erakond");
        IE.getData().add(new XYChart.Data(2023, Double.valueOf("8.21")));
        IE.getData().add(new XYChart.Data(2019, Double.valueOf("11.4")));
        IE.getData().add(new XYChart.Data(2015, Double.valueOf("13.7")));
        IE.getData().add(new XYChart.Data(2011, Double.valueOf("20.5")));

        XYChart.Series EER=new XYChart.Series();
        EER.setName("Erakond Eesti Rohelised");
        EER.getData().add(new XYChart.Data(2023, Double.valueOf("0.96")));
        EER.getData().add(new XYChart.Data(2019, Double.valueOf("1.8")));
        EER.getData().add(new XYChart.Data(2015, Double.valueOf("0.9")));
        EER.getData().add(new XYChart.Data(2011, Double.valueOf("3.8")));

        XYChart.Series EVA=new XYChart.Series();
        EVA.setName("Eesti Vabaerakond");
        EVA.getData().add(new XYChart.Data(2019, Double.valueOf("1.2")));
        EVA.getData().add(new XYChart.Data(2015, Double.valueOf("8.7")));

        XYChart.Series M=new XYChart.Series();
        M.setName("Muud");
        M.getData().add(new XYChart.Data(2023, Double.valueOf("0.96")));
        M.getData().add(new XYChart.Data(2019, Double.valueOf("1.6")));
        M.getData().add(new XYChart.Data(2015, Double.valueOf("0.7")));
        M.getData().add(new XYChart.Data(2011, Double.valueOf("6.4")));


        XYChart.Series EIP=new XYChart.Series();
        EIP.setName("Eesti Iseseisvuspartei");
        EIP.getData().add(new XYChart.Data(2015, Double.valueOf("0.2")));
        EIP.getData().add(new XYChart.Data(2011, Double.valueOf("0.4")));

        lineChart.getData().add(ER);
        lineChart.getData().add(EK);
        lineChart.getData().add(EE200);
        lineChart.getData().add(SDE);
        lineChart.getData().add(IE);
        lineChart.getData().add(EER);
        lineChart.getData().add(EVA);
        lineChart.getData().add(M);
        lineChart.getData().add(EIP);
        lineChart.getData().add(EKRE);

        Scene scene = new Scene(lineChart, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Eesti riigikogu valimised");
        stage.show();
    }
}
