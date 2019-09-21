package lesson5;

import java.util.Arrays;

public class ArrayTask81 {
    public static void main(String[] args) {
        int n = 7;
        int[][] arr = new int[n][n];

        int count = 1;
        for (int i = n - 1, j = 0; i >= 0; i--, j++) {
            arr[j][i] = count++;
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
