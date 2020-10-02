package examples.mvp.screens.start_screen;

import examples.mvp.controllers.start_screen.MainMenuController;
import examples.mvp.controllers.start_screen.MenuBarController;
import examples.mvp.controllers.start_screen.RecentItemsController;
import examples.mvp.screens.AbstractScreen;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StartScreen extends AbstractScreen {

    // Variables
    private BorderPane borderPane;
    private SplitPane splitPane;
    private Scene scene;
    private MenuBarController menuBarController;
    private MainMenuController mainMenuController;
    private RecentItemsController recentItemsController;


    // Constructors
    public StartScreen(Stage parentStage) throws IOException {
        super(parentStage);
        initBorderPane();
        initSplitPane();
        fillSplitPane();
        fillBorderPane();
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
    private void initBorderPane() {
        borderPane = new BorderPane();
    }

    private void initSplitPane() {
        splitPane = new SplitPane();
    }

    private void initScene() {
        scene = new Scene(borderPane,600,400);
    }

    private void initMainMenuController(FXMLLoader mainMenuLoader) {
        mainMenuController = mainMenuLoader.getController();
        mainMenuController.setParentStage(this.getParentStage());
    }

    private void initRecentItemsController(FXMLLoader recentItemsPaneLoader) {
        recentItemsController = recentItemsPaneLoader.getController();
    }

    private void initMenuBarController(FXMLLoader menuBarLoader) {
        menuBarController = menuBarLoader.getController();
        menuBarController.setParentStage(this.getParentStage());
    }


    // Other methods
    private void fillSplitPane() throws IOException {
        addMainMenuPane();
        addRecentItemsPane();
    }

    private void addMainMenuPane() throws IOException {
        Path fxmlPath = Paths.get("/examples/mvp/screens/start_screen/StartScreen_MainMenu.fxml");
        FXMLLoader mainMenuLoader = new FXMLLoader(getClass().getResource("StartScreen_MainMenu.fxml"));
        splitPane.getItems().add(mainMenuLoader.load());
        initMainMenuController(mainMenuLoader);
    }

    private void addRecentItemsPane() throws IOException {
        Path fxmlPath = Paths.get("/examples/mvp/screens/start_screen/StartScreen_RecentItems.fxml");
        FXMLLoader recentItemsPaneLoader = new FXMLLoader(getClass().getResource("StartScreen_RecentItems.fxml"));
        splitPane.getItems().add(recentItemsPaneLoader.load());
        initRecentItemsController(recentItemsPaneLoader);
    }

    private void fillBorderPane() throws IOException {
        addMenuBarToBorderPane();
        addSplitBaneToBorderPane();
    }

    private void addMenuBarToBorderPane() throws IOException {
        Path fxmlPath = Paths.get("/examples/mvp/screens/start_screen/StartScreen_MenuBar.fxml");
        FXMLLoader menuBarLoader = new FXMLLoader(getClass().getResource("StartScreen_MenuBar.fxml"));
        borderPane.setTop(menuBarLoader.load());
        initMenuBarController(menuBarLoader);
    }

    private void addSplitBaneToBorderPane() {
        borderPane.setCenter(splitPane);
    }

}
