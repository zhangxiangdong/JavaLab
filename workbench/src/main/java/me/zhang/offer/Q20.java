package me.zhang.offer;

/*
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 例如：如果输入如下矩阵：

    1 2 3
    4 5 6
    7 8 9

 * 依次打印出：1、2、3、6、9、8、7、4、5
 */
public class Q20 {

    public static void printOutMatrixClockwise(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        final int rows = matrix.length;
        final int columns = matrix[0].length;

        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            printMatrixInCircle(matrix, columns, rows, start);
            start++;
        }
    }

    private static void printMatrixInCircle(int[][] matrix, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        // 从左到右打印一行
        for (int i = start; i <= endX; i++) {
            printNumber(matrix[start][i]);
        }

        // 从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                printNumber(matrix[i][endX]);
            }
        }

        // 从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                printNumber(matrix[endY][i]);
            }
        }

        // 从下往上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                printNumber(matrix[i][start]);
            }
        }
    }

    private static void printNumber(int number) {
        System.out.print(String.format("%-3d", number));
    }

    public static void main(String[] args) {
        testN(1, 1);
        testN(2, 1);
        testN(1, 2);
        testN(3, 3);
        testN(5, 5);
    }

    private static void testN(int rows, int columns) {
        int[][] matrix = newMatrix(rows, columns);
        System.out.println("Matrix: ");
        printOutMatrix(matrix);
        System.out.println("Clockwise printing: ");
        printOutMatrixClockwise(matrix);
        System.out.println();
    }

    private static int[][] newMatrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException();
        }
        int[][] nMatrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                nMatrix[i][j] = (j + 1) + columns * i;
            }
        }
        return nMatrix;
    }

    private static void printOutMatrix(int[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException();
        }
        final int rows = matrix.length;
        final int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(String.format("%-3d", matrix[i][j]));
            }
            System.out.println();
        }
    }

}
