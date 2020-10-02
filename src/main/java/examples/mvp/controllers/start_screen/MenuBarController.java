package examples.mvp.controllers.start_screen;

import examples.mvp.utils.FileChooserHelper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuBarController implements Initializable {


    // Variables
    @FXML
    private MenuItem menuItem_file_new;
    @FXML
    private MenuItem menuItem_file_open;
    @FXML
    private MenuItem menuItem_file_exit;
    @FXML
    private MenuItem menuItem_help_about;
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
    public void onAction_file_new(ActionEvent event) {
        System.out.println("New file");
        FileChooserHelper.createFile(parentStage);
    }

    @FXML
    public void onAction_file_open(ActionEvent event) {
        System.out.println("Open file");
        FileChooserHelper.openFile(parentStage);
    }

    @FXML
    public void onAction_file_exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void onAction_help_about(ActionEvent event) {
        System.out.println("About");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
