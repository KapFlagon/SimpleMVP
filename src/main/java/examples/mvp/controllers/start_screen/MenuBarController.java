package examples.mvp.controllers.start_screen;

import examples.mvp.utils.gui.FileChooserPopUp;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuBarController implements Initializable {


    // Variables
    @FXML
    private MenuItem menuItem_file_new;
    @FXML
    private MenuItem menuItem_file_open;
    @FXML
    private MenuItem menuItem_file_preferences;
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
    public void onAction_file_new(ActionEvent event) throws IOException {
        System.out.println("New file");
        FileChooserPopUp.createFile(parentStage);
    }

    @FXML
    public void onAction_file_open(ActionEvent event) {
        System.out.println("Open file");
        FileChooserPopUp.openFile(parentStage);
    }

    @FXML
    public void onAction_file_preferences(ActionEvent event) {

    }

    @FXML
    public void onAction_file_exit(ActionEvent event) {
        // TODO User Properties File Helper to write properties before shutdown
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
