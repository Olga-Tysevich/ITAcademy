package inProgress.lesson7.task1.bathroomappliances;

public class WaterBoiler extends BathroomAppliances {
    private final int numberOfHeatingMode;
    private boolean heated = false;

    public WaterBoiler(String brand, double amperage, int numberOfHeatingMode, boolean isOn) {
        super("Boiler", brand, amperage, false, isOn);
        this.numberOfHeatingMode = numberOfHeatingMode;
    }

    public WaterBoiler(String brand, double amperage, int numberOfHeatingMode) {
        super("Boiler", brand, amperage, false);
        this.numberOfHeatingMode = numberOfHeatingMode;
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("Number of heating mode: " + numberOfHeatingMode);
        if (heated) {
            System.out.println("There is hot water in the boiler");
        } else {
            System.out.println("Boiler didn't work");
        }
    }

    public void printState() {
        if (getState()) {
            System.out.println("Boiler off");
        } else {
            System.out.println("Boiler on");
        }
    }

    public void boilWater(int heatingMode) {
        if (!getState()) {
            for (int i = 0; i <= heatingMode * 30 ; i += 30) {
                System.out.println("Wait, the water is heating up...");
            }
            System.out.println("The water is heated!");
            heated = true;
        } else {
            System.out.println("Boiler not plugged in!");
            heated = false;
        }
    }
}
