package game;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Collections;
import java.util.Random;

/**
 * Simple implementation of RandomPattern class which main task is to set the initial
 * state of the game to the 2d grid with every cell randomly chosen to be dead or alive.
 */
class RandomPattern {

    /**
     * A simple method constructing and returning the Scene with Random pattern
     *
     * @return Scene with Random pattern
     */
    static Scene getRandomPattern() {
        Collections.fill(Main.colorsArray, Boolean.FALSE);
        GridPane grid = new GridPane();

        Random rand = new Random();
        Color[] colors = {Color.BLACK, Color.WHITE};

        for (int row = 0; row < Main.rowNum; row++) {
            for (int col = 0; col < Main.colNum; col++) {
                int n = rand.nextInt(2);
                Rectangle rec = new Rectangle();
                rec.setWidth(Main.recSize);
                rec.setHeight(Main.recSize);
                rec.setFill(colors[n]);

                if (colors[n] == Color.BLACK)
                    Main.colorsArray.set(row * Main.colNum + col, true);

                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
                grid.getChildren().addAll(rec);
            }
        }

        return new Scene(grid, Main.recSize * Main.rowNum, Main.recSize * Main.rowNum);
    }

}
