package TicTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;


import static TicTacToe.GameService.*;

public class MainApp extends Application {

    /* making new board for tic tac toe game*/
    public static GridPane boardMaker(BorderPane gameAppWindow, Player player, VBox mainWindow, HBox topPanel, VBox playerInfoGame) {
        Label gameState = new Label();
        gameState.setStyle("-fx-text-fill: #2F4F4F; -fx-font-size: 50px; -fx-background-color: #B0E0E6");
        gameState.setPadding(new Insets(50, 0, 50, 0));
        GridPane board = new GridPane();
        Field[][] fields = new Field[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Field field = new Field(fields, player);
                field.setOnMouseClicked((x) -> {

                    if (field.isEmpty() && !isWinner(fields)) {
                        field.setX();

                        try {
                            checkGameStateAfterMove(gameAppWindow, fields, mainWindow, gameState, player, topPanel, playerInfoGame);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if (!isWinner(fields) && !isBoardFull(fields)) {
                            compMove(player, fields);

                            try {
                                checkGameStateAfterMove(gameAppWindow, fields, mainWindow, gameState, player, topPanel, playerInfoGame);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                });
                fields[j][i] = field;
                board.add(fields[j][i], j, i);
            }
        }
        return board;
    }

    /* temporary fun board, showing when is no actual game on */
    public static GridPane emptyBoardMaker() {

        GridPane emptyBoard = new GridPane();
        emptyBoard.getStylesheets().add("AppColors.css");
        emptyBoard.setMinSize(600, 600);
        Field emptyField1 = new Field();
        emptyField1.setOnMouseClicked((x) -> {
            emptyField1.setTextAtEmptyField();
        });
        Field emptyField2 = new Field();
        emptyField2.setOnMouseClicked((x) -> {
            emptyField2.setTextAtEmptyField();
        });
        Field emptyField3 = new Field();
        emptyField3.setOnMouseClicked((x) -> {
            emptyField3.setTextAtEmptyField();
        });
        Field emptyField4 = new Field();
        emptyField4.setOnMouseClicked((x) -> {
            emptyField4.setTextAtEmptyField();
        });
        Field emptyField5 = new Field();
        emptyField5.setOnMouseClicked((x) -> {
            emptyField5.setTextAtEmptyField();
        });
        Field emptyField6 = new Field();
        emptyField6.setOnMouseClicked((x) -> {
            emptyField6.setTextAtEmptyField();
        });
        Field ticField = new Field("TIC");
        ticField.setTicTacToeEmptyText(1);
        ticField.setOnMouseClicked((x) -> {
            ticField.setTextAtEmptyField();
        });
        Field tacField = new Field("TAC");
        tacField.setTicTacToeEmptyText(2);
        tacField.setOnMouseClicked((x) -> {
            tacField.setTextAtEmptyField();
        });
        Field toeField = new Field("TOC");
        toeField.setTicTacToeEmptyText(3);
        toeField.setOnMouseClicked((x) -> {
            toeField.setTextAtEmptyField();
        });
        emptyBoard.add(emptyField1, 0, 1);
        emptyBoard.add(emptyField2, 0, 2);
        emptyBoard.add(emptyField3, 1, 0);
        emptyBoard.add(emptyField4, 1, 2);
        emptyBoard.add(emptyField5, 2, 0);
        emptyBoard.add(emptyField6, 2, 1);
        emptyBoard.add(ticField, 0, 0);
        emptyBoard.add(tacField, 1, 1);
        emptyBoard.add(toeField, 2, 2);
        return emptyBoard;
    }

    public static void gameResultsPanel(Player player, BorderPane gameAppWindow, HBox topPanel) {

        VBox gameResultsPane = new VBox();
        gameResultsPane.setPadding(new Insets(25, 0, 0, 0));
        gameResultsPane.setAlignment(Pos.CENTER);
        gameResultsPane.setSpacing(30);
        gameResultsPane.setMinHeight(280);
        gameResultsPane.setStyle("-fx-background-color: #B0E0E6");

        Label whoWins = new Label();
        whoWins.getStylesheets().add("AppColors.css");
        if (player.getWins() > (player.getLosses() + player.getDraws())) {
            whoWins.setText("You are the winner!");
        } else if (player.getLosses() > (player.getWins() + player.getDraws())) {
            whoWins.setText("You loose!");
        } else {
            whoWins.setText("There is no winner !");
        }

        Label resultShow = new Label();
        resultShow.getStylesheets().add("AppColors.css");
        resultShow.setText("wins: " + player.getWins() + ", losses: " + player.getLosses() + ", draws: " + player.getDraws());

        Button playAgainButton = new Button();
        playAgainButton.setText("Play again");
        playAgainButton.setMinSize(75, 75);
        playAgainButton.setStyle("-fx-text-fill: #2F4F4F; -fx-font-size: 15px; -fx-background-color: #F5FFFA");
        playAgainButton.setAlignment(Pos.CENTER);
        playAgainButton.setOnAction((x) -> {

            try {
                appCleaner(gameAppWindow);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        gameResultsPane.getChildren().addAll(whoWins, resultShow, playAgainButton);
        topPanel.getChildren().add(1, gameResultsPane);

    }

    public static VBox rankingPanelMaker() throws IOException {
        VBox ranks = new VBox();
        Label rankTitle = new Label("Rankings (Wins/Losses/Draws):");
        rankTitle.getStylesheets().add("SideWindowsColors.css");
        ranks.getStylesheets().add("SideWindowsColors.css");
        ranks.setMinWidth(300);
        ranks.setAlignment(Pos.TOP_CENTER);
        ranks.setPadding(new Insets(20, 0, 20, 0));
        ranks.getChildren().add(rankTitle);
        File file = new File("src/main/resources/ranking.txt");
        Scanner scanner = new Scanner(file);
        int playerPlace = 1;
        while (scanner.hasNextLine()) {

            String scannerLine = scanner.nextLine();
            String playerToShow = playerPlace + ". " + scannerLine.substring(6) + " (" + scannerLine.charAt(0) +
                    "/" + scannerLine.charAt(2) + "/" + scannerLine.charAt(4) + ")";
            playerPlace++;
            Label nextLbl = new Label(playerToShow);
            ranks.getChildren().add(nextLbl);
        }
        scanner.close();
        return ranks;
    }

    public static VBox playerGameInfoPanelMaker() {
        VBox playerGameInfo = new VBox();
        Label playerGameInfoTitle = new Label("Current Game Info");
        playerGameInfoTitle.setStyle("-fx-text-fill: #dbdbdb; -fx-font-size: 20px; -fx-background-color: #334d54");
        playerGameInfo.setMinWidth(300);
        playerGameInfo.setAlignment(Pos.TOP_CENTER);
        playerGameInfo.setPadding(new Insets(20, 0, 20, 0));
        playerGameInfo.getStylesheets().add("SideWindowsColors.css");
        playerGameInfo.getChildren().add(playerGameInfoTitle);
        return playerGameInfo;
    }

    public static HBox levelPanelMaker(Player player) {
        HBox levelPane = new HBox();
        Label level = new Label("Choose level: ");

        levelPane.setAlignment(Pos.CENTER);
        levelPane.setSpacing(10);
        level.getStylesheets().add("AppColors.css");

        ToggleGroup levelGroup = new ToggleGroup();
        RadioButton easyLevelBtn = new RadioButton("easy");
        easyLevelBtn.setStyle("-fx-text-fill: #2F4F4F; -fx-font-size: 20px; -fx-background-color: #B0E0E6");
        easyLevelBtn.setToggleGroup(levelGroup);
        easyLevelBtn.setSelected(true);
        RadioButton hardLevelBtn = new RadioButton("hard");
        hardLevelBtn.setStyle("-fx-text-fill: #2F4F4F; -fx-font-size: 20px; -fx-background-color: #B0E0E6");
        hardLevelBtn.setToggleGroup(levelGroup);
        levelGroup.selectedToggleProperty().addListener((x) -> {
            if (hardLevelBtn.isSelected()) {
                player.setEasy(false);
            } else if (easyLevelBtn.isSelected()) {
                player.setEasy(true);
            }

        });

        levelPane.getChildren().addAll(level, easyLevelBtn, hardLevelBtn);
        return levelPane;
    }

    public static HBox roundsNumberPaneMaker(Player player) {
        HBox roundsNumberPane = new HBox();
        roundsNumberPane.setAlignment(Pos.CENTER);
        roundsNumberPane.setSpacing(10);
        Label roundsNumberText = new Label("Number of rounds: ");
        roundsNumberText.getStylesheets().add("AppColors.css");
        ChoiceBox<Integer> roundsNumber = new ChoiceBox<>();
        roundsNumber.setValue(1);
        roundsNumber.getItems().addAll(1, 2, 3, 4, 5);
        roundsNumber.setOnAction((x) -> {
            player.setRounds(roundsNumber.getValue());
        });
        roundsNumberPane.getChildren().addAll(roundsNumberText, roundsNumber);
        return roundsNumberPane;
    }

    public static HBox topPanelMaker() {
        HBox topPanel = new HBox();
        topPanel.setAlignment(Pos.CENTER);
        topPanel.setMinHeight(280);
        topPanel.setStyle("-fx-background-color: #B0E0E6");
        return topPanel;
    }

    public static HBox playerPaneMaker(VBox mainWindow, Player player, Label mainText, BorderPane appWindow, HBox topPanel, VBox playerGameInfo,
                                       HBox levelPane, HBox roundsNumberPane) {

        Label warning = new Label("Type your name first!");
        warning.setStyle("-fx-text-fill: #8B0000; -fx-font-size: 20px");

        HBox playerPane = new HBox();
        playerPane.setAlignment(Pos.CENTER);
        playerPane.setSpacing(10);

        Label nameText = new Label("Type your name ");
        nameText.getStylesheets().add("AppColors.css");

        TextField nameTextField = new TextField();
        nameTextField.setMinHeight(30);

        Button playBtn = new Button();
        playBtn.setText("Play");
        playBtn.setMinSize(60, 30);
        playBtn.setStyle("-fx-text-fill: #2F4F4F; -fx-font-size: 15px; -fx-background-color: #F5FFFA");
        playBtn.setOnAction((x) -> {

            if (nameTextField.getText().trim().isEmpty() && !mainWindow.getChildren().contains(warning)) {
                mainWindow.getChildren().add(0, warning);

            } else if (!nameTextField.getText().trim().isEmpty()) {

                player.setName(nameTextField.getText());
                mainText.setText("TIC - TAC - TOE");

                Label playerIntroducing = new Label("PLAYER:");
                Label playerNameLabel = new Label(player.getName());

                playerIntroducing.getStylesheets().add("SideWindowsColors.css");

                playerNameLabel.getStylesheets().add("SideWindowsColors.css");
                playerNameLabel.setAlignment(Pos.CENTER);


                appWindow.setCenter(boardMaker(appWindow, player, mainWindow, topPanel, playerGameInfo));

                String levelText;
                if (player.isEasy()) {
                    levelText = ">> level: EASY <<";
                } else {
                    levelText = ">> level: HARD <<";
                }
                Label levelTextLabel = new Label(levelText);
                levelTextLabel.getStylesheets().add("SideWindowsColors.css");
                playerGameInfo.getChildren().addAll(playerIntroducing, playerNameLabel, levelTextLabel);
                mainWindow.getChildren().removeAll(levelPane, roundsNumberPane, playerPane);
                topPanel.getChildren().remove(mainWindow);
            }
        });
        playerPane.getChildren().addAll(nameText, nameTextField, playBtn);
        return playerPane;
    }

    public static VBox mainWindowMaker() {
        VBox mainWindow = new VBox();
        mainWindow.setPadding(new Insets(25, 0, 0, 0));
        mainWindow.setAlignment(Pos.CENTER);
        mainWindow.setSpacing(30);
        mainWindow.setMinHeight(280);
        mainWindow.setStyle("-fx-background-color: #B0E0E6");
        return mainWindow;
    }

    public static void appCleaner(BorderPane gameAppWindow) throws IOException {
        Player player = new Player();
        Label mainText = new Label("Game Setup");
        mainText.setStyle("-fx-text-fill: #2F4F4F; -fx-font-size: 50px; -fx-background-color: #B0E0E6");
        mainText.setPadding(new Insets(50, 150, 50, 150));

        VBox mainWindow = mainWindowMaker();
        VBox playerGameInfo = playerGameInfoPanelMaker();
        HBox levelPane = levelPanelMaker(player);
        HBox roundsNumberPane = roundsNumberPaneMaker(player);
        HBox topPanel = topPanelMaker();
        HBox playerPane = playerPaneMaker(mainWindow, player, mainText, gameAppWindow, topPanel, playerGameInfo, levelPane, roundsNumberPane);
        mainWindow.getChildren().addAll(levelPane, roundsNumberPane, playerPane);
        topPanel.getChildren().addAll(mainText, mainWindow);

        gameAppWindow.setLeft(rankingPanelMaker());
        gameAppWindow.setCenter(emptyBoardMaker());
        gameAppWindow.setRight(playerGameInfo);
        gameAppWindow.setTop(topPanel);
    }

    public static BorderPane mainRootMaker() throws IOException {

        /*variable warning shows if someone wants to play without typing his name*/
        Player player = new Player();
        HBox levelPane = levelPanelMaker(player);
        Label mainText = new Label("Game Setup");
        mainText.setStyle("-fx-text-fill: #2F4F4F; -fx-font-size: 50px; -fx-background-color: #B0E0E6");
        mainText.setPadding(new Insets(50, 150, 50, 150));

        BorderPane appWindow = new BorderPane();
        VBox mainWindow = mainWindowMaker();

        VBox playerGameInfo = playerGameInfoPanelMaker();

        HBox roundsNumberPane = roundsNumberPaneMaker(player);

        HBox topPanel = topPanelMaker();

        HBox playerPane = playerPaneMaker(mainWindow, player, mainText, appWindow, topPanel, playerGameInfo, levelPane, roundsNumberPane);
        mainWindow.getChildren().addAll(levelPane, roundsNumberPane, playerPane);
        topPanel.getChildren().addAll(mainText, mainWindow);

        appWindow.setLeft(rankingPanelMaker());
        appWindow.setCenter(emptyBoardMaker());
        appWindow.setRight(playerGameInfo);
        appWindow.setTop(topPanel);

        return appWindow;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene = new Scene(mainRootMaker());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Tic-tac-toe");
        primaryStage = stage;
        primaryStage.show();
    }
}