package lesson5;

import java.util.Arrays;

public class ArrayTask60 {
//    60. Даны два упорядоченные массива А и В. Образовать из элементов этих массивов упорядоченный
//    массив С.
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 8};
        int[] arr2 = {2, 5, 9, 11, 13, 15, 16};
//
        int[] result = Arrays.copyOf(arr, arr.length + arr2.length);
        for (int i = 0, j = arr.length; i < arr2.length; i++, j++) {
            result[j] = arr2[i];
        }
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }
}
