package examples.mvp.controllers.start_screen;

import examples.mvp.utils.FileChooserHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {


    // Variables
    @FXML
    private Button newFile;
    @FXML
    private Button openFile;
    private Stage parentStage;


    // Constructors


    // Getters and Setters
    public Stage getParentStage() {
        return parentStage;
    }

    public void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }


    // Initialisation methods


    // Other methods
    @FXML
    public void onAction_NewFile(ActionEvent event) {
        //
        FileChooserHelper.createFile(parentStage);
    }

    @FXML
    public void onAction_OpenFile(ActionEvent event){
        //
        FileChooserHelper.openFile(parentStage);
    }

}
