package lesson5;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {13, 16, 9, 15, 9, 11, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int k = j + 1;
                if (array[j] > array[k]) {
                    //swap
                    array[j] = array[j] ^ array[k];
                    array[k] = array[j] ^ array[k];
                    array[j] = array[j] ^ array[k];
                }
            }
        }
    }
}
