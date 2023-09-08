package inProgress.lesson7.task2;

import inProgress.lesson7.task2.park.Bus;
import inProgress.lesson7.task2.park.Trolleybus;
import inProgress.lesson7.task2.park.Vehicle;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Random;

public class TransportPark {
    private static int numberOfTransportParks;
    private static TransportPark[] arrayOfTransportParks = new TransportPark[numberOfTransportParks];
    private final String transportParkName;
    private int numberOfRoutesServed;
    private String[] arrayOfRoutesServedNames = new String[numberOfRoutesServed];
    private int vehicleParkSize;
    private Vehicle[] carPark = new Vehicle[vehicleParkSize];
    private static int numberOfTransferredVehicles;
    private Vehicle[] transferredVehicles = new Vehicle[numberOfTransferredVehicles];
    private double costOfCarPark;

    public TransportPark(String transportParkName, String... routesName) {
        this.transportParkName = transportParkName;
        for (String routeName : routesName) {
            addRouteNameToArrayOfRSNames(routeName);
        }
        addTransportParkToArray(this);
    }

    private static void addTransportParkToArray(TransportPark transportPark) {
        numberOfTransportParks++;

        TransportPark[] updatedTransportPark = new TransportPark[numberOfTransportParks];

        int currentInTransportParkArray = numberOfTransportParks == 0 ? 0 : updatedTransportPark.length - 1;
        System.arraycopy(arrayOfTransportParks, 0, updatedTransportPark, 0, arrayOfTransportParks.length);

        updatedTransportPark[currentInTransportParkArray] = transportPark;
        arrayOfTransportParks = updatedTransportPark;
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


    public void addRouteServed(String routeName) {
        String[] updatedArrayOfRoutesServedNames = new String[++numberOfRoutesServed];
        System.arraycopy(arrayOfRoutesServedNames, 0, updatedArrayOfRoutesServedNames, 0, arrayOfRoutesServedNames.length);
        arrayOfRoutesServedNames = updatedArrayOfRoutesServedNames;
        arrayOfRoutesServedNames[numberOfRoutesServed - 1] = routeName;
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
        int positionOfVehicleInCurrentCarPark = 0;
        int numberOfVehiclesInNewTransportPark = transportPark.getVehicleParkSize() + 1;
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
            vehicleParkSize--;
            costOfCarPark -= vehicle.getVehiclePrice();

            Vehicle[] updatedTransferredVehicles = new Vehicle[transferredVehicles.length + 1];

            System.arraycopy(transferredVehicles, 0, updatedTransferredVehicles, 0, transferredVehicles.length);
            transferredVehicles = updatedTransferredVehicles;
            transferredVehicles[transferredVehicles.length - 1] = vehicle;
            numberOfTransferredVehicles++;

        } else {
            System.out.println("You can not transfer someone else's vehicle!");
        }
    }

    public void sendToRoute(Vehicle vehicle) {
        Random randomNumberOfStops = new Random();
        int numberOfStops = randomNumberOfStops.nextInt(5) + 1;

        System.out.println(vehicle.getVehicleType() + " " + vehicle.getModel() + " start moving to stop number 1");

        for (int i = 1; i <= numberOfStops; i++) {
            System.out.println(vehicle.getVehicleType() + " " + vehicle.getModel() + " moving to stop number " + i);
            System.out.println("Current stop number: " + i);
        }

        System.out.println("Route number: " + vehicle.getRouteServedName() + " completed!");
    }

    public double calculateCostOfCarPark() {
        costOfCarPark = 0;
        for (Vehicle currentVehicle : carPark) {
            costOfCarPark += currentVehicle.getVehiclePrice();
        }
        return costOfCarPark;
    }

    public void sortVehiclesForConsumption(int leftIndex, int rightIndex) {
        if (rightIndex < 0) {
            return;
        }
        double maxFuelConsumption = 0;
        int positionVehicleWithMaxFuelConsumption = 0;

        for (int i = leftIndex; i <= rightIndex; i++) {
            if (carPark[i] instanceof Bus) {
                if (maxFuelConsumption < ((Bus) carPark[i]).getFuelConsumption()) {
                    positionVehicleWithMaxFuelConsumption = i;
                    maxFuelConsumption = ((Bus) carPark[i]).getFuelConsumption();
                }
            }
        }

        Vehicle vehicleTemp = carPark[positionVehicleWithMaxFuelConsumption];
        carPark[positionVehicleWithMaxFuelConsumption] = carPark[rightIndex];
        carPark[rightIndex] = vehicleTemp;

        sortVehiclesForConsumption(leftIndex, rightIndex - 1);
    }

