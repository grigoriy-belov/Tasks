package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        String userChoice = "";
        try {
            System.out.println("Enter integer number: ");
            number = Integer.parseInt(br.readLine());
            System.out.println("To parse number from left to right enter 's', otherwise enter 'e'.");
            userChoice = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (userChoice) {
            case "s":
                getFizzBuzzFromStart(number);
                break;
            case "e":
                getFizzBuzzFromEnd(number);
                break;
        }
    }

    public static void getFizzBuzzFromEnd(int number) {
        while (number > 0) {
            System.out.println(getOutput(number % 10));
            number /= 10;
        }
    }

    public static void getFizzBuzzFromStart(int number) {
        int divider = 1_000_000_000;

        while (number > 0) {
            if (number / divider < 1) {
                divider /= 10;
                continue;
            }
            System.out.println(getOutput(number / divider));
            number %= divider;
            divider /= 10;
        }
    }

    public static String getOutput(int digit) {
        StringBuilder sb = new StringBuilder();

        if (digit % 2 == 0) {
            sb.append("fizz");
        }
        if (digit % 3 == 0) {
            sb.append("buzz");
        }
        return sb.toString();
    }
}
