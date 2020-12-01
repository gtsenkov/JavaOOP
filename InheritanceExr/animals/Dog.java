package InheritanceExr.animals;

public class Dog extends Animal {

    public Dog(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    @Override
    protected String produceSound() {
        return "Woof!";
    }
}
