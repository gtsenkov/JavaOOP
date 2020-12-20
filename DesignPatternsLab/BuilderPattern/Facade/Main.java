package DesignPatternsLab.BuilderPattern.Facade;

public class Main {
    public static void main(String[] args) {

        new AddressBuilder()
                .withEmail("email")
                .withName("Name")
                .build();
    }
}
