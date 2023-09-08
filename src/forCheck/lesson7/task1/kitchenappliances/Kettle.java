package forCheck.lesson7.task1.kitchenappliances;

import forCheck.lesson7.task1.Appliances;

public class Kettle extends KitchenAppliances {
    private final double waterVolume;
    private boolean hasWater = false;
    private boolean waterBoiled = false;

    public Kettle(String brand, double amperage, double waterVolume) {
        super("Kettle", brand, amperage, false);
        this.waterVolume = waterVolume;
    }

    public Kettle(String brand, double amperage, double waterVolume, boolean isOn) {
        super("Kettle", brand, amperage, false, isOn);
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

    public static Kettle[] findKettlesWithSetOfParameters(boolean findByLocation, String location, boolean findByType, String type, boolean findByBrand,
                                                   String brand, boolean findByAmperage, double minAmperage, double maxAmperage, boolean findByPower,
                                                   double minPower, double maxPower, boolean findByState, boolean isOn, double minWaterVolume, double maxWaterVolume) {

        Appliances[] appliancesTempArray = findAppliancesWithSetOfParameters(findByLocation, location, findByType, type, findByBrand, brand, findByAmperage,
                minAmperage, maxAmperage, findByPower, minPower, maxPower, findByState, isOn);

        int counterOfSuitableKettles = 0;

        if (appliancesTempArray != null) {
            for (Appliances currentAppliance : appliancesTempArray) {
                if (currentAppliance instanceof Kettle) {
                    boolean matchCondition = ((Kettle) currentAppliance).getWaterVolume() >= minWaterVolume
                            && ((Kettle) currentAppliance).getWaterVolume() <= maxWaterVolume;
                    if (matchCondition) {
                        counterOfSuitableKettles++;
                    }
                }
            }
            Kettle[] outputKettlesArray = new Kettle[counterOfSuitableKettles];
            int currentPositionInOutputArray = 0;

            while (currentPositionInOutputArray < outputKettlesArray.length) {

                for (Appliances currentAppliance : appliancesTempArray) {
                    if (currentAppliance instanceof Kettle) {
                        boolean matchCondition = ((Kettle) currentAppliance).getWaterVolume() >= minWaterVolume
                                && ((Kettle) currentAppliance).getWaterVolume() <= maxWaterVolume;
                        if (matchCondition) {
                            outputKettlesArray[currentPositionInOutputArray] = ((Kettle) currentAppliance);
                            currentPositionInOutputArray++;
                        }
                    }
                }
            }

            if (outputKettlesArray.length != 0) {
                return outputKettlesArray;
            }
        }
        System.out.println("No kettles with such parameters were found!");
        return null;
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

    public static void printArray(Kettle[] kettlesArray) {
        if (kettlesArray != null) {
            System.out.println("Array of kettles: {");
            for (Kettle kettle : kettlesArray) {
                System.out.println(kettle.toString());
            }
            System.out.println("};\n");
        } else {
            System.out.println("Array of Kettles is null!");
        }
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
