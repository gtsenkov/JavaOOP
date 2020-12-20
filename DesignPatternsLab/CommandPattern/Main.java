package DesignPatternsLab.CommandPattern;

public class Main {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();

        invoker.invoke("PrintName");
        invoker.invoke("PrintRandomNumber");
    }
}
