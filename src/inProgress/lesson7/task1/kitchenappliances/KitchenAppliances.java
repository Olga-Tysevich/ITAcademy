package inProgress.lesson7.task1.kitchenappliances;

import inProgress.lesson7.task1.Appliances;

public abstract class KitchenAppliances extends Appliances {
    public KitchenAppliances(String type, String brand, double amperage, boolean hasEngine, boolean isOff) {
        super("Kitchen", type, brand, amperage, hasEngine, isOff);
    }

    public KitchenAppliances(String type, String brand, double power, boolean hasEngine) {
        super("Kitchen", type, brand, power, hasEngine);
    }

}
