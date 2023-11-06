package lesson7_8_Interfaces_Inheritance.task2.park;

import lesson7_8_Interfaces_Inheritance.task2.TransportPark;

public class Trolleybus extends Vehicle{
    private final double powerOfElectricMotor;

    public Trolleybus(TransportPark transportPark, String vehicleType, String model, int numberOfVehicle, double vehiclePrice, int capacity, double powerOfElectricMotor) {
        super(transportPark, vehicleType, model, numberOfVehicle, vehiclePrice, capacity);
        this.powerOfElectricMotor = powerOfElectricMotor;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", power of electric motor = " + powerOfElectricMotor;
    }

    public double getPowerOfElectricMotor() {
        return powerOfElectricMotor;
    }
}
