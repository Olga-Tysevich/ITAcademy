package lesson7_8_Interfaces_Inheritance.task1.bathroomappliances;

import lesson7_8_Interfaces_Inheritance.task1.Appliance;
import lesson7_8_Interfaces_Inheritance.task1.Home;

public abstract class BathroomAppliance extends Appliance {
    public BathroomAppliance(Home home, String type, String brand, double amperage, boolean hasElectricMotor) {
        super(home, "Bathroom", type, brand, amperage, hasElectricMotor);
    }

    public BathroomAppliance(Home home, String type, String brand, double amperage, boolean hasElectricMotor, boolean isOn) {
        super(home, "Bathroom", type, brand, amperage, hasElectricMotor, isOn);
    }

}
