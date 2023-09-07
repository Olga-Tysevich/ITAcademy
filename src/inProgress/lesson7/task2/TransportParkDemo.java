package inProgress.lesson7.task2;

import inProgress.lesson7.task2.park.Bus;
import inProgress.lesson7.task2.park.Trolleybus;

public class TransportParkDemo {
    public static void main(String[] args) {
        TransportPark parkNumberOne = new TransportPark("Transport Park No. 1", "B1", "B2", "B3", "TB1", "TB2", "TB3", "RT1", "RT2", "RT3");
//        System.out.println(parkNumberOne);

        TransportPark parkNumberTwo = new TransportPark("Transport Park No. 2", "B4", "B5", "B6", "TB4", "TB5", "TB6", "RT4", "RT5");
//        System.out.println(parkNumberTwo);

        Bus busLiaz = new Bus(parkNumberOne, "Bus","LIAZ-5292",2315,70000, 6.65, 50, 290);
        Bus busMan = new Bus(parkNumberOne, "Bus","MAN SL200",1528,30000, 8.75, 40, 250);
        Bus busSkoda = new Bus(parkNumberOne, "Bus","Skoda-М706RO",2108,80000, 7.5, 50, 270);
        Bus busKarosa = new Bus(parkNumberOne, "Bus","Karosa B732",5623,40000, 6.25, 45, 220);

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
        Trolleybus trolleybusAKSM32104 = new Trolleybus(parkNumberOne, "Trolleybus", "AKSM-32104", 4564, 5500, 65,
                185);


//        parkNumberOne.handOverVehicle(busSkoda, parkNumberTwo);

        parkNumberOne.setRouteForVehicle(busLiaz, "B1");
        parkNumberOne.setRouteForVehicle(busMan, "B2");
        parkNumberOne.setRouteForVehicle(busSkoda, "B3");

        parkNumberOne.setRouteForVehicle(routeTaxiGaz, "RT1");
        parkNumberOne.setRouteForVehicle(routeTaxiIveco, "RT2");
        parkNumberOne.setRouteForVehicle(routeTaxiFiat, "RT3");

        parkNumberOne.setRouteForVehicle(trolleybusAKSM32100, "TB1");
        parkNumberOne.setRouteForVehicle(trolleybusAKSM32102, "TB2");
        parkNumberOne.setRouteForVehicle(trolleybusAKSM32104, "TB3");

        parkNumberOne.handOverVehicle(busKarosa, parkNumberTwo);
        System.out.println(parkNumberOne);


        parkNumberTwo.setRouteForVehicle(busKarosa,"B4");
        System.out.println(parkNumberTwo);

        parkNumberTwo.changeNumberOfRoutesServed(9, "RT6");
        System.out.println(parkNumberTwo);

    }
}
