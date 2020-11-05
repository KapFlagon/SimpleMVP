package examples.mvp.application;

import examples.mvp.screens.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import examples.mvp.controllers.editor.EditorController;
import examples.mvp.controllers.list.ListController;
import examples.mvp.controllers.menu.MenuController;
import examples.mvp.model.DataModel;

public class SimpleMVP extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("SimpleMVP");
        SceneManager sceneManager = new SceneManager(primaryStage);
        primaryStage.setScene(sceneManager.getCurrentScene());
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}