package forCheck.lesson7.task2.park;

import forCheck.lesson7.task2.TransportPark;

public class Bus extends Vehicle {
    private final double fuelConsumption;
    private final double fuelTankCapacity;

    public Bus(TransportPark transportPark, String vehicleType, String model, int numberOfVehicle, double vehiclePrice, double fuelConsumption, int capacity,
               double fuelTankCapacity) {
        super(transportPark, vehicleType, model, numberOfVehicle, vehiclePrice, capacity);
        this.fuelConsumption = fuelConsumption;
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public String toString() {
        return super.toString() +
                ", fuel consumption = " + fuelConsumption +
                ", fuel tank capacity = " + fuelTankCapacity;
    }

    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
}
