package EncapsulationExr.MartiPPizzaExample;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] pizzaData = scan.nextLine().split("\\s+");
//        String pizzaName = pizzaData[1];
//        int toppings = Integer.parseInt(pizzaData[2]);


        try {
            Pizza pizza = new Pizza(pizzaData[1], Integer.parseInt(pizzaData[2]));

            String[] doughData = scan.nextLine().split("\\s+");
            String flourType = doughData[1];
            String bakingTechnique = doughData[2];
            double weight = Double.parseDouble(doughData[3]);

            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);

            String toppingData = scan.nextLine();

            while (!toppingData.equals("END")) {
                String[] tokens = toppingData.split("\\s+");

                String toppingName = tokens[1];
                double toppingWeight = Double.parseDouble(tokens[2]);

                Topping currentTopping = new Topping(toppingName, toppingWeight);
                pizza.addTopping(currentTopping);

                toppingData = scan.nextLine();
            }

            System.out.println(pizza.toString());

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}

