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
        fridgeSamsung.changeDoorOpeningDirection();
        fridgeSamsung.printDescription();
        System.out.println();
        fridgeSamsung.changeState(true);

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

        WashingMachine washingMachine = new WashingMachine("LG", 5.6, 6.5, true);

        washingMachine.changeState(false);
        washingMachine.printDescription();
        washingMachine.loadLinen(5);
        washingMachine.washLinen();
        System.out.println();

        TV tv = new TV("Living room", "Samsung", 1.2, 10, true);

        tv.printDescription();
        tv.changeNumberOfChannels(8);
        tv.enableChannel(2);
        System.out.println();

        VacuumCleaner vacuumCleaner = new VacuumCleaner("Hallway","LG", 1.5,6.5, true);
        VacuumCleaner vacuumCleaner2 = new VacuumCleaner("Hallway","LG", 1.5,6.5, true);


        printNumberOfAppliances();
        System.out.println();

        printAppliancesArray(getAppliancesArray());
        System.out.println();

        sortAppliancesArray(true, false, getAppliancesArray(), 0, getAppliancesArray().length - 1);
        printAppliancesArray(getAppliancesArray());
        System.out.println();

        sortAppliancesArray(false, true, getAppliancesArray(), 0, getAppliancesArray().length - 1);
        printAppliancesArray(getAppliancesArray());
        System.out.println();

        Appliances[] appliancesWithParameters = findAppliancesByLocation("Kitchen", getAppliancesArray());
        appliancesWithParameters = findAppliancesByPower(0,1000, appliancesWithParameters);
        printAppliancesArray(appliancesWithParameters);
    }

}
