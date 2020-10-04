package examples.mvp.model.domainObjects;

import javafx.stage.Stage;

import java.nio.file.Path;

public class ProgramData {


    // Variables
    private Stage parentStage;
    private UserProperties userProperties;
    private Path selectedFilePath;


    // Constructors
    public ProgramData(Stage parentStage) {
        setParentStage(parentStage);
    }
    public ProgramData(Stage parentStage, UserProperties userProperties) {
        setParentStage(parentStage);
        setUserProperties(userProperties);
    }


    // Getters and Setters
    public Stage getParentStage() {
        return parentStage;
    }
    public void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }

    public UserProperties getUserProperties() {
        return userProperties;
    }
    public void setUserProperties(UserProperties userProperties) {
        this.userProperties = userProperties;
    }

    public Path getSelectedFilePath() {
        return selectedFilePath;
    }
    public void setSelectedFilePath(Path selectedFilePath) {
        this.selectedFilePath = selectedFilePath;
    }

    
    // Initialisation methods


    // Other methods


}
