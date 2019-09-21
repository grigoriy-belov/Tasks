package lesson5;

import java.util.Arrays;

public class SwapOddEvenPositions13 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        for (int i = 0; i < arr.length - 1; i += 2) {
            arr[i] = arr[i] ^ arr[i+1];
            arr[i+1] = arr[i] ^ arr[i+1];
            arr[i] = arr[i] ^ arr[i+1];
        }
        System.out.println(Arrays.toString(arr));
    }
}
