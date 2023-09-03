package inProgress.lesson7.task1.kitchenappliances;

public class Kettle extends KitchenAppliances {
    private final double waterVolume;
    private boolean hasWater = false;
    private boolean boiled = false;

    public Kettle(String brand, double amperage, double waterVolume, boolean isOff) {
        super("Kettle", brand, amperage, false, isOff);
        this.waterVolume = waterVolume;
    }

    public Kettle(String brand, double amperage, double waterVolume) {
        super("Kettle", brand, amperage, false);
        this.waterVolume = waterVolume;
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("Water volume: " + waterVolume);
        if (hasWater) {
            System.out.println("There is water in the kettle");
        } else {
            System.out.println("There is no water in the kettle");
        }
        if (boiled) {
            System.out.println("The kettle boiled");
        } else {
            System.out.println("The kettle didn't boil");
        }
    }

    public void printState() {
        if (getState()) {
            System.out.println("Kettle off");
        } else {
            System.out.println("Kettle on");
        }
    }

    public void pourTheWater(double waterVolume) {
        if (waterVolume <= this.waterVolume) {
            for (int i = 0; i < waterVolume; i += 100) {
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
        if (!getState()) {
            for (int i = 0; i <= waterVolume; i += 100) {
                System.out.println("Wait, the water is heating up...");
            }
            System.out.println("The kettle boiled!");
            boiled = true;
        } else {
            System.out.println("Kettle not plugged in!");
            boiled = false;
        }
    }

    public double getWaterVolume() {
        return waterVolume;
    }

    public boolean isHasWater() {
        return hasWater;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
