package examples.mvp.screens;

import examples.mvp.model.domainObjects.CrossScreenData;


public class AbstractScreen {


    // Variables
    private CrossScreenData crossScreenData;

    // Constructors
    public AbstractScreen(CrossScreenData crossScreenData) {
        setCrossScreenData(crossScreenData);
    }


    // Getters and Setters
    public CrossScreenData getCrossScreenData() {
        return crossScreenData;
    }
    public void setCrossScreenData(CrossScreenData crossScreenData) {
        this.crossScreenData = crossScreenData;
    }


    // Initialisation methods


    // Other methods


}
