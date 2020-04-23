package game;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Main class of the Game of Life application. It stores all important information about the
 * program and launches the initial state of the game.
 */
public class Main extends Application {

    /*
     * screenResolution - the resolution of the user screen, helpful to scale the windows
     * mainStage - main window of the game containing the game
     * helpStage - helping window of the game containing the instructions
     * colorsArray - Boolean array containing current state of the game
     * cycleLength - number of cycles in the game, the default is infinite
     * rowNum - number of rows on the grid, the default is 50
     * colNum - number of columns on the grid, the default is 50
     * recSize - size of every cell width and height, computed with respect to screen resolution
     * framesPerSecond - number of updates in one second, the default is 30
     * currentPattern - current initial pattern of the game, at the start it's random
     * isStopped - boolean information about the game being stopped at the time
     * allowNeighbours - boolean information about the game allowing boundary neighbours
     */
    static Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
    static Stage mainStage;
    static Stage helpStage;
    static ArrayList<Boolean> colorsArray;
    static int cycleLength = Animation.INDEFINITE;
    static int rowNum = 50;
    static int colNum = 50;
    static int recSize;
    static double framesPerSecond = 30;
    static Pattern currentPattern;
    static boolean isStopped;
    static boolean allowNeighbours;

    /**
     * The compulsory method which sets and opens the main and helping windows.
     * It also launches the proper game.
     *
     * @param primaryStage - the main Stage object of the application
     */
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        colorsArray = new ArrayList<>(Collections.nCopies(rowNum * colNum, false));
        currentPattern = Pattern.RANDOM;
        isStopped = true;
        allowNeighbours = false;
        recSize = (screenResolution.height - 50) / rowNum;

        helpStage = Instruction.getInstructionStage();
        helpStage.show();

        Scene firstScene = RandomPattern.getRandomPattern();
        mainStage.setTitle("Random Pattern");
        mainStage.setScene(firstScene);
        mainStage.setX(0);
        mainStage.setY(0);
        mainStage.show();

        Gameplay gp = new Gameplay();
        gp.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

