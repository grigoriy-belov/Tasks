package lesson3;

import java.util.Scanner;

public class Gcd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two integers divided by whitespace:");
        String input = scanner.nextLine();

        String[] numbers = input.split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);

        int GCD = findGCD(a, b);
        int LCM = a * b / GCD;

        System.out.println("GCD: " + GCD);
        System.out.println("LCM: " + LCM);
    }

    public static int findGCD(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;
    }
}
