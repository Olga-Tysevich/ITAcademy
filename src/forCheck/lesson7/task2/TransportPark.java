package forCheck.lesson7.task2;

import forCheck.lesson7.task2.park.Bus;
import forCheck.lesson7.task2.park.Trolleybus;
import forCheck.lesson7.task2.park.Vehicle;

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
    private Vehicle[] vehiclePark = new Vehicle[vehicleParkSize];
    private static int numberOfTransferredVehicles;
    private Vehicle[] arrayOfTransferredVehicles = new Vehicle[numberOfTransferredVehicles];
    private double costOfVehiclePark;

    public TransportPark(String transportParkName, String... namesOfRoutesServed) {
        this.transportParkName = transportParkName;
        for (String routeName : namesOfRoutesServed) {
            addRouteNameToArrayOfRSNames(routeName);
        }
        addTransportParkToArrayTP(this);
    }

    private static void addTransportParkToArrayTP(TransportPark transportPark) {
        numberOfTransportParks++;

        TransportPark[] arrayOfTransportParks = new TransportPark[numberOfTransportParks];

        int currentPositionInTPArray = arrayOfTransportParks.length - 1;
        System.arraycopy(TransportPark.arrayOfTransportParks, 0, arrayOfTransportParks, 0, TransportPark.arrayOfTransportParks.length);

        arrayOfTransportParks[currentPositionInTPArray] = transportPark;
        TransportPark.arrayOfTransportParks = arrayOfTransportParks;
    }

    private void addRouteNameToArrayOfRSNames(String routeName) {
        numberOfRoutesServed++;

        String[] arrayOfRoutesServedNames = new String[numberOfRoutesServed];

        int currentPositionInArrayOfRSName = arrayOfRoutesServedNames.length - 1;
        System.arraycopy(this.arrayOfRoutesServedNames, 0, arrayOfRoutesServedNames, 0, this.arrayOfRoutesServedNames.length);

        arrayOfRoutesServedNames[currentPositionInArrayOfRSName] = routeName;
        this.arrayOfRoutesServedNames = arrayOfRoutesServedNames;
    }

    public void addVehicleToTransportPark(Vehicle vehicle) {
        vehicleParkSize++;

        Vehicle[] arrayOfVehicle = new Vehicle[vehicleParkSize];

        int currentPositionInArrayOfVehicle = arrayOfVehicle.length - 1;
        System.arraycopy(this.vehiclePark, 0, arrayOfVehicle, 0, this.vehiclePark.length);

        arrayOfVehicle[currentPositionInArrayOfVehicle] = vehicle;
        this.vehiclePark = arrayOfVehicle;
    }

    public void addServedRouteToTransportPark(String routeName) {
        String[] arrayOfRoutesServedNames = new String[++numberOfRoutesServed];

        System.arraycopy(this.arrayOfRoutesServedNames, 0, arrayOfRoutesServedNames, 0, this.arrayOfRoutesServedNames.length);
        this.arrayOfRoutesServedNames = arrayOfRoutesServedNames;
        this.arrayOfRoutesServedNames[numberOfRoutesServed - 1] = routeName;
    }

    public void setRouteForVehicle(Vehicle vehicle, String routeName) {
        boolean isRouteServiced = false;

        for (String currentRouteName : arrayOfRoutesServedNames) {
            if (currentRouteName.equals(routeName)) {
                vehicle.setServedRouteName(this, routeName);
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
            for (Vehicle currentVehicle : vehiclePark) {
                if (vehicle.getVehicleIdInPark() == currentVehicle.getVehicleIdInPark()) {
                    vehicle.setTransportParkAndVehicleIdInPark(this, newTransportParkName, numberOfVehiclesInNewTransportPark);
                    transportPark.addVehicleToTransportPark(vehicle);
                    break;
                }
                positionOfVehicleInCurrentCarPark++;
            }

            Vehicle[] updatedVehiclePark = new Vehicle[vehiclePark.length - 1];

            System.arraycopy(vehiclePark, 0, updatedVehiclePark, 0, positionOfVehicleInCurrentCarPark);
            System.arraycopy(vehiclePark, positionOfVehicleInCurrentCarPark + 1, updatedVehiclePark, positionOfVehicleInCurrentCarPark,
                    vehiclePark.length - positionOfVehicleInCurrentCarPark - 1);

            vehiclePark = updatedVehiclePark;
            vehicleParkSize--;
            costOfVehiclePark -= vehicle.getVehiclePrice();

            Vehicle[] updatedTransferredVehicles = new Vehicle[arrayOfTransferredVehicles.length + 1];

            System.arraycopy(arrayOfTransferredVehicles, 0, updatedTransferredVehicles, 0, arrayOfTransferredVehicles.length);
            arrayOfTransferredVehicles = updatedTransferredVehicles;
            arrayOfTransferredVehicles[arrayOfTransferredVehicles.length - 1] = vehicle;
            numberOfTransferredVehicles++;

        } else {
            System.out.println("You can not transfer someone else's vehicle!");
        }
    }

    public void sendToRoute(Vehicle vehicle) {
        Random randomNumberOfStops = new Random();
        int numberOfStops = randomNumberOfStops.nextInt(5) + 1;

        System.out.println(vehicle.getVehicleType() + " " + vehicle.getModel() + " start driving to stop number 1");

        for (int i = 1; i <= numberOfStops; i++) {
            System.out.println(vehicle.getVehicleType() + " " + vehicle.getModel() + " driving to stop number " + i);
            System.out.println("Current stop number: " + i);
        }

        System.out.println("Route number: " + vehicle.getRouteServedName() + " completed!");
    }

    public double calculateCostOfCarPark() {
        costOfVehiclePark = 0;

        for (Vehicle currentVehicle : vehiclePark) {
            costOfVehiclePark += currentVehicle.getVehiclePrice();
        }

        return costOfVehiclePark;
    }

    public void sortVehiclesForFuelConsumption(int leftIndex, int rightIndex) {
        if (rightIndex < 0) {
            return;
        }

        double maxFuelConsumption = 0;
        int positionVehicleWithMaxFuelConsumption = 0;

        for (int i = leftIndex; i <= rightIndex; i++) {
            if (vehiclePark[i] instanceof Bus) {
                if (maxFuelConsumption < ((Bus) vehiclePark[i]).getFuelConsumption()) {
                    positionVehicleWithMaxFuelConsumption = i;
                    maxFuelConsumption = ((Bus) vehiclePark[i]).getFuelConsumption();
                }
            }
        }

        Vehicle vehicleTemp = vehiclePark[positionVehicleWithMaxFuelConsumption];
        vehiclePark[positionVehicleWithMaxFuelConsumption] = vehiclePark[rightIndex];
        vehiclePark[rightIndex] = vehicleTemp;

        sortVehiclesForFuelConsumption(leftIndex, rightIndex - 1);
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

        if (findByFuelConsumption || findByFuelTankCapacity || findByPowerOfElectricMotor) {
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

        for (Vehicle currentVehicle : vehiclePark) {
            boolean checkByParameters = checkByParameters(currentVehicle, findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle, numberOfVehicle,
                    findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity, findByRouteServedName, routeServedName);
            if (checkByParameters) {
                numberOfElementsInOutputArray++;
            }
        }

        Vehicle[] outputVehicleArray = new Vehicle[numberOfElementsInOutputArray];
        int currentPositionInOutputVehicleArray = 0;

        while (currentPositionInOutputVehicleArray < outputVehicleArray.length) {
            for (Vehicle currentVehicle : vehiclePark) {
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
            System.out.println("No vehicle with such parameters were found in " + getTransportParkName());
            return null;
        }
    }

    public Vehicle[] findVehiclesWithParameters(boolean findByVehicleType, String vehicleType, boolean findByVehicleModel, String model, boolean findByNumberOfVehicle,
                                                int numberOfVehicle, boolean findByVehiclePrice, double minVehiclePrice, double maxVehiclePrice,
                                                boolean findByVehicleCapacity, int minCapacity, int maxCapacity, boolean findByRouteServedName, String routeServedName,
                                                boolean findByFuelConsumption, double minFuelConsumption, double maxFuelConsumption, boolean findByFuelTankCapacity,
                                                double minFuelTankCapacity, double maxFuelTankCapacity, boolean findByPowerOfElectricMotor, double minPowerOfElectricMotor,
                                                double maxPowerOfElectricMotor) {

        int counterOfSuitableVehicles = 0;
        boolean matchConditionForBus = false;
        boolean matchConditionForTrolleybus = false;

        Vehicle[] arrayOfVehiclesTemp = findVehiclesWithParameters(findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle, numberOfVehicle,
                findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity, findByRouteServedName, routeServedName);

        if (arrayOfVehiclesTemp != null) {

            for (Vehicle currentVehicle : arrayOfVehiclesTemp) {
                if (findByFuelConsumption || findByFuelTankCapacity) {
                    matchConditionForBus = checkBusParameters(currentVehicle, findByFuelConsumption, minFuelConsumption, maxFuelConsumption, findByFuelTankCapacity,
                            minFuelTankCapacity, maxFuelTankCapacity);
                }
                if (findByPowerOfElectricMotor) {
                    matchConditionForTrolleybus = checkTrolleybusParameters(currentVehicle, minPowerOfElectricMotor, maxPowerOfElectricMotor);
                }
                if (matchConditionForBus) {
                    counterOfSuitableVehicles++;
                }
                if (matchConditionForTrolleybus) {
                    counterOfSuitableVehicles++;
                }
            }

            Vehicle[] outputVehicleArray = new Vehicle[counterOfSuitableVehicles];
            int currentPositionInOutputVehicleArray = 0;

            while (currentPositionInOutputVehicleArray < outputVehicleArray.length) {

                for (Vehicle currentVehicle : arrayOfVehiclesTemp) {
                    if (findByFuelConsumption || findByFuelTankCapacity) {
                        matchConditionForBus = checkBusParameters(currentVehicle, findByFuelConsumption, minFuelConsumption, maxFuelConsumption, findByFuelTankCapacity,
                                minFuelTankCapacity, maxFuelTankCapacity);
                    }
                    if (findByPowerOfElectricMotor) {
                        matchConditionForTrolleybus = checkTrolleybusParameters(currentVehicle, minPowerOfElectricMotor, maxPowerOfElectricMotor);
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
                System.out.println("No vehicle with such parameters were found in " + getTransportParkName());
                return null;
            }
        }

        return null;
    }

    public static Vehicle[] findVehicleFromAllParks(boolean findByVehicleType, String vehicleType, boolean findByVehicleModel, String model,
                                                    boolean findByNumberOfVehicle, int numberOfVehicle, boolean findByVehiclePrice, double minVehiclePrice,
                                                    double maxVehiclePrice, boolean findByVehicleCapacity, int minCapacity, int maxCapacity,
                                                    boolean findByRouteServedName, String routeServedName) {

        return findVehicleFromAllParks(findByVehicleType, vehicleType, findByVehicleModel, model, findByNumberOfVehicle,
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
        String[] namesOfIgnoredParks = new String[0];
        int counterOfRowInArrayOfVehiclesTwoD = 0;
        int currentRowInArrayOfVehiclesTwoD = 0;
        int numberOfElementsInOutputArray = 0;
        int currentPositionInOutputArray = 0;

        for (TransportPark currentTransportPark : arrayOfTransportParks) {
            if (findByFuelConsumption || findByFuelTankCapacity || findByPowerOfElectricMotor) {
                arrayOfVehicleWithParameters = currentTransportPark.findVehiclesWithParameters(findByVehicleType, vehicleType, findByVehicleModel, model,
                        findByNumberOfVehicle, numberOfVehicle, findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity,
                        findByRouteServedName, routeServedName, findByFuelConsumption, minFuelConsumption, maxFuelConsumption, findByFuelTankCapacity, minFuelTankCapacity,
                        maxFuelTankCapacity, findByPowerOfElectricMotor, minPowerOfElectricMotor, maxPowerOfElectricMotor);
            } else {
                arrayOfVehicleWithParameters = currentTransportPark.findVehiclesWithParameters(findByVehicleType, vehicleType, findByVehicleModel, model,
                        findByNumberOfVehicle, numberOfVehicle, findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity,
                        findByRouteServedName, routeServedName);
            }
            if (arrayOfVehicleWithParameters != null) {
                counterOfRowInArrayOfVehiclesTwoD++;
            } else {
                namesOfIgnoredParks = currentTransportPark.addParkToIgnoredArray(namesOfIgnoredParks, currentTransportPark.getTransportParkName());
            }
        }

        if (counterOfRowInArrayOfVehiclesTwoD != 0) {

            Vehicle[][] arrayOfVehicleTempTwoD = new Vehicle[counterOfRowInArrayOfVehiclesTwoD][];

            for (TransportPark currentTransportPark : arrayOfTransportParks) {

                checkForIgnoredPark:
                {
                    for (String currentParkName : namesOfIgnoredParks) {
                        if (currentTransportPark.getTransportParkName().equals(currentParkName)) {
                            break checkForIgnoredPark;
                        }
                    }

                    if (findByFuelConsumption || findByFuelTankCapacity || findByPowerOfElectricMotor) {
                        arrayOfVehicleWithParameters = currentTransportPark.findVehiclesWithParameters(findByVehicleType, vehicleType, findByVehicleModel, model,
                                findByNumberOfVehicle, numberOfVehicle, findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity,
                                findByRouteServedName, routeServedName, findByFuelConsumption, minFuelConsumption, maxFuelConsumption, findByFuelTankCapacity,
                                minFuelTankCapacity, maxFuelTankCapacity, findByPowerOfElectricMotor, minPowerOfElectricMotor, maxPowerOfElectricMotor);
                    } else {
                        arrayOfVehicleWithParameters = currentTransportPark.findVehiclesWithParameters(findByVehicleType, vehicleType, findByVehicleModel, model,
                                findByNumberOfVehicle, numberOfVehicle, findByVehiclePrice, minVehiclePrice, maxVehiclePrice, findByVehicleCapacity, minCapacity, maxCapacity,
                                findByRouteServedName, routeServedName);
                    }
                    if (arrayOfVehicleWithParameters != null) {
                        arrayOfVehicleTempTwoD[currentRowInArrayOfVehiclesTwoD] = arrayOfVehicleWithParameters;
                        currentRowInArrayOfVehiclesTwoD++;
                    }

                }

            }

            for (Vehicle[] currentArrayOfVehicle : arrayOfVehicleTempTwoD) {
                numberOfElementsInOutputArray += currentArrayOfVehicle.length;
            }

            Vehicle[] outputVehicleArray = new Vehicle[numberOfElementsInOutputArray];

            for (Vehicle[] currentArrayOfVehicles : arrayOfVehicleTempTwoD) {
                for (Vehicle currentVehicle : currentArrayOfVehicles) {
                    outputVehicleArray[currentPositionInOutputArray] = currentVehicle;
                    currentPositionInOutputArray++;
                }
            }

            if (outputVehicleArray.length != 0) {
                return outputVehicleArray;
            } else {
                return null;
            }

        }

        return null;
    }

    private String[] addParkToIgnoredArray(String[] namesOfIgnoredParks, String parkName) {
        String[] namesOfIgnoredParksTemp;
        int positionInIgnoredParksTemp = namesOfIgnoredParks.length == 0 ? 0 : namesOfIgnoredParks.length;

        namesOfIgnoredParksTemp = new String[namesOfIgnoredParks.length + 1];
        System.arraycopy(namesOfIgnoredParks, 0, namesOfIgnoredParksTemp, 0, namesOfIgnoredParks.length);
        namesOfIgnoredParksTemp[positionInIgnoredParksTemp] = parkName;

        return namesOfIgnoredParksTemp;
    }

    private static boolean checkBusParameters(Vehicle currentVehicle, boolean findByFuelConsumption, double minFuelConsumption, double maxFuelConsumption,
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

    private static boolean checkTrolleybusParameters(Vehicle currentVehicle, double minPowerOfElectricMotor, double maxPowerOfElectricMotor) {

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
                ",\nCurrent car park: " + Arrays.toString(vehiclePark) +
                "}\n";
    }

    public static void printTransportParksList() {
        NumberFormat numberFormat = NumberFormat.getInstance();

        System.out.println("\nList of transport parks: {");

        for (TransportPark transportPark : arrayOfTransportParks) {
            System.out.println("Transport park name: " + transportPark.getTransportParkName() + ", total number of served routes: "
                    + transportPark.getNumberOfRoutesServed() + ", total number of vehicles: " + transportPark.getVehicleParkSize() +
                    ", cost of car park: " + numberFormat.format(transportPark.calculateCostOfCarPark()));
        }

        System.out.println("}\n");
    }

    public void printArrayOfTransferredVehicles() {
        if (arrayOfTransferredVehicles.length != 0) {

            for (Vehicle currentVehicle : arrayOfTransferredVehicles) {
                if (currentVehicle != null) {
                    System.out.print(transportParkName + ", details of transferred vehicle:");
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

    public double getCostOfVehiclePark() {
        return costOfVehiclePark;
    }

    public static int getNumberOfTransportParks() {
        return numberOfTransportParks;
    }

    public static int getNumberOfTransferredVehicles() {
        return numberOfTransferredVehicles;
    }

}
