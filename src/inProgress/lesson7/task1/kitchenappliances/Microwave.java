package inProgress.lesson7.task1.kitchenappliances;

public class Microwave extends KitchenAppliances {
    private final int numberOfPowerLevels;
    private final double plateDiameter;
    private boolean hasPlateWithFood = false;
    private boolean isFoodWarm = false;

    public Microwave(String brand, double amperage, int numberOfPowerLevels, double plateDiameter, boolean isOn) {
        super("Microwave", brand, amperage, true, isOn);
        this.numberOfPowerLevels = numberOfPowerLevels;
        this.plateDiameter = plateDiameter;
    }


    public Microwave(String brand, double amperage, int numberOfPowerLevels, double plateDiameter) {
        super("Microwave", brand, amperage, true);
        this.numberOfPowerLevels = numberOfPowerLevels;
        this.plateDiameter = plateDiameter;
    }

    public void printDescription() {
        super.printDescription();
        System.out.println("Number of power levels: " + numberOfPowerLevels);
        System.out.println("Plate diameter: " + plateDiameter);
        if (hasPlateWithFood) {
            System.out.println("Food in the microwave");
        } else {
            System.out.println("The microwave is empty");
        }
        if (isFoodWarm) {
            System.out.println("Food is heated");
        } else {
            System.out.println("Microwave didn't work");
        }
    }

    public void printState() {
        if (getState()) {
            System.out.println("Microwave off");
        } else {
            System.out.println("Microwave on");
        }
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
        if (!getState()) {
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

    public static void printArray(Kettle[] kettles) {
        if (kettles != null) {
            for (Kettle kettle : kettles) {
                System.out.println("| Location " + kettle.getLocation() + " Type " + kettle.getType() + " model " + kettle.getBrand()
                        + " amperage " + kettle.getAmperage() + " is on " + kettle.getState() + " power " + String.format("%.2f", kettle.getPower()) +
                        " water volume " + kettle.getWaterVolume() + " |");
            }
        } else {
            System.out.println("Appliances not found");
        }
    }

}