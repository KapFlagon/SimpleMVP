package examples.mvp.controllers.start_screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {


    // Variables
    @FXML
    private Button newFile;
    @FXML
    private Button openFile;


    // Constructors


    // Getters and Setters


    // Initialisation methods


    // Other methods
    @FXML
    public void onAction_NewFile(ActionEvent event) {
        //
        System.out.println("New File");

    }

    @FXML
    public void onAction_OpenFile(ActionEvent event){
        //
        System.out.println("Open File");
    }

}
