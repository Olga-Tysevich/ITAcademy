package forCheck.lesson7.task1.bathroomappliances;

import forCheck.lesson7.task1.Appliances;

public abstract class BathroomAppliances extends Appliances {
    public BathroomAppliances(String type, String brand, double amperage, boolean hasElectricMotor) {
        super("Bathroom", type, brand, amperage, hasElectricMotor);
    }

    public BathroomAppliances(String type, String brand, double amperage, boolean hasElectricMotor, boolean isOn) {
        super("Bathroom",type, brand, amperage, hasElectricMotor,isOn);
    }

}
