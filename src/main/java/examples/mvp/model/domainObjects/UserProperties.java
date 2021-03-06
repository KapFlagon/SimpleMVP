package examples.mvp.model.domainObjects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UserProperties {

    // Variables
    private String selectedSkin = "SimpleMVP_Light";    // Initializing here with data because of static method usage
    private boolean isColourblindModeOn = false;        // Initializing here with data because of static method usage
    private boolean willLoadMostRecentFile = false;     // Initializing here with data because of static method usage
    private ArrayList<Path> recentItemPaths;


    // Constructors
    public void UserProperties() {
        initAllUserPropertyAttributes();
    }


    // Getters and Setters
    public String getSelectedSkin() {
        return selectedSkin;
    }
    public void setSelectedSkin(String selectedSkin) {
        this.selectedSkin = selectedSkin;
    }

    public boolean getIsColourblindModeOn() {
        return isColourblindModeOn;
    }
    public void setColourblindModeOn(boolean colourblindModeOn) {
        this.isColourblindModeOn = colourblindModeOn;
    }
    public void setColourblindModeOn(String colourblindModeOnString) {
        this.isColourblindModeOn = Boolean.valueOf(colourblindModeOnString);
    }

    public boolean getWillLoadMostRecentFile() {
        return willLoadMostRecentFile;
    }
    public void setWillLoadMostRecentFile(boolean willLoadMostRecentFile) {
        this.willLoadMostRecentFile = willLoadMostRecentFile;
    }
    public void setWillLoadMostRecentFile(String willLoadMostRecentFileString) {
        this.willLoadMostRecentFile = Boolean.valueOf(willLoadMostRecentFileString);
    }

    public ArrayList<Path> getRecentItemPaths() {
        return recentItemPaths;
    }
    public void setRecentItemPaths(ArrayList<Path> recentItemPaths) {
        this.recentItemPaths = recentItemPaths;
    }


    // Initialisation methods
    private void initAllUserPropertyAttributes() {
        initSelectedSkin();
        initColourblindModeOn();
        initWillLoadMostRecentFile();
        initRecentItemPaths();
    }

    private void initSelectedSkin() {
        selectedSkin = "SimpleMVP_Light";
    }

    private void initColourblindModeOn() {
        isColourblindModeOn = false;
    }

    private void initWillLoadMostRecentFile() {
        willLoadMostRecentFile = false;
    }

    private void initRecentItemPaths() {
        recentItemPaths = new ArrayList<Path>(6);
    }


    // Other methods
    public void insertRecentItemPath(String string) throws IOException {
        Path tempPath = Paths.get(string);
        insertRecentItemPath(tempPath);
    }

    public void insertRecentItemPath(Path newPath) throws IOException {
        // Check for any duplicate and existing entries in the list, and remove the existing one.
        for (Path iteratedPath : recentItemPaths) {
            if(Files.isSameFile(newPath, iteratedPath)) {
                recentItemPaths.remove(iteratedPath);
            }
        }
        recentItemPaths.add(0, newPath);
    }
}
