package game;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Collections;
import java.util.Random;

/**
 * Simple implementation of TumblerPattern class which main task is to set the initial
 * state of the game to the Tumbler pattern located in a random place on the 2d grid.
 */
class TumblerPattern {

    /**
     * A simple method constructing and returning the Scene with Tumbler pattern
     * located in a random place on it.
     *
     * @return Scene with Tumbler pattern
     */
    static Scene getTumblerPattern() {
        Collections.fill(Main.colorsArray, Boolean.FALSE);
        GridPane grid = new GridPane();

        int startRowIndex = new Random().nextInt(45);
        int startColIndex = new Random().nextInt(44);

        int[] rows = {startRowIndex, startRowIndex, startRowIndex, startRowIndex, startRowIndex + 1, startRowIndex + 1,
                startRowIndex + 1, startRowIndex + 1, startRowIndex + 2, startRowIndex + 2, startRowIndex + 3,
                startRowIndex + 3, startRowIndex + 3, startRowIndex + 3, startRowIndex + 4, startRowIndex + 4,
                startRowIndex + 4, startRowIndex + 4, startRowIndex + 5, startRowIndex + 5, startRowIndex + 5,
                startRowIndex + 5};
        int[] cols = {startColIndex + 1, startColIndex + 2, startColIndex + 4, startColIndex + 5, startColIndex + 1,
                startColIndex + 2, startColIndex + 4, startColIndex + 5, startColIndex + 2, startColIndex + 4,
                startColIndex, startColIndex + 2, startColIndex + 4, startColIndex + 6, startColIndex,
                startColIndex + 2, startColIndex + 4, startColIndex + 6, startColIndex, startColIndex + 1,
                startColIndex + 5, startColIndex + 6};

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
