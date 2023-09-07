package inProgress.lesson7.task2.park;

import inProgress.lesson7.task2.TransportPark;

public abstract class Vehicle {
    private final String vehicleType;
    private final String model;
    private int numberOfVehicle;
    private double vehiclePrice;
    private final int capacity;
    private String transportParkName;
    private int vehicleIdInPark;
    private String routeServedName;

    public Vehicle(TransportPark transportPark, String vehicleType, String model, int numberOfVehicle, double vehiclePrice, int capacity) {
        this.vehicleType = vehicleType;
        this.model = model;
        this.numberOfVehicle = numberOfVehicle;
        this.vehiclePrice = vehiclePrice;
        this.capacity = capacity;
        transportPark.addVehicle(this);
        transportParkName = transportPark.getTransportParkName();
        vehicleIdInPark = transportPark.getVehicleParkSize();
    }

    public void changeVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public void changeNumberOfVehicle(int numberOfVehicle) {
        this.numberOfVehicle = numberOfVehicle;
    }

    public void setRoutesServedName(TransportPark currentTransportPark, String routesServedName) {
        if (currentTransportPark.getTransportParkName().equals(this.transportParkName)) {
            this.routeServedName = routesServedName;
        } else {
            System.out.println("You can not set a route for someone else's vehicle!");
        }
    }

    public void setTransportParkAndVehicleIdInPark(TransportPark currentTransportPark, String newTransportParkName, int vehicleIdInNewPark) {
        if (currentTransportPark.getTransportParkName().equals(this.transportParkName)) {
            this.transportParkName = newTransportParkName;
            this.vehicleIdInPark = vehicleIdInNewPark;
        } else {
            System.out.println("You can not transfer someone else's vehicle!");
        }
    }


    @Override
    public String toString() {
        String routName = routeServedName == null ? ", route not assigned" : ", route name: " + routeServedName;
        return "\nVehicle id = '" + vehicleIdInPark + '\'' +
                ", vehicle type =  " + vehicleType +
                ", model= " + model + '\'' +
                ", number of vehicle = " + numberOfVehicle +
                ", vehicle price = " + vehiclePrice +
                ", capacity = " + capacity +
                routName;
    }

    public static void printArrayOfVehicle(Vehicle[] arrayOfVehicles) {
        if (arrayOfVehicles != null) {
            System.out.print("Array of vehicle: {");
            for (Vehicle currentVehicle: arrayOfVehicles) {
                System.out.print(currentVehicle);
            }
            System.out.println("\n}");
        } else {
            System.out.println("Array of Vehicles is null!");
        }
    }

    public String getTransportParkName() {
        return transportParkName;
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

    public int getCapacity() {
        return capacity;
    }

    public String getModel() {
        return model;
    }

    public String getRouteServedName() {
        return routeServedName;
    }
}
