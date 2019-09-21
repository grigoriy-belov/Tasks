package lesson5;

import java.util.Arrays;

public class IsAscendedOrder4 {
    public static void main(String[] args) {
        double[] arr = {2.2, 6.6, 4.4, 5.6};
        double[] arr2 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr2);
        if (Arrays.equals(arr, arr2)) {
            System.out.println("Is ascended");
        } else {
            System.out.println("Is not ascended");
        }
    }
}
