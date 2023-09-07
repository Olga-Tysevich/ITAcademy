package inProgress.lesson7.task2.park;

import inProgress.lesson7.task2.TransportPark;

public class Bus extends Vehicle {
    private final double fuelTankCapacity;

    public Bus(TransportPark transportPark, String vehicleType, String model, int numberOfVehicle, double vehiclePrice, double fuelConsumption, int capacity,
               double fuelTankCapacity) {
        super(transportPark, vehicleType, model, numberOfVehicle, vehiclePrice, fuelConsumption, capacity);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public String toString() {
        return super.toString() +
                ", fuel tank capacity = " + fuelTankCapacity;
    }

    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }
}
