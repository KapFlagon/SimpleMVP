package examples.mvp.utils.gui;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileChooserPopUp {


    // Variables


    // Constructors


    // Getters and Setters


    // Initialisation methods


    // Other methods
    public static File createFile(Stage parentStage) {
        String title = "Create a file";
        FileChooser fileChooser = createFileChooser(title);
        return fileChooser.showSaveDialog(parentStage);
    }

    public static File openFile(Stage parentStage) {
        String title = "Select a file to open";
        FileChooser fileChooser = createFileChooser(title);
        return fileChooser.showOpenDialog(parentStage);
    }

    private static FileChooser createFileChooser(String titleText) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(titleText);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("MVP db files", ".mvpdb")
        );
        return fileChooser;
    }

}
