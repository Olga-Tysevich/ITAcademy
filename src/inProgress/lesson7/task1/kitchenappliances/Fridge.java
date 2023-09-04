package inProgress.lesson7.task1.kitchenappliances;

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
            System.out.println("Refrigerator off");
        } else {
            System.out.println("Refrigerator on");
        }
    }

    public void changeDoorOpeningDirection() {
        if (doorOpeningDirection.equals("left")) {
            doorOpeningDirection = "right";
            hasDoorOpeningDirectionChanged = true;
        } else if (doorOpeningDirection.equals("right")) {
            doorOpeningDirection = "lest";
            hasDoorOpeningDirectionChanged = true;
        } else {
            System.out.println("Wrong value for door opening direction!");
            hasDoorOpeningDirectionChanged = false;
        }
    }

    public String getDoorOpeningDirection() {
        return doorOpeningDirection;
    }

    public boolean isHasDoorOpeningDirectionChanged() {
        return hasDoorOpeningDirectionChanged;
    }
}
