package inProgress.lesson7.task1.bathroomappliances;

import inProgress.lesson7.task1.Appliances;

public abstract class BathroomAppliances extends Appliances {
    public BathroomAppliances(String type, String brand, double amperage, boolean hasEngine, boolean isOff) {
        super("Bathroom",type, brand, amperage, hasEngine,isOff);
    }

    public BathroomAppliances(String type, String brand, double amperage, boolean hasEngine) {
        super("Bathroom", type, brand, amperage, hasEngine);
    }

}
