package lesson5;

import java.util.Arrays;

public class ArrayTask30 {
    //30. Дана последовательность целых чисел a1
    //, a2
    //, ..., аn
    //. Образовать новую последовательность, выбросив
    //
    //из исходной те члены, которые равны min(a1
    //, a2
    //, ..., аn
    //).
    public static void main(String[] args) {
        int[] arr = {3, 9, 3, 5, 6, 7, 3, 8, 9, 3, 10, 3};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr2);
        int min = arr2[0];

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) count++;
        }
        int[] result = new int[arr.length-count];

        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) count++;
            else result[i-count] = arr[i];
        }

        System.out.println(Arrays.toString(result));
    }
}
