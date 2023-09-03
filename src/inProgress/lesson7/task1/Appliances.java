package inProgress.lesson7.task1;


public abstract class Appliances {
    private static int numberOfAppliances;
    private static Appliances[] appliancesArray = new Appliances[numberOfAppliances];
    private String location;
    private final String type;
    private final String brand;
    private final double amperage;
    private boolean isOff = true;
    private final boolean hasEngine;
    private double power = 0;

    public Appliances(String type, String brand, double amperage, boolean hasEngine) {
        this.type = type;
        this.brand = brand;
        this.amperage = amperage;
        this.hasEngine = hasEngine;
        numberOfAppliances++;
        appliancesArray = getAppliancesArray(this);
        if (!isOff) {
            calculatePower();
        }
    }

    public Appliances(String type, String brand, double amperage, boolean hasEngine, boolean isOff) {
        this(type, brand, amperage, hasEngine);
        this.isOff = isOff;
    }


    private static Appliances[] getAppliancesArray(Appliances appliance) {
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

        return appliancesArrayNew;
    }

    public void calculatePower() {
        //P = I * U / PowerFactor (При отсутствии данных допустимо принять cos(φ) в пределах 0,7-0,8);
        //Холодильники, стиральные машины, дрели и прочее оборудование с электродвигателями;
        int MAINS_VOLTAGE = 220;
        if (hasEngine && !isOff) {
            double POWER_FACTOR = 0.7;
            power = amperage * MAINS_VOLTAGE / POWER_FACTOR;
        } else if (!isOff) {
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

    public static Appliances[] findAppliancesByLocation(String location, Appliances[] appliancesArray) {
        int counterOfAppliances = 0;
        for (Appliances appliance : appliancesArray) {
            boolean isMatchConditionTrue = appliance.getLocation().equals(location);
            if (isMatchConditionTrue) {
                counterOfAppliances++;
            }
        }

        Appliances[] outputAppliancesArray = new Appliances[counterOfAppliances];
        counterOfAppliances = 0;

        while (counterOfAppliances < outputAppliancesArray.length) {

            for (Appliances outputAppliance : appliancesArray) {
                boolean isMatchConditionTrue = outputAppliance.getLocation().equals(location);
                if (isMatchConditionTrue) {
                    outputAppliancesArray[counterOfAppliances] = outputAppliance;
                    counterOfAppliances++;
                }
            }
        }

        return outputAppliancesArray;
    }

    public static Appliances[] findAppliancesByType(String type, Appliances[] appliancesArray) {
        int counterOfAppliances = 0;
        for (Appliances appliance : appliancesArray) {
            boolean isMatchConditionTrue = appliance.getType().equals(type);
            if (isMatchConditionTrue) {
                counterOfAppliances++;
            }
        }

        Appliances[] outputAppliancesArray = new Appliances[counterOfAppliances];
        counterOfAppliances = 0;

        while (counterOfAppliances < outputAppliancesArray.length) {

            for (Appliances outputAppliance : appliancesArray) {
                boolean isMatchConditionTrue = outputAppliance.getType().equals(type);
                if (isMatchConditionTrue) {
                    outputAppliancesArray[counterOfAppliances] = outputAppliance;
                    counterOfAppliances++;
                }
            }
        }

        return outputAppliancesArray;
    }

    public static Appliances[] findAppliancesByBrand(String brand, Appliances[] appliancesArray) {
        int counterOfAppliances = 0;
        for (Appliances appliance : appliancesArray) {
            boolean isMatchConditionTrue = appliance.getBrand().equals(brand);
            if (isMatchConditionTrue) {
                counterOfAppliances++;
            }
        }

        Appliances[] outputAppliancesArray = new Appliances[counterOfAppliances];
        counterOfAppliances = 0;

        while (counterOfAppliances < outputAppliancesArray.length) {

            for (Appliances outputAppliance : appliancesArray) {
                boolean isMatchConditionTrue = outputAppliance.getBrand().equals(brand);
                if (isMatchConditionTrue) {
                    outputAppliancesArray[counterOfAppliances] = outputAppliance;
                    counterOfAppliances++;
                }
            }
        }

        return outputAppliancesArray;
    }

    public static Appliances[] findAppliancesByAmperage(double minAmperage, double maxAmperage, Appliances[] appliancesArray) {
        int counterOfAppliances = 0;
        for (Appliances appliance : appliancesArray) {
            boolean isMatchConditionTrue = appliance.getAmperage() >= minAmperage && appliance.getAmperage() <= maxAmperage;
            if (isMatchConditionTrue) {
                counterOfAppliances++;
            }
        }

        Appliances[] outputAppliancesArray = new Appliances[counterOfAppliances];
        counterOfAppliances = 0;

        while (counterOfAppliances < outputAppliancesArray.length) {

            for (Appliances outputAppliance : appliancesArray) {
                boolean isMatchConditionTrue = outputAppliance.getAmperage() >= minAmperage && outputAppliance.getAmperage() <= maxAmperage;
                if (isMatchConditionTrue) {
                    outputAppliancesArray[counterOfAppliances] = outputAppliance;
                    counterOfAppliances++;
                }
            }
        }

        return outputAppliancesArray;
    }

    public static Appliances[] findAppliancesByPower(double minPower, double maxPower, Appliances[] appliancesArray) {
        int counterOfAppliances = 0;
        for (Appliances appliance : appliancesArray) {
            boolean isMatchConditionTrue = appliance.getPower() >= minPower && appliance.getPower() <= maxPower;
            if (isMatchConditionTrue) {
                counterOfAppliances++;
            }
        }

        Appliances[] outputAppliancesArray = new Appliances[counterOfAppliances];
        counterOfAppliances = 0;

        while (counterOfAppliances < outputAppliancesArray.length) {

            for (Appliances outputAppliance : appliancesArray) {
                boolean isMatchConditionTrue = outputAppliance.getPower() >= minPower && outputAppliance.getPower() <= maxPower;
                if (isMatchConditionTrue) {
                    outputAppliancesArray[counterOfAppliances] = outputAppliance;
                    counterOfAppliances++;
                }
            }
        }

        return outputAppliancesArray;
    }

    public static Appliances[] findAppliancesByState(boolean isOff, Appliances[] appliancesArray) {
        int counterOfAppliances = 0;
        for (Appliances appliance : appliancesArray) {
            boolean isMatchConditionTrue = appliance.getState() == isOff;
            if (isMatchConditionTrue) {
                counterOfAppliances++;
            }
        }

        Appliances[] outputAppliancesArray = new Appliances[counterOfAppliances];
        counterOfAppliances = 0;

        while (counterOfAppliances < outputAppliancesArray.length) {

            for (Appliances outputAppliance : appliancesArray) {
                boolean isMatchConditionTrue = outputAppliance.getState() == isOff;
                if (isMatchConditionTrue) {
                    outputAppliancesArray[counterOfAppliances] = outputAppliance;
                    counterOfAppliances++;
                }
            }
        }

        return outputAppliancesArray;
    }

    public static void printNumberOfAppliances() {
        System.out.println("The total number of appliances in the house: " + numberOfAppliances);
    }

    public static void printAppliancesArray(Appliances[] appliances) {
        for (Appliances appliance : appliances) {
            System.out.println("| Location " + appliance.getLocation() + " Type " + appliance.getType() + " model " + appliance.getBrand()
                    + " amperage " + appliance.getAmperage() + " state " + appliance.getState() + " power " + String.format("%.2f", appliance.getPower()) + " |");
        }
        if (appliances.length == 0) {
            System.out.println("Appliances not found");
        }
    }

    public void printDescription() {
        System.out.println("Location: " + location);
        System.out.println("Type: " + type);
        System.out.println("Brand: " + brand);
        System.out.println("Amperage: " + amperage);
        System.out.println("State: " + isOff);
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

    public boolean isOff() {
        return isOff;
    }

    public double getPower() {
        return power;
    }

    public boolean getState() {
        return isOff;
    }

    public static int getNumberOfAppliances() {
        return numberOfAppliances;
    }

    public static Appliances[] getAppliancesArray() {
        return appliancesArray;
    }

    public void changeState(boolean isOff) {
        this.isOff = isOff;
    }

    public void changeLocation(String location) {
        this.location = location;
    }

}
