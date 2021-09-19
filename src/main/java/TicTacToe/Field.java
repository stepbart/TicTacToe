package TicTacToe;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static TicTacToe.Constants.*;
import static TicTacToe.GameService.*;

public class Field extends StackPane {

    private Text text = new Text();
    private boolean isEmpty = true;
    private boolean isX = false;
    private boolean isO = false;
    private int ticTacToeEmptyText;

    public void setX() {
        text.setFill(Paint.valueOf("#483D8B"));
        text.setFont(Font.font(50));
        text.setText(X_SIGN);
        isEmpty = false;
        isX = true;
    }

    public void setO() {
        text.setFill(Paint.valueOf("#8B0000"));
        text.setText(O_SIGN);
        isEmpty = false;
        isO = true;
    }

    public void setTextAtEmptyField() {
        if (this.getTicTacToeEmptyText() == 0) {
            this.text.setText("TIC");
            setRandomColorToText(this.text);
            this.setTicTacToeEmptyText(1);
        } else if (this.getTicTacToeEmptyText() == 1) {
            this.text.setText("TAC");
            setRandomColorToText(this.text);
            this.setTicTacToeEmptyText(2);
        } else if (this.getTicTacToeEmptyText() == 2) {
            this.text.setText("TOE");
            setRandomColorToText(this.text);
            this.setTicTacToeEmptyText(3);
        } else if (this.getTicTacToeEmptyText() == 3) {
            this.text.setText("");
            setRandomColorToText(this.text);
            this.setTicTacToeEmptyText(0);
        }
    }

    public void setText(Text text) {
        this.text = text;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isX() {
        return isX;
    }

    public boolean isO() {
        return isO;
    }

    public int getTicTacToeEmptyText() {
        return ticTacToeEmptyText;
    }

    public void setTicTacToeEmptyText(int ticTacToeEmptyText) {
        this.ticTacToeEmptyText = ticTacToeEmptyText;
    }

    public Field(Field[][] fields, Player player) {
        Rectangle r = new Rectangle(200, 200);
        r.setFill(Paint.valueOf("#F0FFFF"));
        r.setStroke(Paint.valueOf("#2F4F4F"));
        r.setStrokeWidth(2);
        this.getChildren().add(r);
        Text text = new Text();
        text.setStyle("-fx-font-size: 50");
        this.setText(text);
        this.getChildren().add(text);
    }

    public Field(String word) {
        Rectangle r = new Rectangle(200, 200);
        r.setFill(Paint.valueOf("#F0FFFF"));
        r.setStroke(Paint.valueOf("#2F4F4F"));
        r.setStrokeWidth(2);
        this.getChildren().add(r);
        Text text = new Text(word);
        text.setStyle("-fx-font-size: 50");
        this.setText(text);
        this.getChildren().add(text);
    }

    public Field() {
        Rectangle r = new Rectangle(200, 200);
        r.setFill(Paint.valueOf("#F0FFFF"));
        r.setStroke(Paint.valueOf("#2F4F4F"));
        r.setStrokeWidth(2);
        this.getChildren().add(r);
        Text text = new Text();
        text.setStyle("-fx-font-size: 50");
        this.setText(text);
        this.getChildren().add(text);
    }
}