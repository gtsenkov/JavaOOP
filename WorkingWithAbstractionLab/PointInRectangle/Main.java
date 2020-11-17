package WorkingWithAbstractionLab.PointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] coordinates = scan.nextLine().split(" ");

        int bottomLeftX = Integer.parseInt(coordinates[0]);
        int bottomLeftY = Integer.parseInt(coordinates[1]);
        int topRightX = Integer.parseInt(coordinates[2]);
        int topRightY = Integer.parseInt(coordinates[3]);

        Rectangle rectangle = new Rectangle(new Point(bottomLeftX, bottomLeftY),
                new Point(topRightX, topRightY));
//        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
//        Point topRight = new Point(topRightX, topRightY);


        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] checkCoordinates = scan.nextLine().split(" ");
            int X = Integer.parseInt(checkCoordinates[0]);
            int Y = Integer.parseInt(checkCoordinates[1]);
            Point pointToCheck = new Point(X, Y);
            System.out.println(rectangle.Contains(pointToCheck));
        }
    }
}
