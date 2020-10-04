package examples.mvp.screens;

import examples.mvp.application.PROGRAM_STATE;
import examples.mvp.model.domainObjects.CrossScreenData;
import examples.mvp.screens.start_screen.StartScreen;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URISyntaxException;

public class SceneManager {
    // Variables
    private CrossScreenData crossScreenData;
    private Scene currentScene;


    // Constructors
    public SceneManager(Stage parentStage) throws IOException, URISyntaxException {
        initCrossScreenData(parentStage);
        changeCurrentScene();
    }


    // Getters and Setters
    public CrossScreenData getProgramData() {
        return crossScreenData;
    }
    public void setProgramData(CrossScreenData crossScreenData) {
        this.crossScreenData = crossScreenData;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }
    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }


    // Initialisation methods
    public void initCrossScreenData(Stage parentStage) throws IOException, URISyntaxException {
        crossScreenData = new CrossScreenData(parentStage, PROGRAM_STATE.START);
    }


    // Other methods
    public void changeCurrentScene() throws IOException {
        switch (crossScreenData.getProgramState()) {
            case START:
                StartScreen startScreen = new StartScreen(crossScreenData);
                currentScene = startScreen.getScene();
                break;
            case EDIT:
                //EditScreen editScreen = new EditScreen();
                //currentScene = editScreen.getScene();
                break;
        }
    }

}
