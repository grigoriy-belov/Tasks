package lesson5;

public class ArrayTask55 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 13, 12, 4, 6, 8, 47};

        for (int i = 0; i < arr.length; i++) {
            if(isPrimeNumber(arr[i])) System.out.println(i);
        }
    }

    public static boolean isPrimeNumber(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
