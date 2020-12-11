package EncapsulationExr.ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Person> peopleMap = new LinkedHashMap<>();
        Map<String, Product> productMap = new LinkedHashMap<>();

        String[] peopleCount = scan.nextLine().split(";");
        for (String people : peopleCount) {
            String[] personData = people.split("=");
            String personName = personData[0];
            double personMoney = Double.parseDouble(personData[1]);
            try {
                Person person = new Person(personName, personMoney);
                peopleMap.put(person.getName(), person);
            } catch (IllegalArgumentException ex ) {
                System.out.println(ex.getMessage());
            }
        }

        String[] productCount = scan.nextLine().split(";");
        for (String currentProduct : productCount) {
            String[] productData = currentProduct.split("=");
            String productName = productData[0];
            double productCost = Double.parseDouble(productData[1]);
            Product product = new Product(productName, productCost);
            productMap.put(product.getName(), product);
        }

        String buyingProduct = scan.nextLine();

        while (!buyingProduct.equals("END")) {
            String[] buyingData = buyingProduct.split(" ");
            String personName = buyingData[0];
            String productName = buyingData[1];

            if (!peopleMap.isEmpty() && !productMap.isEmpty()) {
                try {
                    peopleMap.get(personName).buyProduct(productMap.get(productName));
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            buyingProduct = scan.nextLine();
        }

        for (Person person : peopleMap.values()) {
            System.out.println(person);
        }
    }
}
