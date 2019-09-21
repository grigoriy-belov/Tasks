package lesson5;

public class DivisionRemainder12 {
    public static void main(String[] args) {
        int[] arr = {12, 33, 4, 17, 55, 47, 84, 95};

        int m = 4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % m > 0 && arr[i] % m >= m - 1) {
                System.out.println(arr[i]);
            }
        }
    }
}
