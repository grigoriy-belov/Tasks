package lesson4;

import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = {13, 16, 9, 15, 9, 11, 5};
//        bubbleSort(arr);
//        insertionSort(arr);
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                int k = j + 1;
                if (arr[j] > arr[k]) {
                    arr[j] = arr[j] ^ arr[k];
                    arr[k] = arr[j] ^ arr[k];
                    arr[j] = arr[j] ^ arr[k];
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
}
