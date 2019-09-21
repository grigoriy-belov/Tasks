package lesson5;

import java.util.Arrays;

public class ArrayTask28 {
    public static void main(String[] args) {
        //28. Дана последовательность действительных чисел a1 ≤ a2 ≤ ... ≤ аn
        //
        //. Вставить действительное число b в
        //
        //нее так, чтобы последовательность осталась неубывающей.

        double[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        double[] arr2 = new double[arr.length+1];
        double b = 4;
        boolean isInsert = false;

        for (int i = 0; i < arr.length; i++) {
            if (isInsert) {
                arr2[i+1] = arr[i];
            } else if (arr[i] >= b) {
                arr2[i] = b;
                arr2[i+1] = arr[i];
                isInsert = true;
            } else {
                arr2[i] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
}
