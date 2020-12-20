package DesignPatternsLab.CommandPattern;

public class PrintNameCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Printing name...");
    }
}
