package PolymorphismExr.Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        String[] vehicleData = scan.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(vehicleData[1]),
                Double.parseDouble(vehicleData[2]));
        vehicleMap.put(vehicleData[0], car);

        vehicleData = scan.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(vehicleData[1]),
                Double.parseDouble(vehicleData[2]));
        vehicleMap.put(vehicleData[0], truck);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commands = scan.nextLine().split("\\s+");

            if (commands[0].equals("Drive")) {
                vehicleMap.get(commands[1]).driving(Double.parseDouble(commands[2]));
            } else {
                vehicleMap.get(commands[1]).refueling(Double.parseDouble(commands[2]));
            }
        }

        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.println(vehicle.toString());
        }
    }
}
