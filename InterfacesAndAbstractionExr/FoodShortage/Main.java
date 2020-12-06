package InterfacesAndAbstractionExr.FoodShortage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Citizen> citizenMap = new LinkedHashMap<>();
        Map<String, Rebel> rebelMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] input = scan.nextLine().split("\\s+");

            if (input.length == 4) {
                Citizen citizen = new Citizen(input[0], Integer.parseInt(input[1]),
                        input[2], input[3]);
                citizenMap.put(citizen.getName(), citizen);
            } else {
                Rebel rebel = new Rebel(input[0], Integer.parseInt(input[1]),
                        input[2]);
                rebelMap.put(rebel.getName(), rebel);
            }
        }

        String buyer = scan.nextLine();

        while (!buyer.equals("End")) {

            if (rebelMap.containsKey(buyer)) {
                rebelMap.get(buyer).buyFood();
            } else if (citizenMap.containsKey(buyer)) {
                citizenMap.get(buyer).buyFood();
            }

            buyer = scan.nextLine();
        }

        int totalFood = citizenMap.values().stream()
                .mapToInt(Citizen::getFood).sum() + rebelMap.values().stream()
                .mapToInt(Rebel::getFood).sum();

        System.out.println(totalFood);
    }
}
