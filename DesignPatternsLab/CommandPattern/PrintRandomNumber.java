package DesignPatternsLab.CommandPattern;

import java.util.concurrent.ThreadLocalRandom;

public class PrintRandomNumber implements Command {
    @Override
    public void execute() {
        System.out.println(ThreadLocalRandom.current().nextInt(19999));
    }
}
