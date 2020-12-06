package InterfacesAndAbstractionExr.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Citizen":
                    Citizen citizen = new Citizen(
                            tokens[1], Integer.parseInt(tokens[2]),
                            tokens[3], tokens[4]);
                    birthables.add(citizen);
                    break;
                case "Robot":
                    Robot robot = new Robot(tokens[1], tokens[2]);
                    break;
                case "Pet":
                    Pet pet = new Pet(tokens[1], tokens[2]);
                    birthables.add(pet);
                    break;
            }
            input = scan.nextLine();
        }

        String searchedYear = scan.nextLine();

        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(searchedYear)) {
                System.out.println(birthable.getBirthDate());
            }
        }



    }
}
