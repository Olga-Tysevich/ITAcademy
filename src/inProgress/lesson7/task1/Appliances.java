package inProgress.lesson7.task1;


public abstract class Appliances {
    private static int numberOfAppliances;
    private static Appliances[] arrayOfAppliances = new Appliances[numberOfAppliances];
    private String location;
    private final String type;
    private final String brand;
    private final double amperage;
    private boolean isOn = false;
    private final boolean hasElectricMotor;
    private double power = 0;

    public Appliances(String location, String type, String brand, double amperage, boolean hasElectricMotor) {
        this.location = location;
        this.type = type;
        this.brand = brand;
        this.amperage = amperage;
        this.hasElectricMotor = hasElectricMotor;
        addApplianceToArrayOfAppliances(this);
    }

    public Appliances(String location, String type, String brand, double amperage, boolean hasElectricMotor, boolean isOn) {
        this(location, type, brand, amperage, hasElectricMotor);
        this.isOn = isOn;
        if (isOn) {
            calculatePower();
        }
    }

    private static void addApplianceToArrayOfAppliances(Appliances appliance) {
        numberOfAppliances++;

        Appliances[] updatedArrayOfAppliances = new Appliances[numberOfAppliances];

        int currentIndexInAppliancesArray = 0;

        if (numberOfAppliances - 1 != 0) {
            while (currentIndexInAppliancesArray < arrayOfAppliances.length) {
                updatedArrayOfAppliances[currentIndexInAppliancesArray] = arrayOfAppliances[currentIndexInAppliancesArray];
                currentIndexInAppliancesArray++;
            }
        }

        updatedArrayOfAppliances[currentIndexInAppliancesArray] = appliance;
        arrayOfAppliances = updatedArrayOfAppliances;

    }

    public void calculatePower() {
        //P = I * U / PowerFactor (При отсутствии данных допустимо принять cos(φ) в пределах 0,7-0,8);
        //Холодильники, стиральные машины, дрели и прочее оборудование с электродвигателями;
        int MAINS_VOLTAGE = 220;
        if (hasElectricMotor && isOn) {
            double POWER_FACTOR = 0.7;
            power = amperage * MAINS_VOLTAGE / POWER_FACTOR;
        } else if (isOn) {
            power = amperage * MAINS_VOLTAGE;
        } else {
            power = 0;
        }
    }

    public static void sortArrayOfAppliances(boolean sortByAmperage, boolean sortByPower, Appliances[] arrayOfAppliances, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int indexOfPivotElement;

        if (sortByAmperage && !sortByPower) {
            indexOfPivotElement = getPIndexForAmperage(arrayOfAppliances, leftIndex, rightIndex);
        } else if (sortByPower && !sortByAmperage) {
            indexOfPivotElement = getPIndexForForPower(arrayOfAppliances, leftIndex, rightIndex);
        } else {
            System.out.println("You can only sort by one parameter!");
            return;
        }

        if (sortByAmperage) {
            sortArrayOfAppliances(true, false, arrayOfAppliances, leftIndex, indexOfPivotElement - 1);
            sortArrayOfAppliances(true, false, arrayOfAppliances, indexOfPivotElement + 1, rightIndex);
        } else {
            sortArrayOfAppliances(false, true, arrayOfAppliances, leftIndex, indexOfPivotElement - 1);
            sortArrayOfAppliances(false, true, arrayOfAppliances, indexOfPivotElement + 1, rightIndex);
        }
    }

    private static int getPIndexForAmperage(Appliances[] arrayOfAppliances, int leftIndex, int rightIndex) {
        double pivotElement = arrayOfAppliances[rightIndex].getAmperage();
        int currentIndexOfElementToReplace = leftIndex;

        for (int i = leftIndex; i < rightIndex; i++) {
            if (arrayOfAppliances[i].getAmperage() <= pivotElement) {
                swap(arrayOfAppliances, i, currentIndexOfElementToReplace);
                currentIndexOfElementToReplace++;
            }
        }
        swap(arrayOfAppliances, rightIndex, currentIndexOfElementToReplace);
        return currentIndexOfElementToReplace;
    }

    private static int getPIndexForForPower(Appliances[] arrayOfAppliances, int lowerBound, int upperBound) {
        double pivotElement = arrayOfAppliances[upperBound].getPower();
        int currentIndexOfElementToReplace = lowerBound;

        for (int i = lowerBound; i < upperBound; i++) {
            if (arrayOfAppliances[i].getPower() <= pivotElement) {
                swap(arrayOfAppliances, i, currentIndexOfElementToReplace);
                currentIndexOfElementToReplace++;
            }
        }
        swap(arrayOfAppliances, upperBound, currentIndexOfElementToReplace);
        return currentIndexOfElementToReplace;
    }

    private static void swap(Appliances[] arrayOfAppliances, int firstIndexOfElementToReplace, int secondIndexOfElementToReplace) {
        Appliances temp = arrayOfAppliances[firstIndexOfElementToReplace];
        arrayOfAppliances[firstIndexOfElementToReplace] = arrayOfAppliances[secondIndexOfElementToReplace];
        arrayOfAppliances[secondIndexOfElementToReplace] = temp;
    }

