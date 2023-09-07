package inProgress.lesson7.task2.park;

import inProgress.lesson7.task2.TransportPark;

public abstract class Vehicle {
    private final String vehicleType;
    private final String model;
    private int numberOfVehicle;
    private double vehiclePrice;
    private final double fuelConsumption;
    private final int capacity;
    private String transportParkName;
    private int vehicleIdInPark;
    private String routesServedName;

    public Vehicle(TransportPark transportPark, String vehicleType, String model, int numberOfVehicle, double vehiclePrice, double fuelConsumption, int capacity) {
        this.vehicleType = vehicleType;
        this.model = model;
        this.numberOfVehicle = numberOfVehicle;
        this.vehiclePrice = vehiclePrice;
        this.fuelConsumption = fuelConsumption;
        this.capacity = capacity;
        transportPark.addVehicle(this);
        transportParkName = transportPark.getTransportParkName();
        vehicleIdInPark = transportPark.getVehicleParkSize();
    }

    @Override
    public String toString() {
        return "\nVehicle type = '" + vehicleType + '\'' +
                ", model= " + model + '\'' +
                ", number of vehicle = " + numberOfVehicle +
                ", vehicle price = " + vehiclePrice +
                ", fuel consumption = " + fuelConsumption +
                ", capacity = " + capacity +
                ", vehicle id = " + vehicleIdInPark;
    }

    public void changeVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public void changeNumberOfVehicle(int numberOfVehicle) {
        this.numberOfVehicle = numberOfVehicle;
    }

    public void setTransportParkAndVehicleIdInPark(TransportPark currentTransportPark, String newTransportParkName, int vehicleIdInNewPark) {
        if (currentTransportPark.getTransportParkName().equals(this.transportParkName)) {
            this.transportParkName = newTransportParkName;
            this.vehicleIdInPark = vehicleIdInNewPark;
        } else {
            System.out.println("You can not transfer someone else's vehicle!");
        }
    }

    public int getVehicleIdInPark() {
        return vehicleIdInPark;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getNumberOfVehicle() {
        return numberOfVehicle;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getCapacity() {
        return capacity;
    }
}
