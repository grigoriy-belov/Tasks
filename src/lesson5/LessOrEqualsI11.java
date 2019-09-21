package lesson5;

public class LessOrEqualsI11 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 6, 7, 9, 3, 4};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= i) {
                System.out.println(arr[i]);
            }
        }
    }
}
