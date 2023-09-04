package inProgress.lesson7.task1.bathroomappliances;

public class WashingMachine extends BathroomAppliances {
    private final double laundryLoadWeight;
    private boolean laundryLoaded;
    private boolean linenWashed;

    public WashingMachine(String brand, double amperage, double laundryLoadWeight) {
        super("Washing machine", brand, amperage, true);
        this.laundryLoadWeight = laundryLoadWeight;
    }

    public WashingMachine(String brand, double amperage, double laundryLoadWeight, boolean isOn) {
        super("Washing machine", brand, amperage, true, isOn);
        this.laundryLoadWeight = laundryLoadWeight;
    }

    public void printState() {
        if (getState()) {
            System.out.println("Washing machine off");
        } else {
            System.out.println("Washing machine on");
        }
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("Laundry load weight: " + laundryLoadWeight);
        if (laundryLoaded) {
            System.out.println("Washing machine is full");
        } else {
            System.out.println("There is no laundry in the washing machine");
        }
        if (linenWashed) {
            System.out.println("Linen washed");
        } else {
            System.out.println("Washing machine didn't work");
        }
    }

    public void loadLinen(double waterVolume) {
        if (waterVolume <= this.laundryLoadWeight) {
            for (double i = 0; i < laundryLoadWeight; i += 0.5) {
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
        if (!getState()) {
            for (int i = 0; i <= laundryLoadWeight; i += 1) {
                System.out.println("Wait, laundry in progress...");
            }
            System.out.println("Linen washed!");
            linenWashed = true;
        } else {
            System.out.println("Washing machine not plugged in!");
            linenWashed = false;
        }
    }

    public double getLaundryLoadWeight() {
        return laundryLoadWeight;
    }

    public boolean isLaundryLoaded() {
        return laundryLoaded;
    }

    public boolean isLinenWashed() {
        return linenWashed;
    }
}
