package inProgress.lesson7.task1.kitchenappliances;

import inProgress.lesson7.task1.Appliances;

public abstract class KitchenAppliances extends Appliances {
    public KitchenAppliances(String type, String brand, double amperage, boolean hasEngine, boolean isOff) {
        super(type, brand, amperage, hasEngine, isOff);
        changeLocation("Kitchen");
        if (!isOff) {
            calculatePower();
        }
    }

    public KitchenAppliances(String type, String brand, double power, boolean hasEngine) {
        super(type, brand, power, hasEngine);
        changeLocation("Kitchen");
    }

}
