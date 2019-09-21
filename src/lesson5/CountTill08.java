package lesson5;

import java.util.Arrays;
import java.util.List;

public class CountTill08 {
    public static void main(String[] args) {
        double[] arr = {1, 2, 3, 4, 0, 6, 7};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
