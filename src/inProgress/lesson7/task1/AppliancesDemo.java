package inProgress.lesson7.task1;

import inProgress.lesson7.task1.bathroomappliances.WashingMachine;
import inProgress.lesson7.task1.bathroomappliances.WaterBoiler;
import inProgress.lesson7.task1.kitchenappliances.Fridge;
import inProgress.lesson7.task1.kitchenappliances.Kettle;
import inProgress.lesson7.task1.kitchenappliances.Microwave;
import inProgress.lesson7.task1.otherappliances.TV;
import inProgress.lesson7.task1.otherappliances.VacuumCleaner;

import static inProgress.lesson7.task1.Appliances.*;

public class AppliancesDemo {
    public static void main(String[] args) {
        Fridge fridgeSamsung = new Fridge("Samsung", 1.3, "left");
        Fridge fridgeLG = new Fridge("LG", 1.5, "right");

        fridgeSamsung.changeDoorOpeningDirection();
        fridgeSamsung.printDescription();
        System.out.println();
        fridgeSamsung.changeState(true);
        fridgeLG.changeDoorOpeningDirection();

        Microwave microwaveSamsung = new Microwave("Samsung", 3, 6, 250, false);

        microwaveSamsung.putPlate(300);
        microwaveSamsung.putPlate(230);
        microwaveSamsung.heatUp(8);
        microwaveSamsung.heatUp(6);
        microwaveSamsung.printDescription();
        System.out.println();

        Kettle kettleLornay = new Kettle("L'ORNAY", 4.5, 1800, false);
        Kettle kettleScarlett = new Kettle("Scarlett", 3.5, 1200, true);

        kettleLornay.changeState(true);
        kettleLornay.printDescription();
        kettleLornay.pourTheWater(1900);
        kettleLornay.pourTheWater(1500);
        kettleLornay.boilWater();

        System.out.println("Scarlet water volume: " + kettleScarlett.getWaterVolume());
        System.out.println();

        kettleLornay.printDescription();
        System.out.println();

        WaterBoiler boilerElectrolux = new WaterBoiler("Electrolux", 8.2, 3, false);

        boilerElectrolux.changeState(true);
        boilerElectrolux.boilWater(2);
        boilerElectrolux.printDescription();
        System.out.println();

        WashingMachine washingMachine = new WashingMachine("LG", 5.6, 6.5, true);

        washingMachine.changeState(false);
        washingMachine.printDescription();
        washingMachine.loadLinen(5);
        washingMachine.washLinen();
        System.out.println();

        TV tv = new TV("Living room", "Samsung", 1.2, 10, true);
        TV kitchenTV = new TV("Kitchen", "LG", 1.5, 15, true);

        tv.printDescription();
        tv.changeNumberOfChannels(8);
        tv.enableChannel(2);
        kitchenTV.enableChannel(8);
        System.out.println();

        VacuumCleaner vacuumCleaner = new VacuumCleaner("Hallway", "LG", 1.5, 6.5, true);

        vacuumCleaner.changeLocation("Living room");
        vacuumCleaner.vacuumTheRoom("Living room", 12);
        System.out.println();

        printNumberOfAppliances();
        System.out.println();

        printArray(getAppliancesArray());
        System.out.println();

        sortAppliancesArray(true, false, getAppliancesArray(), 0, getAppliancesArray().length - 1);
        printArray(getAppliancesArray());
        System.out.println();

        sortAppliancesArray(false, true, getAppliancesArray(), 0, getAppliancesArray().length - 1);
        printArray(getAppliancesArray());
        System.out.println();

        Appliances[] appliancesWithParameters = findAppliancesWithSetOfParameters(true, "Kitchen", false, "", false, "",
                true, 0, 2, false, 0, 0, false, false);
        printArray(appliancesWithParameters);
        System.out.println();

        //В остальные не стала дописывать аналогичные методы, решила что это излишне =)
        Fridge[] fridgesWithParameters = fridgeLG.findFridgeWithParameters(false, "", false, "", false, "",
                false, 0, 0, false, 0, 0, false, false, "left");
        Fridge.printArray(fridgesWithParameters);

        Kettle[] kettlesWithParameter = kettleLornay.findKettleWithParameters(false, "", false, "", false, "",
                false, 0, 0, false, 0, 0, false, false, 1300, 2000);
        Kettle.printArray(kettlesWithParameter);


    }

}
