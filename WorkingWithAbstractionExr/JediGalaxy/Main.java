package WorkingWithAbstractionExr.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int[][] matrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        matrixCreator(scan);
        String command = scan.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoStartPos = findStartPos(command);

            int ivoStartRow = ivoStartPos[0];
            int ivoStartCol = ivoStartPos[1];
            Player ivo = new Player(ivoStartRow, ivoStartCol, matrix);


            int[] evilStartPos = findStartPos(scan.nextLine());

            int evilStartRow = evilStartPos[0];
            int evilStartCol = evilStartPos[1];
            Player evil = new Player(evilStartRow, evilStartCol, matrix);

            evil.runToTopLeft(matrix);

            sum += ivo.runToTopRight(matrix);

            command = scan.nextLine();
        }

        System.out.println(sum);


    }

    private static int[] findStartPos(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void matrixCreator(Scanner scan) {
        int[] dimensions = findStartPos(scan.nextLine());
        int x = dimensions[0];
        int y = dimensions[1];

        matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
