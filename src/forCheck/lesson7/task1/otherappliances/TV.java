package forCheck.lesson7.task1.otherappliances;

import forCheck.lesson7.task1.Appliances;

public class TV extends Appliances {
    private int numberOfChannels;
    private int numberOfCurrentChannel;

    public TV(String location, String brand, double amperage, int numberOfChannels) {
        super(location, "TV", brand, amperage, false);
        this.numberOfChannels = numberOfChannels;
    }

    public TV(String location, String brand, double amperage, int numberOfChannels, boolean isOn) {
        super(location, "TV", brand, amperage, false, isOn);
        this.numberOfChannels = numberOfChannels;
        if (isOn) {
            numberOfCurrentChannel = 1;
        }

    }

    public void enableChannel(int numberOfChannel) {
        if (!getState()) {
            changeState();
            calculatePower();
        }
        System.out.println("Channel number " + numberOfChannel + " is on");
        numberOfCurrentChannel = numberOfChannel;
    }

    public String toString() {
        String state = getState() ? ", TV on" : ", TV off";
        String numberOfCurrentChannel = getState() ? ", number of current channel: " + this.numberOfCurrentChannel : "";
        return super.toString() +
                ", number of channels: " + numberOfChannels +
                state +
                numberOfCurrentChannel +
                "}";
    }

    public int changeNumberOfChannels(int numberOfChannels) {
        return this.numberOfChannels = numberOfChannels;
    }

    public int getNumberOfChannels() {
        return numberOfChannels;
    }

}
