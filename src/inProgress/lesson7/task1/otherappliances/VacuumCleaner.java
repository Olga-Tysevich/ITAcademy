package inProgress.lesson7.task1.otherappliances;

import inProgress.lesson7.task1.Appliances;

public class VacuumCleaner extends Appliances {
    private final double dustContainerVolume;
    private boolean isContainerEmpty = true;
    private boolean isCleaningFinished = false;

    public VacuumCleaner(String location, String brand, double amperage, double dustContainerVolume) {
        super(location,"Vacuum cleaner", brand, amperage, true);
        this.dustContainerVolume = dustContainerVolume;
        changeLocation(location);
    }

    public VacuumCleaner(String location, String brand, double amperage, double dustContainerVolume, boolean isOn) {
        super(location,"Vacuum cleaner", brand, amperage, true, isOn);
        this.dustContainerVolume = dustContainerVolume;
        changeLocation(location);
    }

    public void printState() {
        if (getState()) {
            System.out.println("Vacuum cleaner off");
        } else {
            System.out.println("Vacuum cleaner on");
        }
    }

//    @Override
//    public void printDescription() {
//        super.printDescription();
//        System.out.println("Dust container volume: " + dustContainerVolume);
//        if (!isCleaningFinished) {
//            System.out.println("Vacuum cleaner didn't work");
//        } else {
//            System.out.println("Cleaning finished");
//        }
//        if (!isContainerEmpty) {
//            System.out.println("It's time to clean the container!");
//        }
//    }

    public void vacuumTheRoom(String roomName, double roomPerimeter) {
        if (getState() && isContainerEmpty) {
            for (double i = 0, j = 0; i < dustContainerVolume && j <= roomPerimeter; i += 0.1, j += 5) {
                System.out.println("Cleaning in progress...");
                if (!isContainerEmpty) {
                    System.out.println("It's time to clean the container!");
                    isContainerEmpty = false;
                    break;
                }
            }
            System.out.println("Cleaning finished!");
            isCleaningFinished = true;
        } else {
            System.out.println("It's time to clean the container!");
        }
    }

    public void cleanContainer() {
        isContainerEmpty = true;
    }

    public double getDustContainerVolume() {
        return dustContainerVolume;
    }

    public boolean isContainerEmpty() {
        return isContainerEmpty;
    }

    public boolean isCleaningFinished() {
        return isCleaningFinished;
    }
}
