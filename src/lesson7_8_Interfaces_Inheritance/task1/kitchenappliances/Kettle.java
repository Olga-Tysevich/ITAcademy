package lesson7_8_Interfaces_Inheritance.task1.kitchenappliances;

import lesson7_8_Interfaces_Inheritance.task1.Home;

public class Kettle extends KitchenAppliance {
    private final double waterVolume;
    private boolean hasWater = false;
    private boolean waterBoiled = false;

    public Kettle(Home home, String brand, double amperage, double waterVolume) {
        super(home, "Kettle", brand, amperage, false);
        this.waterVolume = waterVolume;
    }

    public Kettle(Home home, String brand, double amperage, double waterVolume, boolean isOn) {
        super(home, "Kettle", brand, amperage, false, isOn);
        this.waterVolume = waterVolume;
    }

    public void pourTheWater(double waterVolume) {
        if (waterVolume <= this.waterVolume) {
            for (int i = 0; i < waterVolume; i += 500) {
                System.out.println("Current water volume: " + i);
            }
            System.out.println("The kettle is full!");
            hasWater = true;
        } else {
            System.out.println("Too much water for this model!");
            hasWater = false;
        }
    }

    public void boilWater() {
        if (getState()) {
            for (int i = 0; i <= waterVolume; i += 500) {
                System.out.println("Wait, the water is heating up...");
            }
            System.out.println("The kettle boiled!");
            waterBoiled = true;
        } else {
            System.out.println("Kettle not plugged in!");
            waterBoiled = false;
        }
    }

    @Override
    public String toString() {
        String kettleHasWater = hasWater ? ", there is water in the kettle" : ", there is no water in the kettle";
        String waterBoiled = this.waterBoiled ? ", the water boiled" : ", the kettle didn't work";
        String state = getState() ? ", kettle on" : ", kettle off";
        return super.toString() +
                ", max water volume: " + waterVolume +
                state +
                kettleHasWater +
                waterBoiled +
                "}";
    }

    public double getWaterVolume() {
        return waterVolume;
    }

    public boolean isHasWater() {
        return hasWater;
    }

    public boolean isWaterBoiled() {
        return waterBoiled;
    }

}
