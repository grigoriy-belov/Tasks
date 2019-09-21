package lesson5;

import java.util.Arrays;

public class ArrayTask80 {
    public static void main(String[] args) {
        int n = 4;
        int[][] arr = new int[n][n];

        int count = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = count;
                count--;
            }
            count = n;
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
