package lesson11.task2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SubstanceApp {
    public static void main(String[] args) {
        System.out.println("Chose the substance '1' - Water, '2' - Iron, '3' - Oxygen");

        Scanner scanner = new Scanner(System.in);

        int substanceCode = scanner.nextInt();

        Substance substance;

        switch (substanceCode) {
            case 1:
                substance = new Water();
                break;
            case 2:
                substance = new Iron();
                break;
            case 3:
                substance = new Oxygen();
                break;
            default:
                System.err.println("Unknown substance!");
                return;
        }

        double tempChange;
        System.out.println("Enter the temperature change or '0' - to exit the program");

        while ((tempChange = scanner.nextDouble()) != 0) {
            double initialT = substance.getTemperature();
            State state = substance.heatUp(tempChange);

            System.out.println("The temperature of " + substance.getName() + " has changed from "
                    + initialT + " to " + substance.getTemperature());
            System.out.println("The state is " + state);
        }
        System.out.println("Bye!");
    }
}
