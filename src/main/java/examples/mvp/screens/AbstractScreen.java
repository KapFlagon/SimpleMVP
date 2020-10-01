package examples.mvp.screens;

import javafx.stage.Stage;

public class AbstractScreen {


    // Variables
    private Stage parentStage;

    // Constructors
    public AbstractScreen(Stage parentStage) {
        setParentStage(parentStage);
    }


    // Getters and Setters
    public Stage getParentStage() {
        return parentStage;
    }
    public void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }


    // Initialisation methods


    // Other methods


}
