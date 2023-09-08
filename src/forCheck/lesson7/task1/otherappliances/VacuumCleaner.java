package forCheck.lesson7.task1.otherappliances;

import forCheck.lesson7.task1.Appliances;

public class VacuumCleaner extends Appliances {
    private final double dustContainerVolume;
    private boolean isContainerEmpty = true;
    private boolean cleaningCompleted = false;

    public VacuumCleaner(String location, String brand, double amperage, double dustContainerVolume) {
        super(location, "Vacuum cleaner", brand, amperage, true);
        this.dustContainerVolume = dustContainerVolume;
    }

    public VacuumCleaner(String location, String brand, double amperage, double dustContainerVolume, boolean isOn) {
        super(location, "Vacuum cleaner", brand, amperage, true, isOn);
        this.dustContainerVolume = dustContainerVolume;
    }

    public double cleanTheRoom(String roomName, double cleaningAreaPerimeter) {
        double j = 0;
        if (getState() && isContainerEmpty && cleaningAreaPerimeter > 0) {
            for (int i = 0; i < dustContainerVolume && j <= cleaningAreaPerimeter; i++, j += 5) {
                System.out.println(roomName + " cleaning in progress...");
                if (i >= dustContainerVolume) {
                    System.out.println("It's time to clean the container! " + (cleaningAreaPerimeter - j) + " meters left to clear!");
                    isContainerEmpty = false;
                    return cleaningAreaPerimeter - j;
                }
            }
        } else if(getState() && !isContainerEmpty) {
            System.out.println("It's time to clean the container!");
            return cleaningAreaPerimeter;
        } else if (cleaningAreaPerimeter <= 0){
            System.out.println("Nothing to clean up!");
            return cleaningAreaPerimeter;
        } else  if (!getState()){
            System.out.println("Vacuum cleaner not plugged in!");
            return cleaningAreaPerimeter;
        }
        System.out.println(roomName + " cleaning finished!");
        cleaningCompleted = true;
        return 0;
    }

    public String toString() {
        String isCleaningFinished = this.cleaningCompleted ? ", cleaning finished" : ", vacuum cleaner didn't work";
        String isContainerEmpty = this.isContainerEmpty ? "" : ", it's time to clean the container!";
        String state = getState() ? ", vacuum cleaner on" : ", vacuum cleaner off";
        return super.toString() +
                ", dust container volume: " + dustContainerVolume +
                state +
                isCleaningFinished +
                isContainerEmpty +
                "}";
    }

    public void cleanContainer() {
        System.out.println("Dust container cleaned!");
        isContainerEmpty = true;
    }

    public double getDustContainerVolume() {
        return dustContainerVolume;
    }

    public boolean isContainerEmpty() {
        return isContainerEmpty;
    }

    public boolean isCleaningCompleted() {
        return cleaningCompleted;
    }

}
