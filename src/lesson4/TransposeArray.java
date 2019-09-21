package lesson4;

import java.util.Arrays;

public class TransposeArray {
    public static void main(String[] args) {
        int[][] arr = {
                    {0, 1, 2, 3},
                    {4, 5, 6},
                    {8, 7}
            };

        int [][] matrix = transposeRectangularMatrix(arr);

        printMatrix(matrix);
    }

    public static void transposeSquareMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static int[][] transposeRectangularMatrix(int[][] matrix) {
        int[][] theMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                theMatrix[j][i] = matrix[i][j];
            }
        }
        return theMatrix;
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
