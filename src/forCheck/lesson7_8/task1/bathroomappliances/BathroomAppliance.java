package forCheck.lesson7_8.task1.bathroomappliances;

import forCheck.lesson7_8.task1.Appliance;
import forCheck.lesson7_8.task1.Vacuum;

public abstract class BathroomAppliance extends Appliance {
    public BathroomAppliance(Vacuum vacuum, String type, String brand, double amperage, boolean hasElectricMotor) {
        super(vacuum, "Bathroom", type, brand, amperage, hasElectricMotor);
    }

    public BathroomAppliance(Vacuum vacuum, String type, String brand, double amperage, boolean hasElectricMotor, boolean isOn) {
        super(vacuum, "Bathroom", type, brand, amperage, hasElectricMotor, isOn);
    }

}