    public Vehicle findVehicleWithParameters(boolean findByVehicleType, String vehicleType, boolean findByVehicleModel, String model, boolean findByNumberOfVehicle,
                                             int numberOfVehicle, boolean findByVehiclePrice, double minVehiclePrice, double maxVehiclePrice,
                                             boolean findByVehicleCapacity, int minCapacity, int maxCapacity, boolean findByRouteServedName, String routeServedName) {

        Vehicle[] arrayOfVehicleTemp = findVehiclesWithParameters(findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle, numberOfVehicle,
                findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity, findByRouteServedName, routeServedName);

        return checkForSingleElement(arrayOfVehicleTemp);
    }

    public Vehicle findVehicleWithParameters(boolean findByVehicleType, String vehicleType, boolean findByVehicleModel, String model, boolean findByNumberOfVehicle,
                                             int numberOfVehicle, boolean findByVehiclePrice, double minVehiclePrice, double maxVehiclePrice,
                                             boolean findByVehicleCapacity, int minCapacity, int maxCapacity, boolean findByRouteServedName, String routeServedName,
                                             boolean findByFuelConsumption, double minFuelConsumption, double maxFuelConsumption, boolean findByFuelTankCapacity,
                                             double minFuelTankCapacity, double maxFuelTankCapacity, boolean findByPowerOfElectricMotor, double minPowerOfElectricMotor,
                                             double maxPowerOfElectricMotor) {

        Vehicle[] arrayOfVehicleTemp;
        if (findByFuelConsumption || findByPowerOfElectricMotor) {
            arrayOfVehicleTemp = findVehiclesWithParameters(findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle, numberOfVehicle,
                findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity, findByRouteServedName, routeServedName,
                findByFuelConsumption, minFuelConsumption, maxFuelConsumption, findByFuelTankCapacity, minFuelTankCapacity, maxFuelTankCapacity,
                findByPowerOfElectricMotor, minPowerOfElectricMotor, maxPowerOfElectricMotor);
        } else {
            arrayOfVehicleTemp = findVehiclesWithParameters(findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle, numberOfVehicle,
                    findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity, findByRouteServedName, routeServedName);
        }


        return checkForSingleElement(arrayOfVehicleTemp);
    }

    private Vehicle checkForSingleElement(Vehicle[] arrayOfVehicleTemp) {
        if (arrayOfVehicleTemp != null && arrayOfVehicleTemp.length == 1) {
            return arrayOfVehicleTemp[0];
        } else if (arrayOfVehicleTemp != null && arrayOfVehicleTemp.length > 1) {
            System.out.println("More than one item found! Use search for arrays!");
            return null;
        } else {
            return null;
        }
    }

    public Vehicle[] findVehiclesWithParameters(boolean findByVehicleType, String vehicleType, boolean findByVehicleModel, String model, boolean findByNumberOfVehicle,
                                                int numberOfVehicle, boolean findByVehiclePrice, double minVehiclePrice, double maxVehiclePrice,
                                                boolean findByVehicleCapacity, int minCapacity, int maxCapacity, boolean findByRouteServedName, String routeServedName) {

        int numberOfElementsInOutputArray = 0;

        for (Vehicle currentVehicle : carPark) {
            boolean checkByParameters = checkByParameters(currentVehicle, findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle, numberOfVehicle,
                    findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity, findByRouteServedName, routeServedName);
            if (checkByParameters) {
                numberOfElementsInOutputArray++;
            }
        }

        Vehicle[] outputVehicleArray = new Vehicle[numberOfElementsInOutputArray];
        int currentPositionInOutputVehicleArray = 0;

        while (currentPositionInOutputVehicleArray < outputVehicleArray.length) {
            for (Vehicle currentVehicle : carPark) {
                boolean checkByParameters = checkByParameters(currentVehicle, findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle,
                        numberOfVehicle, findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity, findByRouteServedName,
                        routeServedName);
                if (checkByParameters) {
                    outputVehicleArray[currentPositionInOutputVehicleArray] = currentVehicle;
                    currentPositionInOutputVehicleArray++;
                }
            }
        }
        if (outputVehicleArray.length != 0) {
            return outputVehicleArray;
        } else {
            System.out.println("No vehicle with such parameters were found!");
            return null;
        }
    }

