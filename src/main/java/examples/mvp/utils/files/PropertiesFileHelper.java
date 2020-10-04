package examples.mvp.utils.files;


import examples.mvp.model.domainObjects.UserProperties;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;


public class PropertiesFileHelper {


    // Variables


    // Constructors


    // Getters and Setters
    private static void setPropertyValue(Properties propertiesObject, String key, String value) throws IOException {
        propertiesObject.setProperty(key, value);
        //storeProperties();
    }

    private static String getSelectedSkinProperty(Properties propertiesObject) {
        return propertiesObject.getProperty("selectedSkin");
    }

    private static void setSelectedSkinProperty(Properties propertiesObject, String selectedSkinValue) throws IOException {
        setPropertyValue(propertiesObject, "selectedSkin", selectedSkinValue);
    }

    private static boolean getIsColourblindModeOnProperty(Properties propertiesObject) {
        return Boolean.valueOf(propertiesObject.getProperty("isColourblindMode"));
    }

    private static void setColourblindModeOnProperty(Properties propertiesObject, boolean colourblindModeOnValue) throws IOException {
        String stringBooleanValue = String.valueOf(colourblindModeOnValue);
        setPropertyValue(propertiesObject,"isColourblindMode", stringBooleanValue);
    }

    private static boolean getWillLoadMostRecentFileProperty(Properties propertiesObject) {
        return Boolean.valueOf(propertiesObject.getProperty("willLoadMostRecentFile"));
    }

    private static void setWillLoadMostRecentFileProperty(Properties propertiesObject, boolean willLoadMostRecentFileValue) throws IOException {
        String stringBooleanValue = String.valueOf(willLoadMostRecentFileValue);
        setPropertyValue(propertiesObject,"willLoadMostRecentFile", stringBooleanValue);
    }

    private static ArrayList<Path> getRecentItemPathsProperties(Properties propertiesObject) {
        ArrayList<Path> recentFilePaths = new ArrayList<Path>();
        for (int iterator = 0; iterator < 5; iterator--) {
            int pathListPosition = iterator + 1;
            String propertyName = "recentItemPath_0" + (pathListPosition);
            String propertyValue = propertiesObject.getProperty(propertyName);
            if(!propertyValue.equals("null")) {
                Path tempPath = Paths.get(propertyValue);
                recentFilePaths.add(tempPath);
            }
        }
        return recentFilePaths;
    }

    private static void setRecentItemPathsProperties(Properties propertiesObject, ArrayList<Path> recentItemPathValues) throws IOException {
        for (int iterator = 0; iterator < recentItemPathValues.size(); iterator++) {
            int pathListPosition = iterator + 1;
            String propertyName = "recentItemPath_0" + (pathListPosition);
            propertiesObject.setProperty(propertyName, recentItemPathValues.get(iterator).toString());
        }
    }


    // Initialisation methods
    private static Properties generateDefaultPropertiesObject() {
        Properties defaultPropertiesObject = new Properties();
        //UserProperties defaultUserProperties = new UserProperties();
        //defaultPropertiesObject.setProperty("selectedSkin", defaultUserProperties.getSelectedSkin());
        defaultPropertiesObject.setProperty("selectedSkin", "mvpExample_Light");
        //defaultPropertiesObject.setProperty("isColourblindModeOn", String.valueOf(defaultUserProperties.getIsColourblindModeOn()));
        defaultPropertiesObject.setProperty("isColourblindModeOn", String.valueOf(false));
        //defaultPropertiesObject.setProperty("willLoadMostRecentFile", String.valueOf(defaultUserProperties.getWillLoadMostRecentFile()));
        defaultPropertiesObject.setProperty("willLoadMostRecentFile", String.valueOf(false));
        //ArrayList<Path> recentFilePaths = defaultUserProperties.getRecentItemPaths();
        ArrayList<Path> recentFilePaths = new ArrayList<Path>(6);
        for (int iterator = 1; iterator <= recentFilePaths.size(); iterator++) {
            String propertyName = "recentItemPath_0" + (iterator);
            defaultPropertiesObject.setProperty(propertyName, "null");
        }
        return defaultPropertiesObject;
    }

    private static Path generatePropertiesFilePath() throws URISyntaxException {
        return ProgramDirectoryHelper.parsePropertiesPath();
    }

    // Other methods
    private static Properties loadSavedProperties(Properties propertiesObject, Path userPropertiesFilePath) throws IOException {
        if (doesPropertiesFileExist(userPropertiesFilePath)) {
            loadProperties(propertiesObject, userPropertiesFilePath);
            return propertiesObject;
        } else {
            createInitialPropertiesFile(userPropertiesFilePath);
            return propertiesObject;
        }
    }

    private static boolean doesPropertiesFileExist(Path propertiesFilePath) {
        return FileAndDirectoryHelper.fileExists(propertiesFilePath);
    }

    private static void createInitialPropertiesFile(Path userPropertiesFilePath) throws IOException {
        FileAndDirectoryHelper.createFile(userPropertiesFilePath);
    }

    private static void loadProperties(Properties propertiesObject, Path propertiesFilePath) throws IOException {
        InputStream inputStream = new FileInputStream(propertiesFilePath.toString());
        propertiesObject.load(inputStream);
    }

    private static void storeProperties(Properties propertiesObject, Path propertiesFilePath) throws IOException {
        OutputStream outputStream = new FileOutputStream(propertiesFilePath.toString());
        propertiesObject.store(outputStream, null);
    }

    private static UserProperties mapPropertiesObjectToUserProperties(Properties propertiesObject) {
        UserProperties userProperties = new UserProperties();
        userProperties.setSelectedSkin(getSelectedSkinProperty(propertiesObject));
        userProperties.setColourblindModeOn(getIsColourblindModeOnProperty(propertiesObject));
        userProperties.setWillLoadMostRecentFile(getWillLoadMostRecentFileProperty(propertiesObject));
        userProperties.setRecentItemPaths(getRecentItemPathsProperties(propertiesObject));
        return userProperties;
    }

    private static Properties mapUserPropertiesToPropertiesObject(UserProperties userProperties, Properties defaultPropertiesObject) throws IOException {
        Properties propertiesObject = new Properties(defaultPropertiesObject);
        setSelectedSkinProperty(propertiesObject, userProperties.getSelectedSkin());
        setColourblindModeOnProperty(propertiesObject, userProperties.getIsColourblindModeOn());
        setWillLoadMostRecentFileProperty(propertiesObject, userProperties.getWillLoadMostRecentFile());
        setRecentItemPathsProperties(propertiesObject, userProperties.getRecentItemPaths());
        return propertiesObject;
    }


    public static UserProperties readUserPropertiesFromFile() throws URISyntaxException, IOException {
        Properties defaultPropertiesObject = generateDefaultPropertiesObject();
        Properties savedPropertiesObject = new Properties(defaultPropertiesObject);
        Path userPropertiesFilePath = generatePropertiesFilePath();
        savedPropertiesObject = loadSavedProperties(savedPropertiesObject, userPropertiesFilePath);
        return mapPropertiesObjectToUserProperties(savedPropertiesObject);
    }

    public static void writeUserPropertiesToFile(UserProperties userProperties) throws URISyntaxException, IOException {
        Properties defaultPropertiesObject = generateDefaultPropertiesObject();
        Properties mappedPropertiesObject = mapUserPropertiesToPropertiesObject(userProperties, defaultPropertiesObject);
        Path userPropertiesFilePath = generatePropertiesFilePath();
        storeProperties(mappedPropertiesObject, userPropertiesFilePath);
    }


}