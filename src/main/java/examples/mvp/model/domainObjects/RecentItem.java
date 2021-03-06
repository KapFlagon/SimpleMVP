package examples.mvp.model.domainObjects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.nio.file.Path;


public class RecentItem {

    // Variables
    private final StringProperty itemPath = new SimpleStringProperty();
    private final StringProperty buttonText = new SimpleStringProperty();


    // Constructors
    public RecentItem(Path itemPath) {
        setItemPath(itemPath.toString());
        setButtonText(itemPath.getFileName().toString());
    }


    // Getters and Setters

    public String getItemPath() {
        return itemPath.get();
    }
    public StringProperty itemPathProperty() {
        return itemPath;
    }
    public void setItemPath(String itemPath) {
        this.itemPath.set(itemPath);
    }

    public String getButtonText() {
        return buttonText.get();
    }
    public StringProperty buttonTextProperty() {
        return buttonText;
    }
    public void setButtonText(String buttonText) {
        this.buttonText.set(buttonText);
    }


    // Initialisation methods


    // Other methods

}