    public Vehicle[] findVehiclesWithParameters(boolean findByVehicleType, String vehicleType, boolean findByVehicleModel, String model, boolean findByNumberOfVehicle,
                                                int numberOfVehicle, boolean findByVehiclePrice, double minVehiclePrice, double maxVehiclePrice,
                                                boolean findByVehicleCapacity, int minCapacity, int maxCapacity, boolean findByRouteServedName, String routeServedName,
                                                boolean findByFuelConsumption, double minFuelConsumption, double maxFuelConsumption, boolean findByFuelTankCapacity,
                                                double minFuelTankCapacity, double maxFuelTankCapacity, boolean findByPowerOfElectricMotor, double minPowerOfElectricMotor,
                                                double maxPowerOfElectricMotor) {

        int counterOfSuitableVehicle = 0;
        boolean matchConditionForBus = false;
        boolean matchConditionForTrolleybus = false;
        Vehicle[] arrayOfVehicleTemp = findVehiclesWithParameters(findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle, numberOfVehicle,
                findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity, findByRouteServedName, routeServedName);

        if (arrayOfVehicleTemp != null) {
            for (Vehicle currentVehicle : arrayOfVehicleTemp) {
                if (findByFuelConsumption || findByFuelTankCapacity) {
                    matchConditionForBus = checkByBusParameters(currentVehicle, findByFuelConsumption, minFuelConsumption, maxFuelConsumption, findByFuelTankCapacity,
                            minFuelTankCapacity, maxFuelTankCapacity);
                }
                if (findByPowerOfElectricMotor) {
                    matchConditionForTrolleybus = checkByTrolleybusParameters(currentVehicle, minPowerOfElectricMotor, maxPowerOfElectricMotor);
                }
                if (matchConditionForBus) {
                    counterOfSuitableVehicle++;
                }
                if (matchConditionForTrolleybus) {
                    counterOfSuitableVehicle++;
                }
            }
            Vehicle[] outputVehicleArray = new Vehicle[counterOfSuitableVehicle];
            int currentPositionInOutputVehicleArray = 0;

            while (currentPositionInOutputVehicleArray < outputVehicleArray.length) {
                for (Vehicle currentVehicle : carPark) {
                    if (findByFuelConsumption || findByFuelTankCapacity) {
                        matchConditionForBus = checkByBusParameters(currentVehicle, findByFuelConsumption, minFuelConsumption, maxFuelConsumption, findByFuelTankCapacity,
                                minFuelTankCapacity, maxFuelTankCapacity);
                    }
                    if (findByPowerOfElectricMotor) {
                        matchConditionForTrolleybus = checkByTrolleybusParameters(currentVehicle, minPowerOfElectricMotor, maxPowerOfElectricMotor);
                    }
                    if (matchConditionForBus || matchConditionForTrolleybus) {
                        outputVehicleArray[currentPositionInOutputVehicleArray] = currentVehicle;
                        currentPositionInOutputVehicleArray++;
                    }
                }
            }
            if (outputVehicleArray.length != 0) {
                return outputVehicleArray;
            } else {
                System.out.println("No vehicle with such parameters were found!");
                return null;
            }
        }
        System.out.println("No vehicle with such parameters were found!");
        return null;
    }

    public static Vehicle[] findVehicleFromAllParks(boolean findByVehicleType, String vehicleType, boolean findByVehicleModel, String model,
                                                    boolean findByNumberOfVehicle, int numberOfVehicle, boolean findByVehiclePrice, double minVehiclePrice,
                                                    double maxVehiclePrice, boolean findByVehicleCapacity, int minCapacity, int maxCapacity,
                                                    boolean findByRouteServedName, String routeServedName) {

        return  findVehicleFromAllParks(findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle,
                numberOfVehicle, findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity, findByRouteServedName,
                routeServedName, false, 0, 0, false, 0, 0,
                false, 0, 0);

    }

