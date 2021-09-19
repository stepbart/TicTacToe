package TicTacToe;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import static TicTacToe.MainApp.*;

public class GameService {

    public static void setRandomColorToText(Text text) {
        Random random = new Random();
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        text.setFill(Color.rgb(red, green, blue));
    }

    public static boolean isBoardFull(Field[][] fields) {
        boolean checkIsBoardFull = false;
        if (!fields[0][0].isEmpty() &&
                !fields[0][1].isEmpty() &&
                !fields[0][2].isEmpty() &&
                !fields[1][0].isEmpty() &&
                !fields[1][1].isEmpty() &&
                !fields[1][2].isEmpty() &&
                !fields[2][0].isEmpty() &&
                !fields[2][1].isEmpty() &&
                !fields[2][2].isEmpty()) {
            checkIsBoardFull = true;
        }
        return checkIsBoardFull;
    }

    public static void lastCompMove(Field[][] fields) {
        if (fields[0][0].isEmpty()) {
            fields[0][0].setO();
        } else if (fields[0][1].isEmpty()) {
            fields[0][1].setO();
        } else if (fields[0][2].isEmpty()) {
            fields[0][2].setO();
        } else if (fields[1][0].isEmpty()) {
            fields[1][0].setO();
        } else if (fields[1][1].isEmpty()) {
            fields[1][1].setO();
        } else if (fields[1][2].isEmpty()) {
            fields[1][2].setO();
        } else if (fields[2][0].isEmpty()) {
            fields[2][0].setO();
        } else if (fields[2][1].isEmpty()) {
            fields[2][1].setO();
        } else if (fields[2][2].isEmpty()) {
            fields[2][2].setO();
        }
    }

    public static void randomCompMove(Field[][] fields) {
        Random random = new Random();
        int x1 = random.nextInt(3);
        int y1 = random.nextInt(3);
        int x2 = random.nextInt(3);
        int y2 = random.nextInt(3);
        int x3 = random.nextInt(3);
        int y3 = random.nextInt(3);

        if (fields[x1][y1].isEmpty()) {
            fields[x1][y1].setO();
        } else if (fields[y1][x1].isEmpty()) {
            fields[y1][x1].setO();
        } else if (fields[x2][y2].isEmpty()) {
            fields[x2][y2].setO();
        } else if (fields[y2][x2].isEmpty()) {
            fields[y2][x2].setO();
        } else if (fields[x3][y3].isEmpty()) {
            fields[x3][y3].setO();
        } else if (fields[y3][x3].isEmpty()) {
            fields[y3][x3].setO();
        } else {
            lastCompMove(fields);
        }
    }

