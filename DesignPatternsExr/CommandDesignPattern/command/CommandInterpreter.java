package DesignPatternsExr.CommandDesignPattern.command;

import DesignPatternsExr.BuilderPattern.MapBuilder;
import DesignPatternsExr.BuilderPattern.MyMapBuilder;

import java.util.Map;

public class CommandInterpreter implements CommandListener {
    private Map<String, Command> commands = Map.of("W", new MoveUp(),
            "S", new MoveDown(),
            "A", new MoveLeft(),
            "D", new MoveRight(),
            "F", new Fire());

    public CommandInterpreter() {
        MapBuilder<String, Command> builder = new MyMapBuilder<>();
        this.commands = builder
                .entry("W", new MoveUp())
                .entry("S", new MoveDown())
                .entry("A", new MoveLeft())
                .entry("D", new MoveRight())
                .entry("F", new Fire())
                .build();
    }

    @Override
    public void handelCommand(String type) {
        Command command = commands.get(type.toUpperCase());
        if (command == null) {
            throw new IllegalArgumentException("Invalid command type");
        }

        command.execute();
    }
}
