package InheritanceExr.animals;

public class Tomcat extends Cat {

    public Tomcat(String name, int age) {
        super(name, age, Gender.MALE);
    }

//    public Tomcat(String name, int age, String gender) {
//        super(name, age, Gender.MALE);
//    }

    @Override
    protected String produceSound() {
        return "MEOW";
    }
}
