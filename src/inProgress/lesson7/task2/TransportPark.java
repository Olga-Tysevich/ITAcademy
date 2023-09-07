package inProgress.lesson7.task2;

import inProgress.lesson7.task2.park.Vehicle;

import java.util.Arrays;

public class TransportPark {
    private final String transportParkName;
    private int numberOfRoutesServed;
    private String[] arrayOfRoutesServedNames = new String[numberOfRoutesServed];
    private int vehicleParkSize;
    private Vehicle[] carPark = new Vehicle[vehicleParkSize];

    public TransportPark(String transportParkName, String... routesName) {
        this.transportParkName = transportParkName;
        for (String routeName : routesName) {
            addRouteNameToArrayOfRSNames(routeName);
        }
    }

    private void addRouteNameToArrayOfRSNames(String routeName) {
        numberOfRoutesServed++;
        int currentPositionInArrayOfRSName;
        String[] arrayOfRoutesServedNames = new String[numberOfRoutesServed];

        currentPositionInArrayOfRSName = numberOfRoutesServed - 1 == 0 ? 0 : arrayOfRoutesServedNames.length - 1;
        System.arraycopy(this.arrayOfRoutesServedNames, 0, arrayOfRoutesServedNames, 0, this.arrayOfRoutesServedNames.length);

        arrayOfRoutesServedNames[currentPositionInArrayOfRSName] = routeName;
        this.arrayOfRoutesServedNames = arrayOfRoutesServedNames;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleParkSize++;
        int currentPositionInArrayOfVehicle;
        Vehicle[] arrayOfVehicle = new Vehicle[vehicleParkSize];

        currentPositionInArrayOfVehicle = vehicleParkSize - 1 == 0 ? 0 : arrayOfVehicle.length - 1;
        System.arraycopy(this.carPark, 0, arrayOfVehicle, 0, this.carPark.length);

        arrayOfVehicle[currentPositionInArrayOfVehicle] = vehicle;
        this.carPark = arrayOfVehicle;

    }

    public void setRouteForVehicle(Vehicle vehicle, String routName) {
        boolean isRouteServiced = false;
        for (String currentRoutName : arrayOfRoutesServedNames) {
            if (currentRoutName.equals(routName)) {
                vehicle.setRoutesServedName(this, routName);
                isRouteServiced = true;
                break;
            }
        }
        if (!isRouteServiced) {
            System.out.println("You do not serve this route!");
        }
    }

    public void handOverVehicle(Vehicle vehicle, TransportPark transportPark) {
        int id = vehicle.getVehicleIdInPark();
        int positionOfVehicleInCurrentCarPark = 0;
        int numberOfVehiclesInNewTransportPark = transportPark.getVehicleParkSize();
        String newTransportParkName = transportPark.getTransportParkName();

        if (vehicle.getTransportParkName().equals(this.transportParkName)) {
            for (Vehicle currentVehicle : carPark) {
                if (vehicle.getVehicleIdInPark() == currentVehicle.getVehicleIdInPark()) {
                    vehicle.setTransportParkAndVehicleIdInPark(this, newTransportParkName, numberOfVehiclesInNewTransportPark);
                    transportPark.addVehicle(vehicle);
                    break;
                }
                positionOfVehicleInCurrentCarPark++;
            }

            Vehicle[] updatedCarPark = new Vehicle[carPark.length - 1];

            System.arraycopy(carPark, 0, updatedCarPark, 0, positionOfVehicleInCurrentCarPark);
            System.arraycopy(carPark, positionOfVehicleInCurrentCarPark + 1, updatedCarPark, positionOfVehicleInCurrentCarPark,
                    carPark.length - positionOfVehicleInCurrentCarPark - 1);

            carPark = updatedCarPark;
        } else {
            System.out.println("You can not transfer someone else's vehicle!");
        }

    }

    @Override
    public String toString() {
        return "\nTransportPark: {" + transportParkName +
                ", number of routes served = " + numberOfRoutesServed +
                ", serviced routes: " + Arrays.toString(arrayOfRoutesServedNames) +
                ",\nCurrent car park: " + Arrays.toString(carPark) +
                "}\n";
    }

    public void changeNumberOfRoutesServed(int numberOfRoutesServed, String routeName) {
        String[] updatedArrayOfRoutesServedNames = new String[numberOfRoutesServed];
        System.arraycopy(arrayOfRoutesServedNames, 0, updatedArrayOfRoutesServedNames, 0 , arrayOfRoutesServedNames.length);
        arrayOfRoutesServedNames = updatedArrayOfRoutesServedNames;
        arrayOfRoutesServedNames[this.numberOfRoutesServed] = routeName;
        this.numberOfRoutesServed = numberOfRoutesServed;
    }

    public int getVehicleParkSize() {
        return vehicleParkSize;
    }

    public Vehicle[] getCarPark() {
        return carPark;
    }

    public String getTransportParkName() {
        return transportParkName;
    }

    public int getNumberOfRoutesServed() {
        return numberOfRoutesServed;
    }

    public String[] getArrayOfRoutesServedNames() {
        return arrayOfRoutesServedNames;
    }

}
