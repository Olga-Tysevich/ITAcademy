package inProgress.lesson7.task1;


public abstract class Appliances {
    private static int numberOfAppliances;
    private static Appliances[] appliancesArray = new Appliances[numberOfAppliances];
    private String location;
    private final String type;
    private final String brand;
    private final double amperage;
    private boolean isOn = false;
    private final boolean hasEngine;
    private double power = 0;

    public Appliances(String location, String type, String brand, double amperage, boolean hasEngine) {
        this.location = location;
        this.type = type;
        this.brand = brand;
        this.amperage = amperage;
        this.hasEngine = hasEngine;
        getAppliancesArray(this);
    }

    public Appliances(String location, String type, String brand, double amperage, boolean hasEngine, boolean isOn) {
        this(location, type, brand, amperage, hasEngine);
        this.isOn = isOn;
        if (isOn) {
            calculatePower();
        }
    }

    private static void getAppliancesArray(Appliances appliance) {
        numberOfAppliances++;
        Appliances[] appliancesArrayNew = new Appliances[numberOfAppliances];
        int currentIndexInAppliancesArray = 0;

        if (numberOfAppliances - 1 != 0) {
            while (currentIndexInAppliancesArray < appliancesArray.length) {
                appliancesArrayNew[currentIndexInAppliancesArray] = appliancesArray[currentIndexInAppliancesArray];
                currentIndexInAppliancesArray++;
            }
        }

        appliancesArrayNew[currentIndexInAppliancesArray] = appliance;
        appliancesArray = appliancesArrayNew;

    }

    public void calculatePower() {
        //P = I * U / PowerFactor (При отсутствии данных допустимо принять cos(φ) в пределах 0,7-0,8);
        //Холодильники, стиральные машины, дрели и прочее оборудование с электродвигателями;
        int MAINS_VOLTAGE = 220;
        if (hasEngine && isOn) {
            double POWER_FACTOR = 0.7;
            power = amperage * MAINS_VOLTAGE / POWER_FACTOR;
        } else if (isOn) {
            power = amperage * MAINS_VOLTAGE;
        } else {
            power = 0;
        }
    }

    public static void sortAppliancesArray(boolean sortByAmperage, boolean sortByPower, Appliances[] appliancesArray, int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            return;
        }

        int rotation;

        if (sortByAmperage && !sortByPower) {
            rotation = getRIndexForAmperage(appliancesArray, lowerBound, upperBound);
        } else if (sortByPower && !sortByAmperage) {
            rotation = getRIndexForPower(appliancesArray, lowerBound, upperBound);
        } else {
            System.out.println("You can only sort by one parameter!");
            return;
        }

