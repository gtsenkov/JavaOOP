package EncapsulationExr.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            throw new IllegalArgumentException(name
                    + " can't afford " + product.getName());
        }
        this.products.add(product);
        System.out.println(name + " bought " + product.getName());
        this.money -= product.getCost();
    }

    @Override
    public String toString() {

        String productsOutput = this.products.isEmpty()
                ? "Nothing bought"
                : this.products.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));

        return name + " - " + productsOutput;
    }
}
