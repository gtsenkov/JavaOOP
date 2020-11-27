package ReflectionAndAnnotationsExr.barracksWars.core.commands;

import ReflectionAndAnnotationsExr.barracksWars.interfaces.Executable;

public class Fight implements Executable {
    public Fight() {

    }

    @Override
    public String execute() {
        return "fight";
    }
}