    public static Vehicle[] findVehicleFromAllParks(boolean findByVehicleType, String vehicleType, boolean findByVehicleModel, String model,
                                                    boolean findByNumberOfVehicle, int numberOfVehicle, boolean findByVehiclePrice, double minVehiclePrice,
                                                    double maxVehiclePrice, boolean findByVehicleCapacity, int minCapacity, int maxCapacity,
                                                    boolean findByRouteServedName, String routeServedName, boolean findByFuelConsumption, double minFuelConsumption,
                                                    double maxFuelConsumption, boolean findByFuelTankCapacity, double minFuelTankCapacity, double maxFuelTankCapacity,
                                                    boolean findByPowerOfElectricMotor, double minPowerOfElectricMotor, double maxPowerOfElectricMotor) {

        Vehicle[] arrayOfVehicleWithParameters;
        int counterOfRowInArrayOfVehiclesTwoD = 0;
        int currentRowInArrayOfVehiclesTwoD = 0;
        int numberOfElementsInOutputArray = 0;
        int currentPositionInOutputArray = 0;

        for (TransportPark currentTransportPark : arrayOfTransportParks) {
            if (findByFuelConsumption || findByFuelTankCapacity) {
                arrayOfVehicleWithParameters = currentTransportPark.findVehiclesWithParameters(findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle,
                        numberOfVehicle, findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity, findByRouteServedName,
                        routeServedName, findByFuelConsumption, minFuelConsumption, maxFuelConsumption, findByFuelTankCapacity, minFuelTankCapacity, maxFuelTankCapacity,
                        findByPowerOfElectricMotor, minPowerOfElectricMotor, maxPowerOfElectricMotor);
            } else {
                arrayOfVehicleWithParameters = currentTransportPark.findVehiclesWithParameters(findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle,
                        numberOfVehicle, findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity, findByRouteServedName,
                        routeServedName);
            }
            if (arrayOfVehicleWithParameters != null) {
                counterOfRowInArrayOfVehiclesTwoD++;
            }
        }

        Vehicle[][] arrayOfVehicleTempTwoD = new Vehicle[counterOfRowInArrayOfVehiclesTwoD][];

        for (TransportPark currentTransportPark : arrayOfTransportParks) {
            if (findByFuelConsumption || findByFuelTankCapacity) {
                arrayOfVehicleWithParameters = currentTransportPark.findVehiclesWithParameters(findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle,
                        numberOfVehicle, findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity, findByRouteServedName,
                        routeServedName, findByFuelConsumption, minFuelConsumption, maxFuelConsumption, findByFuelTankCapacity, minFuelTankCapacity, maxFuelTankCapacity,
                        findByPowerOfElectricMotor, minPowerOfElectricMotor, maxPowerOfElectricMotor);
            } else {
                arrayOfVehicleWithParameters = currentTransportPark.findVehiclesWithParameters(findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle,
                        numberOfVehicle, findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity, findByRouteServedName,
                        routeServedName);
            }
            if (arrayOfVehicleWithParameters != null) {
                arrayOfVehicleTempTwoD[currentRowInArrayOfVehiclesTwoD] = arrayOfVehicleWithParameters;
                currentRowInArrayOfVehiclesTwoD++;
            }
        }

        for (Vehicle[] arrayOfVehicle : arrayOfVehicleTempTwoD) {
            numberOfElementsInOutputArray += arrayOfVehicle.length;
        }

        Vehicle[] outputVehicleArray = new Vehicle[numberOfElementsInOutputArray];

        for (Vehicle[] arrayOfVehicles : arrayOfVehicleTempTwoD) {
            for (Vehicle currentVehicle : arrayOfVehicles) {
                outputVehicleArray[currentPositionInOutputArray] = currentVehicle;
                currentPositionInOutputArray++;
            }
        }

        if (outputVehicleArray.length != 0) {
            return outputVehicleArray;
        } else {
            System.out.println("No vehicle with such parameters were found!");
            return null;
        }
    }

    private static boolean checkByBusParameters(Vehicle currentVehicle, boolean findByFuelConsumption, double minFuelConsumption, double maxFuelConsumption,
                                                boolean findByFuelTankCapacity, double minFuelTankCapacity, double maxFuelTankCapacity) {

        boolean matchCondition = false;
        if (currentVehicle instanceof Bus && findByFuelConsumption) {
            matchCondition = ((Bus) currentVehicle).getFuelConsumption() >= minFuelConsumption && ((Bus) currentVehicle).getFuelConsumption() <= maxFuelConsumption;
        }
        if (currentVehicle instanceof Bus && findByFuelTankCapacity) {
            matchCondition = ((Bus) currentVehicle).getFuelTankCapacity() >= minFuelTankCapacity &&
                    ((Bus) currentVehicle).getFuelTankCapacity() <= maxFuelTankCapacity;
        }
        if (currentVehicle instanceof Bus && findByFuelConsumption && findByFuelTankCapacity) {
            matchCondition = ((Bus) currentVehicle).getFuelConsumption() >= minFuelConsumption && ((Bus) currentVehicle).getFuelConsumption() <= maxFuelConsumption
                    && ((Bus) currentVehicle).getFuelTankCapacity() >= minFuelTankCapacity
                    && ((Bus) currentVehicle).getFuelTankCapacity() <= maxFuelTankCapacity;
        }
        return matchCondition;
    }

