package WorkingWithAbstractionExr.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] initialState = scan.nextLine().split("\\s+");

        int numberOfUpdates = Integer.parseInt(scan.nextLine());

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String lightColor : initialState) {

            TrafficLight trafficLight = new TrafficLight(Color.valueOf(lightColor));
            trafficLights.add(trafficLight);

        }

        for (int i = 0; i < numberOfUpdates; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                System.out.print(trafficLight.getColor() + " ");
            }
            System.out.println();
        }

    }
}
