package inProgress.lesson7.task1;

import inProgress.lesson7.task1.bathroomappliances.WashingMachine;
import inProgress.lesson7.task1.bathroomappliances.WaterBoiler;
import inProgress.lesson7.task1.kitchenappliances.Fridge;
import inProgress.lesson7.task1.kitchenappliances.Kettle;
import inProgress.lesson7.task1.kitchenappliances.Microwave;
import inProgress.lesson7.task1.otherappliances.TV;

import static inProgress.lesson7.task1.Appliances.*;

public class AppliancesDemo {
    public static void main(String[] args) {
        Fridge fridgeSamsung = new Fridge("Samsung", 1.3, false, "left");
        fridgeSamsung.changeDoorOpeningDirection();
        fridgeSamsung.printDescription();
        System.out.println();

        Microwave microwaveSamsung = new Microwave("Samsung", 3, 6, 250, false);

        microwaveSamsung.putPlate(300);
        microwaveSamsung.putPlate(230);
        microwaveSamsung.heatUp(8);
        microwaveSamsung.heatUp(6);
        microwaveSamsung.printDescription();
        System.out.println();

        Kettle kettleLornay = new Kettle("L'ORNAY", 4.5, 1800, false);

        kettleLornay.printDescription();
        kettleLornay.pourTheWater(1900);
        kettleLornay.pourTheWater(1500);
        kettleLornay.boilWater();
        System.out.println();

        kettleLornay.printDescription();
        System.out.println();

        WaterBoiler boilerElectrolux = new WaterBoiler("Electrolux", 8.2, 3, false);

        boilerElectrolux.changeState(true);
        boilerElectrolux.boilWater(2);
        boilerElectrolux.printDescription();
        System.out.println();

        WashingMachine washingMachine = new WashingMachine("LG", 5.6, 6.5);

        washingMachine.changeState(false);
        washingMachine.printDescription();
        washingMachine.loadLinen(5);
        washingMachine.washLinen();
        System.out.println();

        TV tv = new TV("Living room", "Samsung", 1.2, 10);

        tv.printDescription();
        tv.changeNumberOfChannels(8);
        tv.enableChannel(2);
        System.out.println();

        printNumberOfAppliances();
        System.out.println();

        printAppliancesArray(getAppliancesArray());
        System.out.println();

        Appliances[] appliancesByParametersSet = findAppliancesByLocation("Kitchen", getAppliancesArray());
        appliancesByParametersSet = findAppliancesByAmperage(3, 5, appliancesByParametersSet);
        printAppliancesArray(appliancesByParametersSet);
        System.out.println();

        Appliances[] appliancesByParametersSetTwo = findAppliancesByType("Fridge", getAppliancesArray());
        printAppliancesArray(appliancesByParametersSetTwo);
        System.out.println();
        Appliances[] appliancesByParametersSetThree = findAppliancesByBrand("LG", getAppliancesArray());
        printAppliancesArray(appliancesByParametersSetThree);
        System.out.println();
        Appliances[] appliancesByParametersSetFour = findAppliancesByAmperage(2, 4.5, getAppliancesArray());
        printAppliancesArray(appliancesByParametersSetFour);
        System.out.println();
        Appliances[] appliancesByParametersSetFive = findAppliancesByPower(1000, 2500, getAppliancesArray());
        printAppliancesArray(appliancesByParametersSetFive);
        System.out.println();
        Appliances[] appliancesByParametersSetSix = findAppliancesByState(true, getAppliancesArray());
        printAppliancesArray(appliancesByParametersSetSix);
        System.out.println();


        sortAppliancesArray(true, false, getAppliancesArray(), 0, getAppliancesArray().length - 1);
        printAppliancesArray(getAppliancesArray());
        System.out.println();

        sortAppliancesArray(false, true, getAppliancesArray(), 0, getAppliancesArray().length - 1);
        printAppliancesArray(getAppliancesArray());

    }

}
