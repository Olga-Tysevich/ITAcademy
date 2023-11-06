package lesson7_8_Interfaces_Inheritance.task1.bathroomappliances;

import lesson7_8_Interfaces_Inheritance.task1.Home;

public class WashingMachine extends BathroomAppliance {
    private final double laundryLoadWeight;
    private boolean laundryLoaded;
    private boolean laundryFinished;

    public WashingMachine(Home home, String brand, double amperage, double laundryLoadWeight) {
        super(home, "Washing machine", brand, amperage, true);
        this.laundryLoadWeight = laundryLoadWeight;
    }

    public WashingMachine(Home home, String brand, double amperage, double laundryLoadWeight, boolean isOn) {
        super(home, "Washing machine", brand, amperage, true, isOn);
        this.laundryLoadWeight = laundryLoadWeight;
    }

    public void loadLinen(double waterVolume) {
        if (waterVolume <= this.laundryLoadWeight) {
            for (double i = 0; i < laundryLoadWeight; i += 2) {
                System.out.println("Current download volume: " + i);
            }
            System.out.println("Washing machine is full!");
            laundryLoaded = true;
        } else {
            System.out.println("Too much linen for this model!");
            laundryLoaded = false;
        }
    }

    public void washLinen() {
        if (getState()) {
            for (int i = 0; i <= laundryLoadWeight; i += 2) {
                System.out.println("Wait, laundry in progress...");
            }
            System.out.println("Linen washed!");
            laundryFinished = true;
        } else {
            System.out.println("Washing machine not plugged in!");
            laundryFinished = false;
        }
    }

    public String toString() {
        String laundryLoaded = this.laundryLoaded ? ", washing machine is full" : ", there is no laundry in the washing machine";
        String laundryFinished = this.laundryFinished ? ", wash finished" : ", washing machine didn't work";
        String state = getState() ? ", washing machine on" : ", washing machine off";
        return super.toString() +
                ", laundry load weight: " + laundryLoadWeight +
                state +
                laundryLoaded +
                laundryFinished +
                "}";
    }

    public double getLaundryLoadWeight() {
        return laundryLoadWeight;
    }

    public boolean isLaundryLoaded() {
        return laundryLoaded;
    }

    public boolean isLaundryFinished() {
        return laundryFinished;
    }

}
