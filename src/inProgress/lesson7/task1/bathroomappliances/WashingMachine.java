package inProgress.lesson7.task1.bathroomappliances;

public class WashingMachine extends BathroomAppliances {
    private final double laundryLoadWeight;
    private boolean laundryLoaded;
    private boolean laundryFinished;

    public WashingMachine(String brand, double amperage, double laundryLoadWeight) {
        super("Washing machine", brand, amperage, true);
        this.laundryLoadWeight = laundryLoadWeight;
    }

    public WashingMachine(String brand, double amperage, double laundryLoadWeight, boolean isOn) {
        super("Washing machine", brand, amperage, true, isOn);
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
