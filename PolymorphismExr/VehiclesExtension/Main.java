package PolymorphismExr.VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        String[] vehicleData = scan.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(vehicleData[1]),
                Double.parseDouble(vehicleData[2]), Double.parseDouble(vehicleData[3]));
        vehicleMap.put(vehicleData[0], car);

        vehicleData = scan.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(vehicleData[1]),
                Double.parseDouble(vehicleData[2]), Double.parseDouble(vehicleData[3]));
        vehicleMap.put(vehicleData[0], truck);

        vehicleData = scan.nextLine().split("\\s+");
        Vehicle bus = new Bus(Double.parseDouble(vehicleData[1]),
                Double.parseDouble(vehicleData[2]), Double.parseDouble(vehicleData[3]));
        vehicleMap.put(vehicleData[0], bus);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commands = scan.nextLine().split("\\s+");

            if (commands[0].equals("Drive")) {
                vehicleMap.get(commands[1]).driving(Double.parseDouble(commands[2]),
                        vehicleMap.get(commands[1]).getFuelConsumption());
            } else if (commands[0].equals("Refuel")) {
                vehicleMap.get(commands[1]).refueling(Double.parseDouble(commands[2]));
            } else {
                bus.driving(Double.parseDouble(commands[2]),
                        vehicleMap.get(commands[1]).getFuelConsumption()
                            - Bus.AIR_CONDITIONER_CONSUMPTION);
            }
        }

        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.println(vehicle.toString());
        }
    }
}
