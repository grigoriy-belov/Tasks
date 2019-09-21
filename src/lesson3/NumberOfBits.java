package lesson3;

import java.util.Scanner;

public class NumberOfBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter long value:");
        long value = scanner.nextLong();
        
        int counter = 0;

        while (value != 0) {
            counter += value & 1;
            value >>>= 1;
        }

        System.out.println(counter);
    }
}
