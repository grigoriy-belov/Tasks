package lesson5;

import java.util.Arrays;

public class NumericalAxis6 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8};
        Arrays.sort(arr);
        int distance = arr[arr.length-1] - arr[0] + 1;

        System.out.println(distance);
    }
}
