package game;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Simple implementation of SceneGenerator class which main task is to create new Scene of
 * game's next state and return it so it can be used in SceneChange class.
 */
class SceneGenerator {

    /**
     * A simple method generating Scene of game's next state.
     * At first, it computes new colorsArray array with call to LogicSolver class.
     * Then it creates new scene based on colorsArray object.
     *
     * @return Scene of game's next state
     */
    static Scene generateNextScene() {
        LogicSolver.generateNextSequence();

        GridPane grid = new GridPane();

        for (int row = 0; row < Main.rowNum; row++) {
            for (int col = 0; col < Main.colNum; col++) {
                Rectangle rec = new Rectangle();
                rec.setWidth(Main.recSize);
                rec.setHeight(Main.recSize);

                Boolean isAlive = Main.colorsArray.get(row * Main.colNum + col);

                Color color = Color.WHITE;
                if (isAlive)
                    color = Color.BLACK;

                rec.setFill(color);

                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
                grid.getChildren().addAll(rec);
            }
        }

        return new Scene(grid, Main.recSize * Main.rowNum, Main.recSize * Main.rowNum);
    }
}