    public static void compMoveHard(Field[][] fields) {

        if (fields[0][0].isO() && fields[0][1].isO() && fields[0][2].isEmpty()) {
            fields[0][2].setO();
        } else if (fields[0][0].isO() && fields[0][2].isO() && fields[0][1].isEmpty()) {
            fields[0][1].setO();
        } else if (fields[0][2].isO() && fields[0][1].isO() && fields[0][1].isEmpty()) {
            fields[0][0].setO();
        } else if (fields[1][0].isO() && fields[1][1].isO() && fields[1][2].isEmpty()) {
            fields[1][2].setO();
        } else if (fields[1][0].isO() && fields[1][2].isO() && fields[1][1].isEmpty()) {
            fields[1][1].setO();
        } else if (fields[1][2].isO() && fields[1][1].isO() && fields[1][0].isEmpty()) {
            fields[1][0].setO();
        } else if (fields[2][0].isO() && fields[2][1].isO() && fields[2][2].isEmpty()) {
            fields[2][2].setO();
        } else if (fields[2][0].isO() && fields[2][2].isO() && fields[2][1].isEmpty()) {
            fields[2][1].setO();
        } else if (fields[2][2].isO() && fields[2][1].isO() && fields[2][0].isEmpty()) {
            fields[2][0].setO();
        } else if (fields[0][0].isO() && fields[1][0].isO() && fields[2][0].isEmpty()) {
            fields[2][0].setO();
        } else if (fields[0][0].isO() && fields[2][0].isO() && fields[1][0].isEmpty()) {
            fields[1][0].setO();
        } else if (fields[1][0].isO() && fields[2][0].isO() && fields[0][0].isEmpty()) {
            fields[0][0].setO();
        } else if (fields[0][1].isO() && fields[1][1].isO() && fields[2][1].isEmpty()) {
            fields[2][1].setO();
        } else if (fields[0][1].isO() && fields[2][1].isO() && fields[1][1].isEmpty()) {
            fields[1][1].setO();
        } else if (fields[1][1].isO() && fields[2][1].isO() && fields[0][1].isEmpty()) {
            fields[0][1].setO();
        } else if (fields[0][2].isO() && fields[1][2].isO() && fields[2][2].isEmpty()) {
            fields[2][2].setO();
        } else if (fields[0][2].isO() && fields[2][2].isO() && fields[1][2].isEmpty()) {
            fields[1][2].setO();
        } else if (fields[1][2].isO() && fields[2][2].isO() && fields[0][2].isEmpty()) {
            fields[0][2].setO();
        } else if (fields[0][0].isO() && fields[1][1].isO() && fields[2][2].isEmpty()) {
            fields[2][2].setO();
        } else if (fields[0][0].isO() && fields[2][2].isO() && fields[1][1].isEmpty()) {
            fields[1][1].setO();
        } else if (fields[1][1].isO() && fields[2][2].isO() && fields[0][0].isEmpty()) {
            fields[0][0].setO();
        } else if (fields[2][0].isO() && fields[1][1].isO() && fields[0][2].isEmpty()) {
            fields[0][2].setO();
        } else if (fields[2][0].isO() && fields[0][2].isO() && fields[1][1].isEmpty()) {
            fields[1][1].setO();
        } else if (fields[0][2].isO() && fields[1][1].isO() && fields[2][0].isEmpty()) {
            fields[2][0].setO();
        } else if (fields[0][0].isX() && fields[0][1].isX() && fields[0][2].isEmpty()) {
            fields[0][2].setO();
        } else if (fields[0][0].isX() && fields[0][2].isX() && fields[0][1].isEmpty()) {
            fields[0][1].setO();
        } else if (fields[0][2].isX() && fields[0][1].isX() && fields[0][0].isEmpty()) {
            fields[0][0].setO();
        } else if (fields[1][0].isX() && fields[1][1].isX() && fields[1][2].isEmpty()) {
            fields[1][2].setO();
        } else if (fields[1][0].isX() && fields[1][2].isX() && fields[1][1].isEmpty()) {
            fields[1][1].setO();
        } else if (fields[1][2].isX() && fields[1][1].isX() && fields[1][0].isEmpty()) {
            fields[1][0].setO();
        } else if (fields[2][0].isX() && fields[2][1].isX() && fields[2][2].isEmpty()) {
            fields[2][2].setO();
        } else if (fields[2][0].isX() && fields[2][2].isX() && fields[2][1].isEmpty()) {
            fields[2][1].setO();
        } else if (fields[2][2].isX() && fields[2][1].isX() && fields[2][0].isEmpty()) {
            fields[2][0].setO();
        } else if (fields[0][0].isX() && fields[1][0].isX() && fields[2][0].isEmpty()) {
            fields[2][0].setO();
        } else if (fields[0][0].isX() && fields[2][0].isX() && fields[1][0].isEmpty()) {
            fields[1][0].setO();
        } else if (fields[1][0].isX() && fields[2][0].isX() && fields[0][0].isEmpty()) {
            fields[0][0].setO();
        } else if (fields[0][1].isX() && fields[1][1].isX() && fields[2][1].isEmpty()) {
            fields[2][1].setO();
        } else if (fields[0][1].isX() && fields[2][1].isX() && fields[1][1].isEmpty()) {
            fields[1][1].setO();
        } else if (fields[1][1].isX() && fields[2][1].isX() && fields[0][1].isEmpty()) {
            fields[0][1].setO();
        } else if (fields[0][2].isX() && fields[1][2].isX() && fields[2][2].isEmpty()) {
            fields[2][2].setO();
        } else if (fields[0][2].isX() && fields[2][2].isX() && fields[1][2].isEmpty()) {
            fields[1][2].setO();
        } else if (fields[1][2].isX() && fields[2][2].isX() && fields[0][2].isEmpty()) {
            fields[0][2].setO();
        } else if (fields[0][0].isX() && fields[1][1].isX() && fields[2][2].isEmpty()) {
            fields[2][2].setO();
        } else if (fields[0][0].isX() && fields[2][2].isX() && fields[1][1].isEmpty()) {
            fields[1][1].setO();
        } else if (fields[1][1].isX() && fields[2][2].isX() && fields[0][0].isEmpty()) {
            fields[0][0].setO();
        } else if (fields[2][0].isX() && fields[1][1].isX() && fields[0][2].isEmpty()) {
            fields[0][2].setO();
        } else if (fields[2][0].isX() && fields[0][2].isX() && fields[1][1].isEmpty()) {
            fields[1][1].setO();
        } else if (fields[0][2].isX() && fields[1][1].isX() && fields[2][0].isEmpty()) {
            fields[2][0].setO();
        } else {
            if (fields[1][1].isEmpty()) {
                fields[1][1].setO();
            } else {
                randomCompMove(fields);
            }
        }
    }

