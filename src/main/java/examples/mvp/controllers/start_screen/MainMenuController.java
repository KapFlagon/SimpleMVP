package examples.mvp.controllers.start_screen;

import examples.mvp.utils.gui.FileChooserPopUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainMenuController {


    // Variables
    @FXML
    private Button newFile;
    @FXML
    private Button openFile;
    @FXML
    private Label mainMenu_Title;
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
        FileChooserPopUp.createFile(parentStage);
    }

    @FXML
    public void onAction_OpenFile(ActionEvent event){
        //
        FileChooserPopUp.openFile(parentStage);
    }

}