    private static boolean checkByTrolleybusParameters(Vehicle currentVehicle, double minPowerOfElectricMotor, double maxPowerOfElectricMotor) {

        boolean matchCondition = false;
        if (currentVehicle instanceof Trolleybus) {
            matchCondition = ((Trolleybus) currentVehicle).getPowerOfElectricMotor() >= minPowerOfElectricMotor
                    && ((Trolleybus) currentVehicle).getPowerOfElectricMotor() <= maxPowerOfElectricMotor;
        }

        return matchCondition;
    }

    private static boolean checkByParameters(Vehicle currentVehicle, boolean findByVehicleType, String vehicleType, boolean findByVehicleModel, String model,
                                             boolean findByNumberOfVehicle, int numberOfVehicle, boolean findByVehiclePrice, double minVehiclePrice, double maxVehiclePrice,
                                             boolean findByVehicleCapacity, int minCapacity, int maxCapacity, boolean findByRouteServedName, String routeServedName) {

        boolean checkByType = !findByVehicleType || currentVehicle.getVehicleType().equals(vehicleType);
        boolean checkByModel = !findByVehicleModel || currentVehicle.getModel().equals(model);
        boolean checkByNumberOfVehicle = !findByNumberOfVehicle || currentVehicle.getNumberOfVehicle() == numberOfVehicle;
        boolean checkByVehiclePrice = !findByVehiclePrice || currentVehicle.getVehiclePrice() >= minVehiclePrice && currentVehicle.getVehiclePrice() <= maxVehiclePrice;
        boolean checkByVehicleCapacity = !findByVehicleCapacity || currentVehicle.getCapacity() >= minCapacity && currentVehicle.getCapacity() <= maxCapacity;
        boolean checkByRouteServedName = !findByRouteServedName || currentVehicle.getRouteServedName().equals(routeServedName);
        return checkByType && checkByModel && checkByNumberOfVehicle && checkByVehiclePrice && checkByVehicleCapacity && checkByRouteServedName;
    }

    @Override
    public String toString() {
        return "TransportPark: {" + transportParkName +
                ", number of routes served = " + numberOfRoutesServed +
                ", serviced routes: " + Arrays.toString(arrayOfRoutesServedNames) +
                ",\nCurrent car park: " + Arrays.toString(carPark) +
                "}\n";
    }

    public static void printCarParkList() {
        NumberFormat numberFormat = NumberFormat.getInstance();

        System.out.println("\nList of transport parks: {");
        for (TransportPark transportPark : arrayOfTransportParks) {
            System.out.println("Transport park name: " + transportPark.getTransportParkName() + ", total number of served routes: " + transportPark.getNumberOfRoutesServed() +
                    ", total number of vehicles: " + transportPark.getVehicleParkSize() + ", cost of car park: " + numberFormat.format(transportPark.calculateCostOfCarPark()));
        }
        System.out.println("}\n");
    }

    public void printArrayOfTransferredVehicles() {
        if (transferredVehicles.length != 0) {
            for (Vehicle currentVehicle : transferredVehicles) {
                if (currentVehicle != null) {
                    System.out.print("Details of transferred vehicle:");
                    System.out.print(currentVehicle);
                    System.out.println(", current transport park: " + currentVehicle.getTransportParkName());
                } else {
                    System.out.println("There are no vehicles in the array!");
                }
            }
        } else {
            System.out.println("There are no vehicles in the array!");
        }
    }

    public static void printArrayOfVehicle(Vehicle[] arrayOfVehicles) {
        if (arrayOfVehicles != null) {
            System.out.print("Array of vehicle: {");
            for (Vehicle currentVehicle : arrayOfVehicles) {
                System.out.print(currentVehicle);
                System.out.print(", " + currentVehicle.getTransportParkName() + " ");
            }
            System.out.println("\n}");
        } else {
            System.out.println("Array of Vehicles is null!");
        }
    }

    public int getVehicleParkSize() {
        return vehicleParkSize;
    }

    public String getTransportParkName() {
        return transportParkName;
    }

    public int getNumberOfRoutesServed() {
        return numberOfRoutesServed;
    }

    public double getCostOfCarPark() {
        return costOfCarPark;
    }

    public static int getNumberOfTransportParks() {
        return numberOfTransportParks;
    }

    public static int getNumberOfTransferredVehicles() {
        return numberOfTransferredVehicles;
    }

}
