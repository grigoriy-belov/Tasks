package lesson15.datewizard;

import lesson15.datewizard.model.DateOfYear;
import lesson15.datewizard.model.DayOfWeek;
import lesson15.datewizard.service.DateService;
import lesson15.datewizard.service.impl.NonLeapYearDateService;

import java.io.Console;
import java.util.Scanner;

public class DateWizardApplication {
    public static void main(String[] args) {
        try {
            start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }

    public static void start() {
        DateService year2019 = new NonLeapYearDateService(DayOfWeek.TUE);

        System.out.println("Please, enter the number of a day");
        Scanner scanner = new Scanner(System.in);

        int day = scanner.nextInt();

        scanner.close();
        DateOfYear dateOfYear = year2019.getDateOfYear(day);

        System.out.println("This day is: " + dateOfYear.getDayOfWeek().getDisplayName() + " "
                + dateOfYear.getMonth().getDisplayName() + " "
                + dateOfYear.getDayOfMonth());

        System.out.println(year2019.getDateOfYear(32));
    }
}
