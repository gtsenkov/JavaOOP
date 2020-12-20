package DesignPatternsLab.PrototypePattern;

public class Main {
    public static void main(String[] args) {
        //same as extend but used for very very similar objects
        Chair chair = new Chair(13, 73, "Red");

        Chair clone = chair.clone(); //then differences can be applied by setters

        System.out.println(clone);
    }
}
