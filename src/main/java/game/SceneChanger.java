package game;

import javafx.scene.Scene;

/**
 * Simple implementation of SceneChanger class which main task is to change game's state
 * in accordance with Game of Life rules. It also set's the program to react to appropriate
 * keyboard keys.
 */
class SceneChanger {

    /**
     * A simple method which generates Scene of the next state of the game and
     * set's the current state to this state. It also set's the program to react to appropriate
     * keyboard keys.
     */
    static void changeScene() {
        Scene updatedScene = SceneGenerator.generateNextScene();
        Main.mainStage.setScene(updatedScene);
        Keyboard.setEnterToChangeMode();
    }

}
