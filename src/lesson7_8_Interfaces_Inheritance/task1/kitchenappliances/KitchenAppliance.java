package lesson7_8_Interfaces_Inheritance.task1.kitchenappliances;

import lesson7_8_Interfaces_Inheritance.task1.Appliance;
import lesson7_8_Interfaces_Inheritance.task1.Home;

public abstract class KitchenAppliance extends Appliance {
    public KitchenAppliance(Home home, String type, String brand, double power, boolean hasElectricMotor) {
        super(home, "Kitchen", type, brand, power, hasElectricMotor);
    }

    public KitchenAppliance(Home home, String type, String brand, double amperage, boolean hasElectricMotor, boolean isOn) {
        super(home, "Kitchen", type, brand, amperage, hasElectricMotor, isOn);
    }

}
