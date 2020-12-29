package robotService.models.procedures;



import robotService.models.robots.interfaces.Robot;


public class Charge extends BaseProcedure {
    

    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot, procedureTime);
        int newHappiness = robot.getHappiness() + 12;
        robot.setHappiness(newHappiness); 
        int newEnergy = robot.getEnergy() + 10;
        robot.setEnergy(newEnergy);
    }
}
