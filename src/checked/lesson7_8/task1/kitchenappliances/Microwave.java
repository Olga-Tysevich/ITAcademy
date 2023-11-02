package checked.lesson7_8.task1.kitchenappliances;

import checked.lesson7_8.task1.Vacuum;

public class Microwave extends KitchenAppliance {
    private final int numberOfPowerLevels;
    private final double plateDiameter;
    private boolean hasPlateWithFood = false;
    private boolean isFoodWarm = false;

    public Microwave(Vacuum vacuum, String brand, double amperage, int numberOfPowerLevels, double plateDiameter) {
        super(vacuum, "Microwave", brand, amperage, true);
        this.numberOfPowerLevels = numberOfPowerLevels;
        this.plateDiameter = plateDiameter;
    }

    public Microwave(Vacuum vacuum, String brand, double amperage, int numberOfPowerLevels, double plateDiameter, boolean isOn) {
        super(vacuum, "Microwave", brand, amperage, true, isOn);
        this.numberOfPowerLevels = numberOfPowerLevels;
        this.plateDiameter = plateDiameter;
    }

    public void putPlate(double plateDiameter) {
        if (plateDiameter <= this.plateDiameter) {
            hasPlateWithFood = true;
            System.out.println("Plate placed");
        } else {
            hasPlateWithFood = false;
            System.out.println("The plate is too big");
        }
    }

    public void heatUp(int powerLevel) {
        if (getState()) {
            if (powerLevel <= numberOfPowerLevels) {
                for (int i = 0; i <= powerLevel; i++) {
                    System.out.println("Wait, the food is heating up...");
                    isFoodWarm = true;
                }
                System.out.println("Food warmed up");
            } else {
                System.out.println("This model does not have this mode");
                isFoodWarm = false;
            }
        } else {
            System.out.println("Microwave not plugged in!");
            isFoodWarm = false;
        }
    }

    public String toString() {
        String hasPlate = hasPlateWithFood ? ", food in the microwave" : ", the microwave is empty";
        String isFoodWarm = this.isFoodWarm ? ", food is heated" : ", microwave didn't work";
        String state = getState() ? ", microwave on" : ", microwave off";
        return super.toString() +
                ", number of power levels: " + numberOfPowerLevels +
                ", plate diameter: " + plateDiameter +
                state +
                hasPlate +
                isFoodWarm +
                "}";
    }

}
