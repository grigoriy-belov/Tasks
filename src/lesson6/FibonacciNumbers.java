package lesson6;

import java.util.Arrays;

public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(areFibNumbers(1, 2, 3, 21));
    }

    public static boolean areFibNumbers(int... numbers) {
        if  (numbers.length == 0) {
            return false;
        }
        for (int i : numbers) {
            if (!isFibonacci(i)) return false;
        }
        return true;
    }

    private static boolean isFibonacci(int n) {
        return isPerfectSquare(5*n*n + 4) ||
                isPerfectSquare(5*n*n - 4);
    }

    private static boolean isPerfectSquare(int x) {
        int sqrt = (int) Math.sqrt(x);
        return x == sqrt * sqrt;
    }
}
