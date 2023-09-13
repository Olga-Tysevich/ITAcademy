package forCheck.lesson7_8.task1.kitchenappliances;

import forCheck.lesson7_8.task1.Appliances;

public abstract class KitchenAppliances extends Appliances {
    public KitchenAppliances(String type, String brand, double power, boolean hasElectricMotor) {
        super("Kitchen", type, brand, power, hasElectricMotor);
    }

    public KitchenAppliances(String type, String brand, double amperage, boolean hasElectricMotor, boolean isOn) {
        super("Kitchen", type, brand, amperage, hasElectricMotor, isOn);
    }

}
