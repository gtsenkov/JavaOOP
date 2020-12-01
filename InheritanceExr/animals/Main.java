package InheritanceExr.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String animalType = scan.nextLine();

        while (!animalType.equals("Beast!")) {
            String[] animalData = scan.nextLine().split("\\s+");

            String name = animalData[0];
            int age = Integer.parseInt(animalData[1]);
            try {
                if (age < 0) {
                    throw new IllegalArgumentException("Invalid input!");
                }
                if (!animalData[2].equals("Male") && !animalData[2].equals("Female")) {
                    throw new IllegalArgumentException("Invalid input!");
                }
                if (name == null || name.trim().isEmpty()) {
                    throw new IllegalArgumentException("Invalid input!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
                animalType = scan.nextLine();
                continue;
            }
            Gender gender = Gender.valueOf(animalData[2].toUpperCase());

            switch (animalType) {
                case "Frog":
                    Frog frog = new Frog(name, age, gender);
                    System.out.println(frog.toString());
                    break;
                case "Dog":
                    Dog dog = new Dog(name, age, gender);
                    System.out.println(dog.toString());
                    break;
                case "Cat":
                    Cat cat = new Cat(name, age, gender);
                    System.out.println(cat.toString());
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(name, age);
                    System.out.println(kitten.toString());
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(name, age);
                    System.out.println(tomcat.toString());
                    break;
            }

            animalType = scan.nextLine();
        }
    }
}
