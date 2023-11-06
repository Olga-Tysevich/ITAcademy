package lesson7_8_Interfaces_Inheritance.task1.kitchenappliances;

import lesson7_8_Interfaces_Inheritance.task1.Home;

public class Fridge extends KitchenAppliance {
    private String doorOpeningDirection;
    private boolean hasDoorOpeningDirectionChanged = false;

    public Fridge(Home home, String brand, double amperage, String doorOpeningDirection) {
        super(home, "Fridge", brand, amperage, true);
        this.doorOpeningDirection = doorOpeningDirection;
    }

    public Fridge(Home home, String brand, double amperage, String doorOpeningDirection, boolean isOn) {
        super(home, "Fridge", brand, amperage, true, isOn);
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

    public String getDoorOpeningDirection() {
        return doorOpeningDirection;
    }

    public boolean getDoorDirectionChangeParameter() {
        return hasDoorOpeningDirectionChanged;
    }

}
