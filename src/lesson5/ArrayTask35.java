package lesson5;

import java.util.Arrays;

public class ArrayTask35 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 11, 13, 15, 16};

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr = Arrays.copyOfRange(arr, 0, arr.length-1);
        }
        System.out.println(Arrays.toString(arr));
    }
}
