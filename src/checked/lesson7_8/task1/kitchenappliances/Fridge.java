package checked.lesson7_8.task1.kitchenappliances;

import checked.lesson7_8.task1.Vacuum;

public class Fridge extends KitchenAppliance {
    private String doorOpeningDirection;
    private boolean hasDoorOpeningDirectionChanged = false;

    public Fridge(Vacuum vacuum, String brand, double amperage, String doorOpeningDirection) {
        super(vacuum, "Fridge", brand, amperage, true);
        this.doorOpeningDirection = doorOpeningDirection;
    }

    public Fridge(Vacuum vacuum, String brand, double amperage, String doorOpeningDirection, boolean isOn) {
        super(vacuum, "Fridge", brand, amperage, true, isOn);
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