    public static void compMove(Player player, Field[][] fields) {
        if (!player.isEasy()) {
            compMoveHard(fields);
        } else if (player.isEasy()) {
            randomCompMove(fields);
        }
    }

    public static boolean isWinner(Field[][] fields) {
        int isWin = 0;

        for (int i = 0; i < 3; i++) {
            if (fields[0][i].isX() && fields[1][i].isX() && fields[2][i].isX()) {
                isWin++;
            } else if (fields[0][i].isO() && fields[1][i].isO() && fields[2][i].isO()) {
                isWin++;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (fields[i][0].isX() && fields[i][1].isX() && fields[i][2].isX()) {
                isWin++;
            } else if (fields[i][0].isO() && fields[i][1].isO() && fields[i][2].isO()) {
                isWin++;
            }
        }

        if (fields[0][0].isX() && fields[1][1].isX() && fields[2][2].isX()) {
            isWin++;
        } else if (fields[0][0].isO() && fields[1][1].isO() && fields[2][2].isO()) {
            isWin++;
        }
        if (fields[0][2].isX() && fields[1][1].isX() && fields[2][0].isX()) {
            isWin++;
        } else if (fields[0][2].isO() && fields[1][1].isO() && fields[2][0].isO()) {
            isWin++;
        }
        return isWin > 0;
    }

    public static boolean isXWinner(Field[][] fields) {
        int isXWin = 0;

        for (int i = 0; i < 3; i++) {
            if (fields[0][i].isX() && fields[1][i].isX() && fields[2][i].isX()) {
                isXWin++;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (fields[i][0].isX() && fields[i][1].isX() && fields[i][2].isX()) {
                isXWin++;
            }
        }
        if (fields[0][0].isX() && fields[1][1].isX() && fields[2][2].isX()) {
            isXWin++;
        }
        if (fields[0][2].isX() && fields[1][1].isX() && fields[2][0].isX()) {
            isXWin++;
        }
        return isXWin > 0;
    }

    public static boolean isOWinner(Field[][] fields) {
        int isOWin = 0;
        for (int i = 0; i < 3; i++) {
            if (fields[0][i].isO() && fields[1][i].isO() && fields[2][i].isO()) {
                isOWin++;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (fields[i][0].isO() && fields[i][1].isO() && fields[i][2].isO()) {
                isOWin++;
            }
        }
        if (fields[0][0].isO() && fields[1][1].isO() && fields[2][2].isO()) {
            isOWin++;
        }
        if (fields[0][2].isO() && fields[1][1].isO() && fields[2][0].isO()) {
            isOWin++;
        }
        return isOWin > 0;
    }

    public static void checkGameStateAfterMove(BorderPane gameAppWindow, Field[][] fields, VBox mainWindow, Label gameState, Player player, HBox topPanel, VBox playerInfoGame) throws IOException {
        if (isWinner(fields)) {
            if (isXWinner(fields)) {
                player.setResult(1);
                if (player.getRounds() > 1) {
                    player.setWins();
                    playerWin(gameAppWindow, mainWindow, gameState, player, topPanel, playerInfoGame);
                    addInfoAboutCurrentGame(playerInfoGame, player);
                } else {
                    player.setWins();
                    gameResultsPanel(player, gameAppWindow, topPanel);
                    addInfoAboutCurrentGame(playerInfoGame, player);
                }
            } else if (isOWinner(fields)) {
                player.setResult(-1);
                if (player.getRounds() > 1) {
                    player.setLosses();
                    compWin(gameAppWindow, mainWindow, gameState, player, topPanel, playerInfoGame);
                    addInfoAboutCurrentGame(playerInfoGame, player);
                } else {
                    player.setLosses();
                    gameResultsPanel(player, gameAppWindow, topPanel);
                    addInfoAboutCurrentGame(playerInfoGame, player);
                }
            }
        } else if (isBoardFull(fields) && !isWinner(fields)) {
            player.setResult(0);
            if (player.getRounds() > 1) {
                player.setDraws();
                draw(gameAppWindow, mainWindow, gameState, player, topPanel, playerInfoGame);
                addInfoAboutCurrentGame(playerInfoGame, player);
            } else {
                player.setDraws();
                gameResultsPanel(player, gameAppWindow, topPanel);
                addInfoAboutCurrentGame(playerInfoGame, player);
            }
        }
    }

    public static void playerWin(BorderPane gameAppWindow, VBox mainWindow, Label gameState, Player player, HBox topPanel, VBox playerInfoGame) {
        topPanel.getChildren().remove(0);
        gameState.setText("YOU WIN !");
        topPanel.getChildren().add(0, gameState);
        nextRoundButton(gameAppWindow, mainWindow, player, topPanel, gameState, playerInfoGame);
    }

    public static void compWin(BorderPane borderPane, VBox vBox, Label label, Player player, HBox hBox, VBox playerInfoGame) {
        System.out.println("wins: " + player.getWins() + ", rounds: " + player.getRounds());
        hBox.getChildren().remove(0);
        label.setText("YOU LOOSE !");
        hBox.getChildren().add(0, label);
        nextRoundButton(borderPane, vBox, player, hBox, label, playerInfoGame);
    }

    public static void draw(BorderPane borderPane, VBox vBox, Label label, Player player, HBox hBox, VBox playerInfoGame) {
        System.out.println("wins: " + player.getWins() + ", rounds: " + player.getRounds());
        hBox.getChildren().remove(0);
        label.setText("DRAW !");
        hBox.getChildren().add(0, label);
        nextRoundButton(borderPane, vBox, player, hBox, label, playerInfoGame);
    }

    public static void addInfoAboutCurrentGame(VBox playerGameInfo, Player player) throws IOException {
        String newPlayerToRank = player.getWins() + " " + player.getLosses() + " " + player.getDraws() + " " + player.getName();
        File file = new File("src/main/resources/ranking.txt");
        Scanner scanner = new Scanner(file);
        File ranktmp = new File("src/main/resources/ranktmp.txt");
        ranktmp.createNewFile();
        PrintWriter pw = new PrintWriter(new FileWriter(ranktmp));
        ArrayList<String> rankSort = new ArrayList<>();
        rankSort.add(newPlayerToRank);
        while (scanner.hasNextLine()) {
            rankSort.add(scanner.nextLine());
        }
        Collections.sort(rankSort, new RanksComparator());
        for (String s : rankSort) {
            pw.write(s);
            pw.println();
        }
        scanner.close();
        pw.close();
        file.delete();
        ranktmp.renameTo(new File("src/main/resources/ranking.txt"));

        Label nextRoundInfo = new Label();
        nextRoundInfo.getStylesheets().add("SideWindowsColors.css");
        String lastRound = "";
        if (player.getLastResults() == 1) {
            lastRound = player.getName() + " won";
        } else if (player.getLastResults() == -1) {
            lastRound = player.getName() + " lost";
        } else if (player.getLastResults() == 0) {
            lastRound = "draw";
        }

        nextRoundInfo.setText("Round " + player.howManyRounds() + " - " + lastRound);
        playerGameInfo.getChildren().add(nextRoundInfo);
    }

    public static void nextRoundButton(BorderPane borderPane, VBox vBox, Player player, HBox hBox, Label label, VBox playerInfoGame) {
        Button nextRoundbtn = new Button();
        nextRoundbtn.setText("Play next round");
        nextRoundbtn.setMinSize(75, 75);
        nextRoundbtn.setStyle("-fx-text-fill: #2F4F4F; -fx-font-size: 15px; -fx-background-color: #F5FFFA");
        nextRoundbtn.setAlignment(Pos.CENTER);
        nextRoundbtn.setOnAction((x) -> {
            borderPane.setCenter(boardMaker(borderPane, player, vBox, hBox, playerInfoGame));
            hBox.getChildren().remove(nextRoundbtn);
            hBox.getChildren().remove(0);
            label.setText("TIC-TAC-TOE");
            hBox.getChildren().add(0, label);
        });
        hBox.getChildren().add(1, nextRoundbtn);
        hBox.setSpacing(200);
    }
}