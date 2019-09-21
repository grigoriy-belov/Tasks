package lesson5;

import java.util.Arrays;

public class ZeroArray2 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 0, 4, 0, 5, 0};

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        int[] arr2 = new int[count];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr2[j] = i;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
}
