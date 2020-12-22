package DesignPatternsExr.CommandPattern2;

import DesignPatternsExr.CommandPattern2.Commands.Attack;
import DesignPatternsExr.CommandPattern2.Commands.Command;
import DesignPatternsExr.CommandPattern2.Commands.Defend;
import DesignPatternsExr.CommandPattern2.Commands.Move;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class SingletonContainer {
    private static Map<String, Command> commands;

    private SingletonContainer() {

    }

    private static void init() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        commands = new HashMap<>();

        File file = new File("C:\\Users\\Gosho\\IdeaProjects\\JavaOOP\\src\\DesignPatternsExr\\CommandPattern2\\Commands");
        File[] files = file.listFiles();

        for (File f : files) {

            if (f.getName().equals("Command.java")) {
                continue;
            }

            Class clazz = Class.forName(("DesignPatternsExr.CommandPattern2.Commands." + f.getName()).replaceAll(".java", ""));

            Constructor ctor = clazz.getDeclaredConstructor();

            Command command = (Command) ctor.newInstance();

            commands.put(f.getName().replaceAll(".java", ""), command);
        }

//        commands.put("Attack", new Attack());
//        commands.put("Defend", new Defend());
//        commands.put("Move", new Move());
//        ...
        //works w/o reflection
    }

    public static Map<String, Command> getCommands() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (commands == null) {
            init();
        }
        return commands;
    }
}
