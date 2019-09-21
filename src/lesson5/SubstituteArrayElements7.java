package lesson5;

import java.util.Arrays;

public class SubstituteArrayElements7 {
    public static void main(String[] args) {
        double[] arr = {1.1, 2.3, 4.5, 6.6, 7.8};

        double z = 3.0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > z) {
                arr[i] = z;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
