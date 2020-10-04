package examples.mvp.model.domainObjects;

import examples.mvp.application.PROGRAM_STATE;
import examples.mvp.utils.PropertiesFileHelper;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Locale;

public class CrossScreenData {


    // Variables
    private Stage parentStage;
    private UserProperties userProperties;
    private Path selectedFilePath;
    private PROGRAM_STATE programState;
    private Locale userLocale;


    // Constructors
    public CrossScreenData(Stage parentStage) throws IOException, URISyntaxException {
        setParentStage(parentStage);
        initUserProperties();
        initUserLocale();
    }
    public CrossScreenData(Stage parentStage, PROGRAM_STATE programState) throws IOException, URISyntaxException {
        setParentStage(parentStage);
        setProgramState(programState);
        initUserProperties();
        initUserLocale();
    }
    public CrossScreenData(Stage parentStage, UserProperties userProperties) {
        setParentStage(parentStage);
        setUserProperties(userProperties);
        initUserLocale();
    }
    public CrossScreenData(Stage parentStage, UserProperties userProperties, PROGRAM_STATE programState) {
        setParentStage(parentStage);
        setUserProperties(userProperties);
        setProgramState(programState);
        initUserLocale();
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
    public void setSelectedFilePath(Path selectedFilePath) throws IOException {
        this.selectedFilePath = selectedFilePath;
        userProperties.insertRecentItemPath(selectedFilePath);
    }

    public PROGRAM_STATE getProgramState() {
        return programState;
    }
    public void setProgramState(PROGRAM_STATE programState) {
        this.programState = programState;
    }

    public Locale getUserLocale() {
        return userLocale;
    }
    public void setUserLocale(Locale userLocale) {
        this.userLocale = userLocale;
    }

    // Initialisation methods
    private void initUserLocale() {
        userLocale = Locale.getDefault();
    }

    private void initUserProperties() throws IOException, URISyntaxException {
        userProperties = PropertiesFileHelper.readUserPropertiesFromFile();
    }

    // Other methods


}
