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

    public Fridge[] findFridgesWithSetOfParameters(boolean findByLocation, String location, boolean findByType, String type, boolean findByBrand,
                                                   String brand, boolean findByAmperage, double minAmperage, double maxAmperage, boolean findByPower,
                                                   double minPower, double maxPower, boolean findByState, boolean isOn, String doorOpeningDirection) {

        Appliances[] appliancesTempArray = findAppliancesWithSetOfParameters(findByLocation, location, findByType, type, findByBrand, brand, findByAmperage,
                minAmperage, maxAmperage, findByPower, minPower, maxPower, findByState, isOn);

        int counterOfSuitableFridges = 0;

        if (appliancesTempArray != null) {
            for (Appliances currentAppliance : appliancesTempArray) {
                if (currentAppliance instanceof Fridge) {
                    boolean matchCondition = ((Fridge) currentAppliance).getDoorOpeningDirection().equals(doorOpeningDirection);
                    if (matchCondition) {
                        counterOfSuitableFridges++;
                    }
                }
            }

            Fridge[] outputFridgesArray = new Fridge[counterOfSuitableFridges];
            int currentPositionInOutputArray = 0;

            while (currentPositionInOutputArray < outputFridgesArray.length) {

                for (Appliances currentAppliance : appliancesTempArray) {
                    if (currentAppliance instanceof Fridge) {
                        boolean conditionsMatch = ((Fridge) currentAppliance).getDoorOpeningDirection().equals(doorOpeningDirection);
                        if (conditionsMatch) {
                            outputFridgesArray[currentPositionInOutputArray] = ((Fridge) currentAppliance);
                            currentPositionInOutputArray++;
                        }
                    }
                }
            }

            if (outputFridgesArray.length != 0) {
                return outputFridgesArray;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String reversingDoorOpeningDirection = !hasDoorOpeningDirectionChanged ? ", door opening direction not changed" : ", door opening direction changed";
        String state = getState() ? ", state: fridge on" : ", state: fridge off";
        return super.toString() +
                ", door opening direction: " + this.doorOpeningDirection +
                reversingDoorOpeningDirection +
                state +
                "}";
    }

    public static void printArray(Fridge[] arrayOfFridges) {
        if (arrayOfFridges != null) {
            System.out.println("Array of Fridges: {");
            for (Fridge fridge : arrayOfFridges) {
                System.out.println(fridge.toString());
            }
            System.out.println("}");
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
