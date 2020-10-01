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

public class ContactApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        SceneManager sceneManager = new SceneManager(primaryStage);

        BorderPane root = new BorderPane();
        //FXMLLoader listLoader = new FXMLLoader(getClass().getResource("/examples/mvp/list/list.fxml"));
        //root.setCenter(listLoader.load());
        //ListController listController = listLoader.getController();
//
        //FXMLLoader editorLoader = new FXMLLoader(getClass().getResource("/examples/mvp/editor/editor.fxml"));
        //root.setRight(editorLoader.load());
        //EditorController editorController = editorLoader.getController();
//
        //FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/examples/mvp/menu/menu.fxml"));
        //root.setTop(menuLoader.load());
        //MenuController menuController = menuLoader.getController();

        //DataModel model = new DataModel();
        //listController.initModel(model);
        //editorController.initModel(model);
        //menuController.initModel(model);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(sceneManager.getCurrentScene());
        primaryStage.show();
    }
    
    // annoying Eclipse launch workaround:
    public static void main(String[] args) { launch(args); }
}