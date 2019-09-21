package lesson5;

public class PrintNumbersTillZero15 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 4};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) break;
            System.out.println(arr[i]);
        }

    }
}
