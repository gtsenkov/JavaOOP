package WorkingWithAbstractionLab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = Integer.parseInt(scan.nextLine());

        printTop(n);
        printBottom(n - 1);


        //  my
//        for (int row = 0; row < n; row++) {
//            for (int i = n - 1; i > row; i--) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j <= row; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }

//
//            for (int j = 0; j <= row; j++) {
//                System.out.print(" ");
//            }
//            for (int i = n - 1; i > row; i--) {
//                System.out.print("* ");
//            }
//            System.out.println();

// from Marti
//        for (int row = 1; row <= n; row++) {
//            for (int j = 0; j < n - row; j++) {
//                System.out.print(" ");
//            }
//            for (int i = 0; i < row; i++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//
//        for (int row = 1; row <= n; row++) {
//            for (int i = 0; i < row; i++) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j < n - row; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }


    }
    public static void printTop(int rowsCount) {
        for (int i = 1; i <= rowsCount; i++) {
            printString(rowsCount - i, " ");
            printString(i, "* ");
            System.out.println();
        }
    }

    public static void printBottom(int rowsCount) {
        for (int i = 1; i <= rowsCount; i++) {
            printString(i, " ");
            printString(rowsCount - (i - 1), "* ");
            System.out.println();
        }
    }

    public static void printString(int count, String string) {
        for (int i = 0; i < count; i++) {
            System.out.print(string);
        }
    }
}
