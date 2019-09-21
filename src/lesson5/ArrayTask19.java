package lesson5;

public class ArrayTask19 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 12, 16, 34, 32};

        for (int i : arr) {
            if (i > 0 & (i & (i - 1)) == 0)
                System.out.println(i);
        }
    }
}
