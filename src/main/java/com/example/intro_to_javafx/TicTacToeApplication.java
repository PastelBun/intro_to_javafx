package com.example.intro_to_javafx;


import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class TicTacToeApplication extends Application {
    BorderPane borderPane=new BorderPane();

    Label turnLabel=new Label("Turn: X");
    Button one= new Button(" ");
    Button two= new Button(" ");
    Button three= new Button(" ");
    Button four= new Button(" ");
    Button five= new Button(" ");
    Button six= new Button(" ");
    Button seven= new Button(" ");
    Button eight= new Button(" ");
    Button nine= new Button(" ");


    GridPane gridPane;

    public TicTacToeApplication() {
        turnLabel.setFont(Font.font("Monospaced", 40));
        one.setFont(Font.font("Monospaced", 40));
        two.setFont(Font.font("Monospaced", 40));
        three.setFont(Font.font("Monospaced", 40));
        four.setFont(Font.font("Monospaced", 40));
        five.setFont(Font.font("Monospaced", 40));
        six.setFont(Font.font("Monospaced", 40));
        seven.setFont(Font.font("Monospaced", 40));
        eight.setFont(Font.font("Monospaced", 40));
        nine.setFont(Font.font("Monospaced", 40));
        gridPane = new GridPane();
        gridPane.add(one, 0, 0);
        gridPane.add(two, 0, 1);
        gridPane.add(three, 0, 2);
        gridPane.add(four, 1, 0);
        gridPane.add(five, 1, 1);
        gridPane.add(six, 1, 2);
        gridPane.add(seven, 2, 0);
        gridPane.add(eight, 2, 1);
        gridPane.add(nine, 2, 2);
        gridPane.setGridLinesVisible(true);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        one.setOnAction(e -> handleButtonClick(one));
        two.setOnAction(e -> handleButtonClick(two));
        three.setOnAction(e -> handleButtonClick(three));
        four.setOnAction(e -> handleButtonClick(four));
        five.setOnAction(e -> handleButtonClick(five));
        six.setOnAction(e -> handleButtonClick(six));
        seven.setOnAction(e -> handleButtonClick(seven));
        eight.setOnAction(e -> handleButtonClick(eight));
        nine.setOnAction(e -> handleButtonClick(nine));

        borderPane.setTop(turnLabel);
        borderPane.setBottom(gridPane);
    }

    private void handleButtonClick(Button button) {
        if (!button.getText().equals("X") && !button.getText().equals("O")) {
            if (turnLabel.getText().equals("Turn: X")) {
                button.setText("X");
                turnLabel.setText("Turn: O");
            } else {
                button.setText("O");
                turnLabel.setText("Turn: X");
            }

            if (checkWin()) {
                String winner = turnLabel.getText().equals("Turn: X") ? "O wins!" : "X wins!";
                turnLabel.setText(winner);
                gridPane.setDisable(true);
            }
        }
    }

    private boolean checkWin() {
        // Võidukombinatsioonide loogika
        String[][] board = {
                {one.getText(), two.getText(), three.getText()},
                {four.getText(), five.getText(), six.getText()},
                {seven.getText(), eight.getText(), nine.getText()}
        };

        // Kontrollime ridu
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].equals(" ") && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                return true;// Leitud võitja
            }
        }

        // Kontrollime veerge
        for (int i = 0; i < 3; i++) {
            if (!board[0][i].equals(" ") && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
                return true; // Leitud võitja
            }
        }

        // Kontrollime diagonaale
        if (!board[0][0].equals(" ") && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            return true;
        }
        return !board[0][2].equals(" ") && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]);// Ei leitud võitjat
    }

    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception{
        primaryStage.setScene(new javafx.scene.Scene(borderPane));
        primaryStage.show();
    }
}
