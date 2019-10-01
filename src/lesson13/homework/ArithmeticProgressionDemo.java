package lesson13.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticProgressionDemo {
    public static void main(String[] args) {
        int result = 0;
        int n = 0;
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);

        while (!flag) {
            try {
                System.out.println("Enter initial value");
                int initial = scanner.nextInt();

                System.out.println("Enter step of the arithmetic progression");
                int step = scanner.nextInt();

                System.out.println("Enter the number of element of the progression to calculate");
                n = scanner.nextInt();
                ArithmeticProgression arithmeticProgression = new ArithmeticProgression(initial, step);
                result = arithmeticProgression.calculate(n);
                flag = true;

            } catch (ProgressionConfigurationException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The " + n + " element of arithmetic progression is " + result);
    }
}
