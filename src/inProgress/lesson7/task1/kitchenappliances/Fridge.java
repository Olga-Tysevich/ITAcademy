package inProgress.lesson7.task1.kitchenappliances;

import inProgress.lesson7.task1.Appliances;

public class Fridge extends KitchenAppliances {
    private String doorOpeningDirection;
    private boolean hasDoorOpeningDirectionChanged = false;

    public Fridge(String brand, double amperage, String doorOpeningDirection) {
        super("Fridge", brand, amperage, true);
        this.doorOpeningDirection = doorOpeningDirection;
    }

    public Fridge(String brand, double amperage, String doorOpeningDirection, boolean isOn) {
        super("Fridge", brand, amperage, true, isOn);
        this.doorOpeningDirection = doorOpeningDirection;
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("Door opening direction: " + doorOpeningDirection);
        if (!hasDoorOpeningDirectionChanged) {
            System.out.println("Door opening direction not changed");
        } else {
            System.out.println("Door opening direction changed");
        }
    }

    public void printState() {
        if (getState()) {
            System.out.println("Fridge off");
        } else {
            System.out.println("Fridge on");
        }
    }

    public void changeDoorOpeningDirection() {
        if (doorOpeningDirection.equals("left")) {
            doorOpeningDirection = "right";
            hasDoorOpeningDirectionChanged = true;
        } else if (doorOpeningDirection.equals("right")) {
            doorOpeningDirection = "left";
            hasDoorOpeningDirectionChanged = true;
        } else {
            System.out.println("Wrong value for door opening direction!");
            hasDoorOpeningDirectionChanged = false;
        }
    }

    public Fridge[] findFridgeWithParameters(boolean findByLocation, String location, boolean findByType, String type, boolean findByBrand,
                                             String brand, boolean findByAmperage, double minAmperage, double maxAmperage, boolean findByPower,
                                             double minPower, double maxPower, boolean findByState, boolean isOn, String doorOpeningDirection) {

        Appliances[] appliancesArrayTemp = findAppliancesWithSetOfParameters(findByLocation, location, findByType, type, findByBrand, brand, findByAmperage,
                minAmperage, maxAmperage, findByPower, minPower, maxPower, findByState, isOn);
        int counterOfFridge = 0;

        if (appliancesArrayTemp != null) {
            for (Appliances appliance : appliancesArrayTemp) {
                if (appliance instanceof Fridge) {
                    boolean conditionsMatch = ((Fridge) appliance).getDoorOpeningDirection().equals(doorOpeningDirection);
                    if (conditionsMatch) {
                        counterOfFridge++;
                    }
                }
            }
                Fridge[] outputFridgeArray = new Fridge[counterOfFridge];
                counterOfFridge = 0;

                while (counterOfFridge < outputFridgeArray.length) {

                    for (Appliances outputAppliance : appliancesArrayTemp) {
                        if (outputAppliance instanceof Fridge) {
                            boolean conditionsMatch = ((Fridge) outputAppliance).getDoorOpeningDirection().equals(doorOpeningDirection);
                            if (conditionsMatch) {
                                outputFridgeArray[counterOfFridge] = ((Fridge) outputAppliance);
                                counterOfFridge++;
                            }
                        }
                    }
                }

                if (outputFridgeArray.length != 0) {
                    return outputFridgeArray;
                }
            }
        return null;
    }

    public static void printArray(Fridge[] fridges) {
        if (fridges != null) {
            for (Fridge fridge : fridges) {
                System.out.println("| Location " + fridge.getLocation() + " Type " + fridge.getType() + " model " + fridge.getBrand()
                        + " amperage " + fridge.getAmperage() + " is on " + fridge.getState() + " power " + String.format("%.2f", fridge.getPower()) +
                        " door opening direction " + fridge.getDoorOpeningDirection() + " |");
            }
        } else {
            System.out.println("Appliances not found");
        }
    }

    public String getDoorOpeningDirection() {
        return doorOpeningDirection;
    }

    public boolean getDoorDirectionChangeParameter() {
        return hasDoorOpeningDirectionChanged;
    }
}
