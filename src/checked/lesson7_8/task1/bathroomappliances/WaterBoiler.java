package checked.lesson7_8.task1.bathroomappliances;

import checked.lesson7_8.task1.Vacuum;

public class WaterBoiler extends BathroomAppliance {
    private final int numberOfHeatingMode;
    private boolean waterWarmedUp = false;

    public WaterBoiler(Vacuum vacuum, String brand, double amperage, int numberOfHeatingMode) {
        super(vacuum, "Boiler", brand, amperage, false);
        this.numberOfHeatingMode = numberOfHeatingMode;
    }

    public WaterBoiler(Vacuum vacuum, String brand, double amperage, int numberOfHeatingMode, boolean isOn) {
        super(vacuum, "Boiler", brand, amperage, false, isOn);
        this.numberOfHeatingMode = numberOfHeatingMode;
    }

    public void warmUpWater(int heatingMode) {
        if (getState()) {
            for (int i = 0; i <= heatingMode; i++) {
                System.out.println("Wait, the water is heating up...");
            }
            System.out.println("The water has warmed up!");
            waterWarmedUp = true;
        } else {
            System.out.println("Boiler not plugged in!");
            waterWarmedUp = false;
        }
    }

    public String toString() {
        String waterWarmedUp = this.waterWarmedUp ? ", the water is heated!" : ", boiler not plugged in!";
        String state = getState() ? ", boiler on" : ", boiler off";
        return super.toString() +
                ", number of heating mode: " + numberOfHeatingMode +
                state +
                waterWarmedUp +
                "}";
    }

}
