package forCheck.lesson7_8.task1;

import forCheck.lesson7_8.task1.bathroomappliances.WashingMachine;
import forCheck.lesson7_8.task1.bathroomappliances.WaterBoiler;
import forCheck.lesson7_8.task1.kitchenappliances.Fridge;
import forCheck.lesson7_8.task1.kitchenappliances.Kettle;
import forCheck.lesson7_8.task1.kitchenappliances.Microwave;
import forCheck.lesson7_8.task1.otherappliances.TV;
import forCheck.lesson7_8.task1.otherappliances.VacuumCleaner;

public class VacuumDemo {
    public static void main(String[] args) {
        Vacuum vacuum = new Vacuum();
        Fridge fridgeSamsung = new Fridge(vacuum, "Samsung", 1.3, "left");
        Fridge fridgeLG = new Fridge(vacuum, "LG", 1.5, "right");

        fridgeSamsung.changeDoorOpeningDirection();
        System.out.println(fridgeSamsung + "\n");
        fridgeSamsung.changeState();

        fridgeLG.changeDoorOpeningDirection();
        System.out.println(fridgeLG + "\n");

        Microwave microwaveSamsung = new Microwave(vacuum, "Samsung", 3, 6, 250, false);

        System.out.println(microwaveSamsung);
        microwaveSamsung.putPlate(300);
        microwaveSamsung.putPlate(230);
        microwaveSamsung.heatUp(8);
        microwaveSamsung.changeState();
        microwaveSamsung.heatUp(6);
        System.out.println(microwaveSamsung + "\n");

        Kettle kettleLornay = new Kettle(vacuum, "L'ORNAY", 4.5, 1800, false);
        Kettle kettleScarlett = new Kettle(vacuum, "Scarlett", 3.5, 1200, true);

        System.out.println(kettleLornay);
        kettleLornay.changeState();
        kettleLornay.pourTheWater(1900);
        kettleLornay.pourTheWater(1500);
        kettleLornay.boilWater();
        System.out.println(kettleLornay + "\n");

        System.out.println("Scarlet water volume: " + kettleScarlett.getWaterVolume() + "\n");

        WaterBoiler boilerElectrolux = new WaterBoiler(vacuum, "Electrolux", 8.2, 3, false);

        System.out.println(boilerElectrolux);
        boilerElectrolux.changeState();
        boilerElectrolux.warmUpWater(2);
        System.out.println(boilerElectrolux + "\n");

        WashingMachine washingMachine = new WashingMachine(vacuum, "LG", 5.6, 6.5, true);

        System.out.println(washingMachine);
        washingMachine.changeState();
        washingMachine.loadLinen(5);
        washingMachine.washLinen();
        System.out.println(washingMachine + "\n");

        TV tvSamsung = new TV(vacuum, "Living room", "Samsung", 1.2, 10, false);
        TV kitchenTV = new TV(vacuum, "Kitchen", "LG", 1.5, 15, true);

        System.out.println(tvSamsung);
        tvSamsung.changeNumberOfChannels(8);
        tvSamsung.enableChannel(2);
        System.out.println(tvSamsung + "\n");
        System.out.println(kitchenTV);
        kitchenTV.enableChannel(8);
        System.out.println(kitchenTV + "\n");

        VacuumCleaner vacuumCleaner = new VacuumCleaner(vacuum, "Hallway", "LG", 1.5, 6.5, false);

        System.out.println(vacuumCleaner);
        vacuumCleaner.changeLocation("Living room");
        vacuumCleaner.changeState();
        double cleaningAreaPerimeter = 12;
        cleaningAreaPerimeter = vacuumCleaner.cleanTheRoom("Living room", cleaningAreaPerimeter);
        vacuumCleaner.cleanContainer();
        cleaningAreaPerimeter = vacuumCleaner.cleanTheRoom("Living room", cleaningAreaPerimeter);
        System.out.println(vacuumCleaner + "\n");

        vacuum.printNumberOfAppliances();
        System.out.println();

        vacuum.printArrayOfAppliances();

        vacuum.sortArrayOfAppliances(true, false, 0, vacuum.getNumberOfAppliances() - 1);
        vacuum.printArrayOfAppliances();

        vacuum.sortArrayOfAppliances(false, true, 0, vacuum.getNumberOfAppliances() - 1);
        vacuum.printArrayOfAppliances();

        Appliance applianceWithParameters = vacuum.findApplianceWithSetOfParameters(false, "", true, "Fridge",
                false, "", true, 1.3, 1.5,
                false, 0, 0, false, true);
        System.out.println(applianceWithParameters + "\n");

        Appliance[] appliancesWithParameters = vacuum.findAppliancesWithSetOfParameters(true, "Kitchen", false, "", false, "",
                true, 0, 2, false, 0, 0, false, false);
        Appliance.printArrayOfAppliances(appliancesWithParameters);

    }

}
