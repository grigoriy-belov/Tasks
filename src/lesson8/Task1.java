package lesson8;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 1, 1, 3, 7, 8, 9};

        Arrays.sort(arr);

        int counter = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i+1]) counter++;
        }

        System.out.println("Number of distinct elements of the array: " + counter);
    }
}
