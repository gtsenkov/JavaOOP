package WorkingWithAbstractionLab.StudentSystem;

public class ParseCommand {
    String name;
    int age;
    double grade;
    Student student;

    ParseCommand( String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.student = new Student(name, age, grade);
    }

    public String getName() {
        return name;
    }

    public Student getStudent() {
        return student;
    }
}