    public static Appliances findApplianceWithSetOfParameters(boolean findByLocation, String location, boolean findByType, String type, boolean findByBrand,
                                                              String brand, boolean findByAmperage, double minAmperage, double maxAmperage, boolean findByPower,
                                                              double minPower, double maxPower, boolean findByState, boolean isOn) {
        Appliances[] appliancesTempArray = findAppliancesWithSetOfParameters(findByLocation, location, findByType, type, findByBrand, brand, findByAmperage,
                minAmperage, maxAmperage, findByPower, minPower, maxPower, findByState, isOn);
        if (appliancesTempArray != null && appliancesTempArray.length == 1) {
            return appliancesTempArray[0];
        } else if (appliancesTempArray != null && appliancesTempArray.length > 1) {
            System.out.println("More than one item found! Use the search for arrays!");
            return null;
        } else {
            return null;
        }
    }

    public static Appliances[] findAppliancesWithSetOfParameters(boolean findByLocation, String location, boolean findByType, String type, boolean findByBrand,
                                                                 String brand, boolean findByAmperage, double minAmperage, double maxAmperage, boolean findByPower,
                                                                 double minPower, double maxPower, boolean findByState, boolean isOn) {
        int counterOfSuitableAppliances = 0;

        for (Appliances currentAppliance : arrayOfAppliances) {
            boolean matchCondition = checkSearchTerms(currentAppliance, findByLocation, location, findByType, type, findByBrand, brand, findByAmperage, minAmperage, maxAmperage,
                    findByPower, minPower, maxPower, findByState, isOn);
            if (matchCondition) {
                counterOfSuitableAppliances++;
            }
        }

        Appliances[] outputArrayOfAppliances = new Appliances[counterOfSuitableAppliances];
        int currentPositionInOutputArray = 0;

        while (currentPositionInOutputArray < outputArrayOfAppliances.length) {

            for (Appliances currentAppliance : arrayOfAppliances) {
                boolean matchCondition = checkSearchTerms(currentAppliance, findByLocation, location, findByType, type, findByBrand, brand, findByAmperage, minAmperage,
                        maxAmperage, findByPower, minPower, maxPower, findByState, isOn);
                if (matchCondition) {
                    outputArrayOfAppliances[currentPositionInOutputArray] = currentAppliance;
                    currentPositionInOutputArray++;
                }
            }
        }

        if (outputArrayOfAppliances.length != 0) {
            return outputArrayOfAppliances;
        } else {
            System.out.println("No appliances with such parameters were found!");
            return null;
        }
    }

    private static boolean checkSearchTerms(Appliances appliance, boolean findByLocation, String location, boolean findByType, String type, boolean findByBrand,
                                            String brand, boolean findByAmperage, double minAmperage, double maxAmperage, boolean findByPower,
                                            double minPower, double maxPower, boolean findByState, boolean isOn) {
        boolean matchesLocation;
        boolean matchesType;
        boolean matchesBrand;
        boolean matchesAmperage;
        boolean matchesPower;
        boolean matchesState;

        if (findByLocation) {
            matchesLocation = appliance.getLocation().equals(location);
        } else {
            matchesLocation = true;
        }
        if (findByType) {
            matchesType = appliance.getType().equals(type);
        } else {
            matchesType = true;
        }
        if (findByBrand) {
            matchesBrand = appliance.getBrand().equals(brand);
        } else {
            matchesBrand = true;
        }
        if (findByAmperage) {
            matchesAmperage = appliance.getAmperage() >= minAmperage && appliance.getAmperage() <= maxAmperage;
        } else {
            matchesAmperage = true;
        }
        if (findByPower) {
            matchesPower = appliance.getPower() >= minPower && appliance.getPower() <= maxPower;
        } else {
            matchesPower = true;
        }
        if (findByState) {
            matchesState = appliance.getState() == isOn;
        } else {
            matchesState = true;
        }
        return matchesLocation && matchesType && matchesBrand && matchesAmperage && matchesPower && matchesState;
    }

    public static void printNumberOfAppliances() {
        System.out.println("The total number of appliances in the house: " + numberOfAppliances);
    }

    @Override
    public String toString() {
        return "{" +
                "location: " + location +
                ", type: " + type +
                ", brand: " + brand +
                ", amperage: " + amperage +
                ", power: " + String.format("%.2f", power);
    }

    public static void printArrayOfAppliances(Appliances[] arrayOfAppliances) {
        if (arrayOfAppliances != null) {
            System.out.println("Array of Appliances: {");
            for (Appliances appliance : arrayOfAppliances) {
                System.out.println(appliance.toString());
            }
            System.out.println("};\n");
        } else {
            System.out.println("Array of Appliances is null!");
        }
    }

    public void changeState() {
        this.isOn = !this.isOn;
        if (isOn) {
            calculatePower();
        }
    }

    public void changeLocation(String location) {
        this.location = location;
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

    public static Appliances[] getArrayOfAppliances() {
        return arrayOfAppliances;
    }

}