        if (sortByAmperage) {
            sortAppliancesArray(true, false, appliancesArray, lowerBound, rotation - 1);
            sortAppliancesArray(true, false, appliancesArray, rotation + 1, upperBound);
        } else {
            sortAppliancesArray(false, true, appliancesArray, lowerBound, rotation - 1);
            sortAppliancesArray(false, true, appliancesArray, rotation + 1, upperBound);
        }
    }

    private static int getRIndexForAmperage(Appliances[] appliancesArray, int lowerBound, int upperBound) {
        double rotation = appliancesArray[upperBound].getAmperage();
        int rIndex = lowerBound;
        for (int i = lowerBound; i < upperBound; i++) {
            if (appliancesArray[i].getAmperage() <= rotation) {
                swap(appliancesArray, i, rIndex);
                rIndex++;
            }
        }
        swap(appliancesArray, upperBound, rIndex);
        return rIndex;
    }

    private static int getRIndexForPower(Appliances[] appliancesArray, int lowerBound, int upperBound) {
        double rotation = appliancesArray[upperBound].getPower();
        int rIndex = lowerBound;
        for (int i = lowerBound; i < upperBound; i++) {
            if (appliancesArray[i].getPower() <= rotation) {
                swap(appliancesArray, i, rIndex);
                rIndex++;
            }
        }
        swap(appliancesArray, upperBound, rIndex);
        return rIndex;
    }

    private static void swap(Appliances[] appliancesArray, int i, int rIndex) {
        Appliances temp = appliancesArray[i];
        appliancesArray[i] = appliancesArray[rIndex];
        appliancesArray[rIndex] = temp;
    }

    public static Appliances[] findAppliancesWithSetOfParameters(boolean findByLocation, String location, boolean findByType, String type, boolean findByBrand,
                                                                 String brand, boolean findByAmperage, double minAmperage, double maxAmperage, boolean findByPower,
                                                                 double minPower, double maxPower, boolean findByState, boolean isOn) {
        int counterOfAppliances = 0;
        boolean conditionsMatch;

        for (Appliances appliance : appliancesArray) {
            conditionsMatch = checkSearchTerms(appliance, findByLocation, location, findByType, type, findByBrand, brand, findByAmperage, minAmperage, maxAmperage,
                    findByPower, minPower, maxPower, findByState, isOn);
            if (conditionsMatch) {
                counterOfAppliances++;
            }
        }

        Appliances[] outputAppliancesArray = new Appliances[counterOfAppliances];
        counterOfAppliances = 0;

        while (counterOfAppliances < outputAppliancesArray.length) {

            for (Appliances outputAppliance : appliancesArray) {
                conditionsMatch = checkSearchTerms(outputAppliance, findByLocation, location, findByType, type, findByBrand, brand, findByAmperage, minAmperage, maxAmperage,
                        findByPower, minPower, maxPower, findByState, isOn);
                if (conditionsMatch) {
                    outputAppliancesArray[counterOfAppliances] = outputAppliance;
                    counterOfAppliances++;
                }
            }
        }

        if (outputAppliancesArray.length != 0) {
            return outputAppliancesArray;
        } else {
            return null;
        }
    }

    private static boolean checkSearchTerms(Appliances appliance, boolean findByLocation, String location, boolean findByType, String type, boolean findByBrand,
                                            String brand, boolean findByAmperage, double minAmperage, double maxAmperage, boolean findByPower,
                                            double minPower, double maxPower, boolean findByState, boolean isOn) {
        boolean isMatchConditionTrue;
        boolean isLocationMatch;
        boolean isTypeMatch;
        boolean isBrandMatch;
        boolean isAmperageMatch;
        boolean isPowerMatch;
        boolean isStateMatch;
        if (findByLocation) {
            isLocationMatch = appliance.getLocation().equals(location);
        } else {
            isLocationMatch = true;
        }
        if (findByType) {
            isTypeMatch = appliance.getType().equals(type);
        } else {
            isTypeMatch = true;
        }
        if (findByBrand) {
            isBrandMatch = appliance.getBrand().equals(brand);
        } else {
            isBrandMatch = true;
        }
        if (findByAmperage) {
            isAmperageMatch = appliance.getAmperage() >= minAmperage && appliance.getAmperage() <= maxAmperage;
        } else {
            isAmperageMatch = true;
        }
        if (findByPower) {
            isPowerMatch = appliance.getPower() >= minPower && appliance.getPower() <= maxPower;
        } else {
            isPowerMatch = true;
        }
        if (findByState) {
            isStateMatch = appliance.getState() == isOn;
        } else {
            isStateMatch = true;
        }
        return isMatchConditionTrue = isLocationMatch && isTypeMatch && isBrandMatch && isAmperageMatch && isPowerMatch && isStateMatch;
    }

    public static void printNumberOfAppliances() {
        System.out.println("The total number of appliances in the house: " + numberOfAppliances);
    }

    public static void printArray(Appliances[] appliances) {
        if (appliances != null) {
            for (Appliances appliance : appliances) {
                System.out.println("| Location " + appliance.getLocation() + " Type " + appliance.getType() + " model " + appliance.getBrand()
                        + " amperage " + appliance.getAmperage() + " is on " + appliance.getState() + " power " + String.format("%.2f", appliance.getPower()) + " |");
            }
        } else {
            System.out.println("Appliances not found");
        }
    }

    public void printDescription() {
        System.out.println("Location: " + location);
        System.out.println("Type: " + type);
        System.out.println("Brand: " + brand);
        System.out.println("Amperage: " + amperage);
        System.out.println("State: " + isOn);
        System.out.println("Power: " + String.format("%.2f", power));
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public double getAmperage() {
        return amperage;
    }

    public boolean isOn() {
        return isOn;
    }

    public double getPower() {
        return power;
    }

    public boolean getState() {
        return isOn;
    }

    public static int getNumberOfAppliances() {
        return numberOfAppliances;
    }

    public static Appliances[] getAppliancesArray() {
        return appliancesArray;
    }

    public void changeState(boolean isOn) {
        this.isOn = isOn;
        if (isOn) {
            calculatePower();
        }
    }

    public void changeLocation(String location) {
        this.location = location;
    }

}
