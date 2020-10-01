package examples.mvp.screens;

import examples.mvp.application.PROGRAM_STATE;
import examples.mvp.screens.start_screen.StartScreen;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    // Variables
    private PROGRAM_STATE program_state;
    private Scene currentScene;
    private Stage parentStage;

    // Constructors
    public SceneManager(Stage parentStage) throws IOException {
        this.parentStage = parentStage;
        program_state = PROGRAM_STATE.START;
        changeCurrentScene();
    }


    // Getters and Setters
    public PROGRAM_STATE getProgram_state() {
        return program_state;
    }
    public void setProgram_state(PROGRAM_STATE program_state) {
        this.program_state = program_state;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }
    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }


    // Initialisation methods


    // Other methods
    public void changeCurrentScene() throws IOException {
        switch (program_state) {
            case START:
                StartScreen startScreen = new StartScreen(parentStage);
                currentScene = startScreen.getScene();
                break;
            case EDIT:
                //EditScreen editScreen = new EditScreen();
                //currentScene = editScreen.getScene();
                break;
        }
    }

}
