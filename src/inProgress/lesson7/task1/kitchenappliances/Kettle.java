package inProgress.lesson7.task1.kitchenappliances;

import inProgress.lesson7.task1.Appliances;

public class Kettle extends KitchenAppliances {
    private final double waterVolume;
    private boolean hasWater = false;
    private boolean boiled = false;

    public Kettle(String brand, double amperage, double waterVolume, boolean isOn) {
        super("Kettle", brand, amperage, false, isOn);
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
            System.out.println("The kettle didn't work");
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

    public Kettle[] findKettleWithParameters(boolean findByLocation, String location, boolean findByType, String type, boolean findByBrand,
                                             String brand, boolean findByAmperage, double minAmperage, double maxAmperage, boolean findByPower,
                                             double minPower, double maxPower, boolean findByState, boolean isOn, double minWaterVolume, double maxWaterVolume) {

        Appliances[] appliancesArrayTemp = findAppliancesWithSetOfParameters(findByLocation, location, findByType, type, findByBrand, brand, findByAmperage,
                minAmperage, maxAmperage, findByPower, minPower, maxPower, findByState, isOn);
        int counterOfKettle = 0;

        if (appliancesArrayTemp != null) {
            for (Appliances appliance : appliancesArrayTemp) {
                if (appliance instanceof Kettle) {
                    boolean conditionsMatch = ((Kettle) appliance).getWaterVolume() >= minWaterVolume && ((Kettle) appliance).getWaterVolume() <= maxWaterVolume;
                    if (conditionsMatch) {
                        counterOfKettle++;
                    }
                }
            }
                Kettle[] outputKettleArray = new Kettle[counterOfKettle];
                counterOfKettle = 0;

                while (counterOfKettle < outputKettleArray.length) {

                    for (Appliances outputAppliance : appliancesArrayTemp) {
                        if (outputAppliance instanceof Kettle) {
                            boolean conditionsMatch = ((Kettle) outputAppliance) .getWaterVolume() >= minWaterVolume && ((Kettle) outputAppliance) .getWaterVolume() <= maxWaterVolume;
                            if (conditionsMatch) {
                                outputKettleArray[counterOfKettle] = ((Kettle) outputAppliance);
                                counterOfKettle++;
                            }
                        }
                    }
                }

                if (outputKettleArray.length != 0) {
                    return outputKettleArray;
                }
            }
        return null;
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
