package forCheck.lesson7_8.task1.kitchenappliances;

import forCheck.lesson7_8.task1.Appliance;
import forCheck.lesson7_8.task1.Vacuum;

public abstract class KitchenAppliance extends Appliance {
    public KitchenAppliance(Vacuum vacuum, String type, String brand, double power, boolean hasElectricMotor) {
        super(vacuum, "Kitchen", type, brand, power, hasElectricMotor);
    }

    public KitchenAppliance(Vacuum vacuum, String type, String brand, double amperage, boolean hasElectricMotor, boolean isOn) {
        super(vacuum, "Kitchen", type, brand, amperage, hasElectricMotor, isOn);
    }

}
