package ReflectionAndAnnotationsExr.barracksWars;

import ReflectionAndAnnotationsExr.barracksWars.core.commands.CommandModel;
import ReflectionAndAnnotationsExr.barracksWars.interfaces.CommandInterpreter;
import ReflectionAndAnnotationsExr.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationsExr.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotationsExr.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotationsExr.barracksWars.core.Engine;
import ReflectionAndAnnotationsExr.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotationsExr.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandModel(repository, unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
