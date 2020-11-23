package WorkingWithAbstractionExr.JediGalaxy;

public class Player {

    private int playerStartRow;
    private int playerStartCol;
    private int[][] matrix;

    public Player(int playerStartRow, int playerStartCol, int[][] matrix) {
        this.playerStartRow = playerStartRow;
        this.playerStartCol = playerStartCol;
        this.matrix = matrix;
    }


    public void runToTopLeft(int[][] matrix) {
        while (playerStartRow >= 0 && playerStartCol >= 0) {
            if (isInBound(playerStartRow, playerStartCol, matrix)) {
                matrix[playerStartRow][playerStartCol] = 0;
            }
            playerStartRow--;
            playerStartCol--;
        }
    }

    private static boolean isInBound(int evilStartRow, int evilStartCol, int[][] matrix) {
        return evilStartRow >= 0 && evilStartRow < matrix.length && evilStartCol >= 0 && evilStartCol < matrix[0].length;
    }

    public long runToTopRight(int[][] matrix) {
        long sum = 0;

        while (playerStartRow >= 0 && playerStartCol < matrix[1].length) {
            if (isInBound(playerStartRow, playerStartCol, this.matrix)) {
                sum += matrix[playerStartRow][playerStartCol];
            }

            playerStartCol++;
            playerStartRow--;
        }

        return sum;
    }
}
