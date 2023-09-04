package inProgress.lesson7.task1.otherappliances;

import inProgress.lesson7.task1.Appliances;

public class TV extends Appliances {
    private int numberOfChannels;

    public TV(String location, String brand, double amperage, int numberOfChannels) {
        super(location,"TV", brand, amperage, false);
        this.numberOfChannels = numberOfChannels;
        changeLocation(location);
    }

    public TV(String location, String brand, double amperage, int numberOfChannels, boolean isOn) {
        super(location,"TV", brand, amperage, false, isOn);
        this.numberOfChannels = numberOfChannels;
        changeLocation(location);
    }

    public int changeNumberOfChannels(int numberOfChannels) {
        return this.numberOfChannels = numberOfChannels;
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("Number of channel: " + numberOfChannels);
    }

    public void enableChannel(int numberOfChannel) {
        changeState(false);
        calculatePower();
        System.out.println("Channel number " + numberOfChannel + " is on");

    }

    public int getNumberOfChannels() {
        return numberOfChannels;
    }
}
