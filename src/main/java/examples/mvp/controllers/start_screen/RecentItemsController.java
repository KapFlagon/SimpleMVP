package examples.mvp.controllers.start_screen;

import examples.mvp.model.domainObjects.RecentItem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RecentItemsController {


    // Variables
    @FXML
    private VBox recentItems_VBox;
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
    public void addRecentItems(ArrayList<RecentItem> recentItemsList) {
        for (RecentItem recentItem : recentItemsList) {
            Button itemButton = createButton(recentItem);
            recentItems_VBox.getChildren().add(itemButton);
        }
    }

    private Button createButton(RecentItem recentItem) {
        Button temp = new Button(recentItem.getButtonText());
        temp.setOnAction(event -> {
            System.out.println(recentItem.getItemPath());
        });
        return temp;
    }

}
