package lesson5;

import java.util.Arrays;

public class SwapMinMax {
    public static void main(String[] args) {
        double[] arr = {1.1, 2.9, 5.5, 9.9};

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        double tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max){
                arr[i] = min;
            } else if (arr[i] == min) {
                arr[i] = max;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
