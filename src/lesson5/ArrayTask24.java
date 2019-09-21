package lesson5;

import java.util.Arrays;

public class ArrayTask24 {
    public static void main(String[] args) {
        // Даны действительные числа a1, a2, ..., аn. Среди них есть положительные и отрицательные. Заменить
        //нулями те числа, величина которых по модулю больше максимального числа (|ai| > max{a1, a2, ..., аn}).
        double[] arr = {2.4, -1.3, 0.3, -5.7, -9.0, -3.7};
        double max = Double.MIN_VALUE;

        for (double d : arr) {
            max = Math.max(d, max);
        }

        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > max) {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
