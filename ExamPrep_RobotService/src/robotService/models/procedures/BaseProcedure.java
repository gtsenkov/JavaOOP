package robotService.models.procedures;

import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.interfaces.Robot;

import java.util.ArrayList;
import java.util.Collection;

import static robotService.common.ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME;

public abstract class BaseProcedure implements Procedure {
    public Collection<Robot> robots;

    protected BaseProcedure() {
        this.robots = new ArrayList<>();
    }

    @Override
    public String history() {
        String separator = System.lineSeparator();
        StringBuilder out = new StringBuilder(this.getClass().getSimpleName() + separator);
        for (Robot robot : robots) {
            out.append(robot.toString()).append(separator);
        }
        return out.toString().trim();
    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.getProcedureTime() < procedureTime) {
            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);
        }
        robot.setProcedureTime(robot.getProcedureTime() - procedureTime);
        this.robots.add(robot);
    }
}
