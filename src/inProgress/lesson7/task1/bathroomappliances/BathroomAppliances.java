package inProgress.lesson7.task1.bathroomappliances;

import inProgress.lesson7.task1.Appliances;

public abstract class BathroomAppliances extends Appliances {
    public BathroomAppliances(String type, String brand, double amperage, boolean hasEngine, boolean isOff) {
        super(type, brand, amperage, hasEngine,isOff);
        changeLocation("Bathroom");
    }

    public BathroomAppliances(String type, String brand, double amperage, boolean hasEngine) {
        super(type, brand, amperage, hasEngine);
        changeLocation("Bathroom");
    }

}
