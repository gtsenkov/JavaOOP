package WorkingWithAbstractionLab.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while (true)
        {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            if (input[0].equals("Exit")){
                break;
            }

            if (command.equals("Create")) {
                String name = input[1];
                int age = Integer.parseInt(input[2]);
                double grade =Double.parseDouble(input[3]);
                ParseCommand parser = new ParseCommand(name, age, grade);
                studentSystem.setRepo(parser.getName(), parser.getStudent());
            } else {
                printResult(input[1], studentSystem);

            }


        }
    }

    private static void printResult(String studentName, StudentSystem studentSystem) {
        if (studentSystem.getRepo().containsKey(studentName)) {
            Student student = studentSystem.getRepo().get(studentName);
            String view = String.format("%s is %s years old.",student.getName(),student.getAge());

            if (student.getGrade() >= 5.00)
            {
                view += " Excellent student.";
            }
            else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50)
            {
                view += " Average student.";
            }
            else
            {
                view += " Very nice person.";
            }

            System.out.println(view);
        }
    }
}
