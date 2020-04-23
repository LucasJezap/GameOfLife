package game;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Collections;
import java.util.Random;

/**
 * Simple implementation of QueenBeeShuttlePattern class which main task is to set the initial
 * state of the game to the Queen Bee Shuttle pattern located in a random place on the 2d grid.
 */
class QueenBeeShuttlePattern {

    /**
     * A simple method constructing and returning the Scene with Queen Bee Shuttle pattern
     * located in a random place on it.
     *
     * @return Scene with Queen Bee Shuttle pattern
     */
    static Scene getQueenBeeShuttlePattern() {
        Collections.fill(Main.colorsArray, Boolean.FALSE);
        GridPane grid = new GridPane();

        int startRowIndex = new Random().nextInt(44);
        int startColIndex = new Random().nextInt(47);

        int[] rows = {startRowIndex, startRowIndex, startRowIndex + 1, startRowIndex + 2, startRowIndex + 3,
                startRowIndex + 4, startRowIndex + 5, startRowIndex + 6, startRowIndex + 6};
        int[] cols = {startColIndex, startColIndex + 1, startColIndex + 2, startColIndex + 3, startColIndex + 3,
                startColIndex + 3, startColIndex + 2, startColIndex + 1, startColIndex};

        CoordinatePoints cp = new CoordinatePoints(rows, cols);

        for (int row = 0; row < Main.rowNum; row++) {
            for (int col = 0; col < Main.colNum; col++) {
                Rectangle rec = new Rectangle();
                rec.setWidth(Main.recSize);
                rec.setHeight(Main.recSize);

                Color color = cp.getColor(row, col);
                rec.setFill(color);

                if (color == Color.BLACK)
                    Main.colorsArray.set(row * Main.colNum + col, true);

                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
                grid.getChildren().addAll(rec);
            }
        }

        return new Scene(grid, Main.recSize * Main.rowNum, Main.recSize * Main.rowNum);
    }
}
