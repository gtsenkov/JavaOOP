package ReflectionAndAnnotationsExr.barracksWars.core.commands;

import ReflectionAndAnnotationsExr.barracksWars.interfaces.Executable;
import ReflectionAndAnnotationsExr.barracksWars.interfaces.Repository;

public class Report implements Executable {
    private Repository repository;

    public Report() {

    }
    public Report(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }
}
