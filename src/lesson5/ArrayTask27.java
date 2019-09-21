package lesson5;

import java.util.Arrays;

public class ArrayTask27 {
    public static void main(String[] args) {
        // Дан массив действительных чисел, среди них есть равные. Найти первый максимальный элемент массива и замнить его нулем
        double[] arr = {2.4, -1.3, 9.0, -5.7, -9.0, 9.0};

        double max = Double.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                arr[i] = 0;
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
