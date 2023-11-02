package checked.lesson7_8.task1;

public class Vacuum {
    private int numberOfAppliances;
    private Appliance[] arrayOfAppliances = new Appliance[numberOfAppliances];

    public void addAppliance(Appliance appliance) {
        numberOfAppliances++;

        Appliance[] updatedArrayOfAppliances = new Appliance[numberOfAppliances];

        int currentIndexInAppliancesArray = arrayOfAppliances.length == 0 ? 0 : updatedArrayOfAppliances.length - 1;
        System.arraycopy(arrayOfAppliances, 0, updatedArrayOfAppliances, 0, arrayOfAppliances.length);

        updatedArrayOfAppliances[currentIndexInAppliancesArray] = appliance;
        arrayOfAppliances = updatedArrayOfAppliances;

    }

    public void sortArrayOfAppliances(boolean sortByAmperage, boolean sortByPower, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int indexOfPivotElement;

        if (sortByAmperage && !sortByPower) {
            indexOfPivotElement = getPIndexForAmperage(leftIndex, rightIndex);
        } else if (sortByPower && !sortByAmperage) {
            indexOfPivotElement = getPIndexForForPower(leftIndex, rightIndex);
        } else {
            System.out.println("You can only sort by one parameter!");
            return;
        }

        if (sortByAmperage) {
            sortArrayOfAppliances(true, false, leftIndex, indexOfPivotElement - 1);
            sortArrayOfAppliances(true, false, indexOfPivotElement + 1, rightIndex);
        } else {
            sortArrayOfAppliances(false, true, leftIndex, indexOfPivotElement - 1);
            sortArrayOfAppliances(false, true, indexOfPivotElement + 1, rightIndex);
        }
    }

    private int getPIndexForAmperage(int leftIndex, int rightIndex) {
        double pivotElement = arrayOfAppliances[rightIndex].getAmperage();
        int currentIndexOfElementToReplace = leftIndex;

        for (int i = leftIndex; i < rightIndex; i++) {
            if (arrayOfAppliances[i].getAmperage() <= pivotElement) {
                swap(i, currentIndexOfElementToReplace);
                currentIndexOfElementToReplace++;
            }
        }
        swap(rightIndex, currentIndexOfElementToReplace);
        return currentIndexOfElementToReplace;
    }

    private int getPIndexForForPower(int leftIndex, int rightIndex) {
        double pivotElement = arrayOfAppliances[rightIndex].getPower();
        int currentIndexOfElementToReplace = leftIndex;

        for (int i = leftIndex; i < rightIndex; i++) {
            if (arrayOfAppliances[i].getPower() <= pivotElement) {
                swap(i, currentIndexOfElementToReplace);
                currentIndexOfElementToReplace++;
            }
        }
        swap(rightIndex, currentIndexOfElementToReplace);
        return currentIndexOfElementToReplace;
    }

    private void swap(int firstIndexOfElementToReplace, int secondIndexOfElementToReplace) {
        Appliance temp = arrayOfAppliances[firstIndexOfElementToReplace];
        arrayOfAppliances[firstIndexOfElementToReplace] = arrayOfAppliances[secondIndexOfElementToReplace];
        arrayOfAppliances[secondIndexOfElementToReplace] = temp;
    }

    public Appliance findApplianceWithSetOfParameters(boolean findByLocation, String location, boolean findByType, String type, boolean findByBrand,
                                                      String brand, boolean findByAmperage, double minAmperage, double maxAmperage, boolean findByPower,
                                                      double minPower, double maxPower, boolean findByState, boolean isOn) {
        Appliance[] applianceTempArray = findAppliancesWithSetOfParameters(findByLocation, location, findByType, type, findByBrand, brand, findByAmperage,
                minAmperage, maxAmperage, findByPower, minPower, maxPower, findByState, isOn);
        if (applianceTempArray != null && applianceTempArray.length == 1) {
            return applianceTempArray[0];
        } else if (applianceTempArray != null && applianceTempArray.length > 1) {
            System.out.println("More than one item found! Use search for arrays!");
            return null;
        } else {
            return null;
        }
    }

    public Appliance[] findAppliancesWithSetOfParameters(boolean findByLocation, String location, boolean findByType, String type, boolean findByBrand,
                                                         String brand, boolean findByAmperage, double minAmperage, double maxAmperage, boolean findByPower,
                                                         double minPower, double maxPower, boolean findByState, boolean isOn) {
        int counterOfSuitableAppliances = 0;

        for (Appliance currentAppliance : arrayOfAppliances) {
            boolean matchCondition = checkSearchTerms(currentAppliance, findByLocation, location, findByType, type, findByBrand, brand, findByAmperage, minAmperage, maxAmperage,
                    findByPower, minPower, maxPower, findByState, isOn);
            if (matchCondition) {
                counterOfSuitableAppliances++;
            }
        }

        Appliance[] outputArrayOfAppliances = new Appliance[counterOfSuitableAppliances];
        int currentPositionInOutputArray = 0;

        while (currentPositionInOutputArray < outputArrayOfAppliances.length) {
            for (Appliance currentAppliance : arrayOfAppliances) {
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

    private boolean checkSearchTerms(Appliance appliance, boolean findByLocation, String location, boolean findByType, String type, boolean findByBrand,
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

    public void printNumberOfAppliances() {
        System.out.println("The total number of appliances in the vacuum: " + numberOfAppliances);
    }

    public void printArrayOfAppliances() {
        if (arrayOfAppliances != null) {
            System.out.println("Vacuum: {");
            for (Appliance appliance : arrayOfAppliances) {
                System.out.println(appliance.toString());
            }
            System.out.println("};\n");
        } else {
            System.out.println("There is no appliances in the vacuum!");
        }
    }
    public int getNumberOfAppliances() {
        return numberOfAppliances;
    }
}
