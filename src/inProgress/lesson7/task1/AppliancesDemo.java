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
        System.out.println(fridgeSamsung + "\n");
        fridgeSamsung.changeState(true);

        fridgeLG.changeDoorOpeningDirection();
        System.out.println(fridgeLG + "\n");

        Microwave microwaveSamsung = new Microwave("Samsung", 3, 6, 250, false);

        System.out.println(microwaveSamsung);
        microwaveSamsung.putPlate(300);
        microwaveSamsung.putPlate(230);
        microwaveSamsung.heatUp(8);
        microwaveSamsung.changeState(true);
        microwaveSamsung.heatUp(6);
        System.out.println(microwaveSamsung + "\n");

        Kettle kettleLornay = new Kettle("L'ORNAY", 4.5, 1800, false);
        Kettle kettleScarlett = new Kettle("Scarlett", 3.5, 1200, true);

        System.out.println(kettleLornay);
        kettleLornay.changeState(true);
        kettleLornay.pourTheWater(1900);
        kettleLornay.pourTheWater(1500);
        kettleLornay.boilWater();
        System.out.println(kettleLornay + "\n");

        System.out.println("Scarlet water volume: " + kettleScarlett.getWaterVolume() + "\n");

        WaterBoiler boilerElectrolux = new WaterBoiler("Electrolux", 8.2, 3, false);

        System.out.println(boilerElectrolux);
        boilerElectrolux.changeState(true);
        boilerElectrolux.warmUpWater(2);
        System.out.println(boilerElectrolux + "\n");

        WashingMachine washingMachine = new WashingMachine("LG", 5.6, 6.5, true);

        System.out.println(washingMachine);
        washingMachine.changeState(false);
        washingMachine.loadLinen(5);
        washingMachine.washLinen();
        System.out.println(washingMachine + "\n");

        TV tv = new TV("Living room", "Samsung", 1.2, 10, true);
        TV kitchenTV = new TV("Kitchen", "LG", 1.5, 15, true);

//        tv.printDescription();
        tv.changeNumberOfChannels(8);
        tv.enableChannel(2);
        kitchenTV.enableChannel(8);
        System.out.println();

        VacuumCleaner vacuumCleaner = new VacuumCleaner("Hallway", "LG", 1.5, 6.5, false);

        System.out.println(vacuumCleaner);
        vacuumCleaner.changeLocation("Living room");
        vacuumCleaner.changeState(true);
        double perimeterOfLivingRoomForClean = 12;
        perimeterOfLivingRoomForClean = vacuumCleaner.cleanTheRoom("Living room", 12);
        vacuumCleaner.cleanContainer();
        perimeterOfLivingRoomForClean = vacuumCleaner.cleanTheRoom("Living room", perimeterOfLivingRoomForClean);

        System.out.println(vacuumCleaner + "\n");

        printNumberOfAppliances();
        System.out.println();

        printArrayOfAppliances(addApplianceToArrayOfAppliances());
        System.out.println();

        sortArrayOfAppliances(true, false, addApplianceToArrayOfAppliances(), 0, addApplianceToArrayOfAppliances().length - 1);
//        printArrayOfAppliances(getAppliancesArray());
//        System.out.println();

        sortArrayOfAppliances(false, true, addApplianceToArrayOfAppliances(), 0, addApplianceToArrayOfAppliances().length - 1);
//        printArrayOfAppliances(getAppliancesArray());
//        System.out.println();

        Appliances[] appliancesWithParameters = findAppliancesWithSetOfParameters(true, "Kitchen", false, "", false, "",
                true, 0, 2, false, 0, 0, false, false);
//        printArrayOfAppliances(appliancesWithParameters);
//        System.out.println();

        //В остальные не стала дописывать аналогичные методы, решила что это излишне =)
        Fridge[] fridgesWithParameters = fridgeLG.findFridgesWithSetOfParameters(false, "", false, "", false, "",
                false, 0, 0, false, 0, 0, false, false, "left");
        Fridge.printArray(fridgesWithParameters);
        Fridge fridgeWithParameters = fridgesWithParameters[0];
        System.out.println("\n" + fridgeWithParameters);

        Kettle[] kettlesWithParameter = kettleLornay.findKettlesWithSetOfParameters(false, "", false, "", false, "",
                false, 0, 0, false, 0, 0, false, false, 1300, 2000);
        Kettle.printArray(kettlesWithParameter);


    }

}
