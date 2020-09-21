package examples.mvp.screens;

import examples.mvp.controllers.list.ListController;
import examples.mvp.controllers.start_screen.MainMenuController;
import examples.mvp.controllers.start_screen.RecentItemsController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StartScreen {

    // Variables
    private SplitPane splitPane;
    private Scene scene;
    private MainMenuController mainMenuController;
    private RecentItemsController recentItemsController;


    // Constructors
    public StartScreen() throws IOException {
        initSplitPane();
        addMainMenuPane();
        addRecentItemsPane();
        initScene();
    }

    // Getters and Setters
    public SplitPane getSplitPane() {
        return splitPane;
    }
    public void setSplitPane(SplitPane splitPane) {
        this.splitPane = splitPane;
    }

    public Scene getScene() {
        return scene;
    }
    public void setScene(Scene scene) {
        this.scene = scene;
    }


    // Initialisation methods
    private void initSplitPane() {
        splitPane = new SplitPane();
    }

    private void initScene() {
        scene = new Scene(splitPane);
    }

    private void initMainMenuController(FXMLLoader mainMenuLoader) {
        mainMenuController = mainMenuLoader.getController();
    }

    private void initRecentItemsController(FXMLLoader recentItemsPaneLoader) {
        recentItemsController = recentItemsPaneLoader.getController();
    }


    // Other methods
    private void addMainMenuPane() throws IOException {
        Path fxmlPath = Paths.get("/examples/mvp/screens/start_screen/MainMenu.fxml");
        FXMLLoader mainMenuLoader = new FXMLLoader(getClass().getResource(fxmlPath.toString()));
        splitPane.getItems().add(mainMenuLoader.load());
        initMainMenuController(mainMenuLoader);
    }

    private void addRecentItemsPane() throws IOException {
        Path fxmlPath = Paths.get("/examples/mvp/screens/start_screen/RecentItems.fxml");
        FXMLLoader recentItemsPaneLoader = new FXMLLoader(getClass().getResource(fxmlPath.toString()));
        splitPane.getItems().add(recentItemsPaneLoader.load());
        initRecentItemsController(recentItemsPaneLoader);
    }

}
