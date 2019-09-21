package lesson5;

import java.util.Arrays;

public class ArrayTask90 {
    public static void main(String[] args) {
        int n = 6;
        int[][] matrix = new int[6][6];

        int count = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    matrix[i][j] = i + 1;
                } else if (i + j == matrix.length - 1) {
                    matrix[i][j] = count--;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
