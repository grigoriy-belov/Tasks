package lesson5;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {13, 16, 9, 15, 7, 11, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr) {
        for (int inc = arr.length / 2; inc >= 1; inc = inc / 2) {
            for (int step = 0; step < inc; step++) {
                insertionSort (arr, step, inc);
            }
        }
    }
    private static void insertionSort (int[] arr, int start, int inc) {
        int tmp;
        for (int i = start; i < arr.length - 1; i += inc) {
            for (int j = Math.min(i + inc, arr.length - 1); j - inc >= 0; j = j - inc)
                if (arr[j - inc] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[j - inc];
                    arr[j - inc] = tmp;
                } else break;
        }
    }
}


