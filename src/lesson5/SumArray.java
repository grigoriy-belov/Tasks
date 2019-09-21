package lesson5;

import java.util.Scanner;

public class SumArray {
    public static void main(String[] args) {
        int[] arr = {10, 55, 17, 9, 13, 14};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int k = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % k == 0) {
                sum += arr[i];
            }
        }
        System.out.println("Sum is: " + sum);
    }
}
