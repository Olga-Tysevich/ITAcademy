package inProgress.lesson7.task2;

import inProgress.lesson7.task2.park.Bus;
import inProgress.lesson7.task2.park.Trolleybus;
import inProgress.lesson7.task2.park.Vehicle;

public class TransportParkDemo {
    public static void main(String[] args) {
        TransportPark parkNumberOne = new TransportPark("Transport Park No. 1", "B1", "B2", "B3", "TB1", "TB2", "TB3", "RT1", "RT2", "RT3");
        System.out.println(parkNumberOne);

        TransportPark parkNumberTwo = new TransportPark("Transport Park No. 2", "B4", "B5", "TB4", "TB5", "RT4");
        System.out.println(parkNumberTwo);

        Bus busLiaz = new Bus(parkNumberOne, "Bus", "LIAZ-5292", 2315, 70000, 6.65, 50, 290);
        Bus busMan = new Bus(parkNumberOne, "Bus", "MAN SL200", 1528, 30000, 8.75, 40, 250);
        Bus busSkoda = new Bus(parkNumberOne, "Bus", "Skoda-М706RO", 2108, 80000, 7.5, 50, 270);
        Bus busKarosa = new Bus(parkNumberOne, "Bus", "Karosa B732", 5623, 40000, 6.25, 45, 220);

        Bus routeTaxiGaz = new Bus(parkNumberOne, "Route bus", "GAZ-322132", 6314, 25000, 5.5,
                15, 70);
        Bus routeTaxiIveco = new Bus(parkNumberOne, "Route bus", "IVECO DAILY 2227UU-702", 1574, 28000, 6.5,
                12, 65);
        Bus routeTaxiFiat = new Bus(parkNumberOne, "Route bus", "Fiat Ducato", 6314, 27000, 7,
                18, 75);

        Trolleybus trolleybusAKSM32100 = new Trolleybus(parkNumberOne, "Trolleybus", "AKSM-32100", 4562, 42500, 55,
                205);
        Trolleybus trolleybusAKSM32102 = new Trolleybus(parkNumberOne, "Trolleybus", "AKSM-32102", 4563, 47500, 60,
                170);
        Trolleybus trolleybusAKSM32104 = new Trolleybus(parkNumberOne, "Trolleybus", "AKSM-32104", 4564, 55000, 65,
                185);

        parkNumberOne.setRouteForVehicle(busLiaz, "B1");
        parkNumberOne.setRouteForVehicle(busMan, "B2");
        parkNumberOne.setRouteForVehicle(busSkoda, "B3");

        parkNumberOne.setRouteForVehicle(routeTaxiGaz, "RT1");
        parkNumberOne.setRouteForVehicle(routeTaxiIveco, "RT2");
        parkNumberOne.setRouteForVehicle(routeTaxiFiat, "RT3");

        parkNumberOne.setRouteForVehicle(trolleybusAKSM32100, "TB1");
        parkNumberOne.setRouteForVehicle(trolleybusAKSM32102, "TB2");
        parkNumberOne.setRouteForVehicle(trolleybusAKSM32104, "TB3");

        System.out.println(parkNumberOne);
        parkNumberOne.handOverVehicle(busKarosa, parkNumberTwo);
        System.out.println(parkNumberOne);

        parkNumberTwo.setRouteForVehicle(busKarosa, "B4");
        System.out.println(parkNumberTwo);

        parkNumberTwo.addServedRouteToTransportPark("RT5");
        System.out.println(parkNumberTwo);

        Bus busIkarus = new Bus(parkNumberTwo, "Bus", "Ikarus-55", 2536, 45600, 7.25, 57, 275);
        Bus busLAZ = new Bus(parkNumberTwo, "Bus", "LAZ-697N", 2746, 52000, 8.25, 63, 295);

        Bus routTaxiCitroen = new Bus(parkNumberTwo, "Route bus", "CITROEN JUMPER", 3695, 29500, 8.5,
                15, 80);
        Bus routTaxiPeugeot = new Bus(parkNumberTwo, "Route bus", "Peugeot Boxer", 3247, 24500, 6.75,
                12, 55);

        Trolleybus trolleybusAEC = new Trolleybus(parkNumberTwo, "Trolleybus", "AEC 602", 4794, 65700, 72,
                168);
        Trolleybus trolleybusAMZ = new Trolleybus(parkNumberTwo, "Trolleybus", "AMZ City Smile 12T", 6344, 69800, 87,
                253);


        parkNumberTwo.setRouteForVehicle(busIkarus, "B5");
        parkNumberTwo.setRouteForVehicle(routTaxiCitroen, "RT4");
        parkNumberTwo.setRouteForVehicle(routTaxiPeugeot, "RT5");
        parkNumberTwo.setRouteForVehicle(trolleybusAEC, "TB4");
        parkNumberTwo.setRouteForVehicle(trolleybusAMZ, "TB5");

        System.out.println(parkNumberTwo);

        parkNumberOne.sendToRoute(busLiaz);

        TransportPark.printTransportParksList();

        parkNumberOne.printArrayOfTransferredVehicles();
        System.out.println();

        parkNumberOne.sortVehiclesForFuelConsumption(0, parkNumberOne.getVehicleParkSize()-1);
        System.out.println(parkNumberOne + "\n");

        Vehicle vehicleWithParameters = parkNumberOne.findVehicleWithParameters(false, "", false,"",
                false, 0, true,55000,55000,false,0,15,
                false, "", false, 0, 8,
                false,0,250, true, 185,185);

        System.out.println("Vehicle with options: " + vehicleWithParameters + "\n");

        Vehicle[] vehiclesWithParameters = parkNumberOne.findVehiclesWithParameters(false, "", false,"",
                false, 0, false,0,50000,false,0,15,
                false, "");

        Vehicle.printArrayOfVehicle(vehiclesWithParameters);

        Vehicle[] vehiclesWithParametersByAllParks = TransportPark.findVehicleFromAllParks(true, "Bus", false,"",
                false, 0, true,0,55000,false,0,15,
                false, "");
        TransportPark.printArrayOfVehicle(vehiclesWithParametersByAllParks);

        Vehicle[] vehiclesWithAllParameters = parkNumberOne.findVehiclesWithParameters(false, "", false,"",
                false, 0, false,0,50000,false,0,15,
                false, "", false, 0, 8,
                false,0,250, true, 0,185);
        Vehicle.printArrayOfVehicle(vehiclesWithAllParameters);

        Vehicle[] vehiclesWithParametersByAllParks2 = TransportPark.findVehicleFromAllParks(false, "Bus", false,"",
                false, 0, true,0,55000,false,0,15,
                false, "", false, 0, 8,
                false,0,250, true, 0,185);
        TransportPark.printArrayOfVehicle(vehiclesWithParametersByAllParks2);
    }
}
