package lesson5;

import java.util.Arrays;

public class ArrayOfEven5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }

        int[] arr2 = new int[count];

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr2[j] = arr[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
}
