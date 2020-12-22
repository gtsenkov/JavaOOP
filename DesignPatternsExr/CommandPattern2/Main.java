package DesignPatternsExr.CommandPattern2;

import DesignPatternsExr.CommandPattern2.Commands.Command;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static class CommandBuilder {
        private String commandName;
        private Integer param;

        public CommandBuilder(String commandName, Integer param) {
            this.commandName = commandName;
            this.param = param;
        }

        public Command build() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
            Command command = SingletonContainer.getCommands().get(this.commandName);
            if (this.param != null) {

            }
            return command;
        }
    }

    public static boolean gameOver = false;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner scan = new Scanner(System.in);


        while (!gameOver) {
            String line = scan.nextLine();
            processInput(line);

        }
    }

    private static void processInput(String line) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String[] tokens = line.split("\\s+");

        Integer param = tokens.length == 2 ? Integer.parseInt(tokens[1]) : null;

        System.out.println(new CommandBuilder(tokens[0], param).build().execute());


    }

    //Commands:
    //Attack 10
    //Defend
    //Move 5
    //Loose
}
