package lesson11.Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Substance substance = null;
        do {
            System.out.println("Chose the substance '0' - Water, '1' - Iron, '2' - Oxygen");
            int numberOfSubstance = scanner.nextInt();

            switch (numberOfSubstance) {
                case 0:
                    substance = new Water();
                    break;
                case 1:
                    substance = new Iron();
                    break;
                case 2:
                    substance = new Oxygen();
                    break;
            }
        } while (substance == null);

        System.out.println("Chosen substance is " + substance.getClass().getSimpleName()
                + ". Initial temperature - " + substance.getTemperature());
        double tempChange = 0;
        while (true) {
            System.out.println("Enter the temperature change or '0' - to exit the program");
            tempChange = scanner.nextDouble();

            if (tempChange == 0) break;

            State state = substance.heatUp(tempChange);
            System.out.println("Now the temperature is: " + substance.getTemperature());
            System.out.println("The state is " + state);
        }
    }
}
