package lesson15.datewizard;

import lesson15.datewizard.model.DateOfYear;
import lesson15.datewizard.model.DayOfWeek;
import lesson15.datewizard.service.DateService;
import lesson15.datewizard.service.DateServiceFactory;

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

    private static void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter year");

        int year = scanner.nextInt();

        System.out.println("Please, enter day of week for Jan 1");
        for (DayOfWeek value : DayOfWeek.values()) {
            System.out.println(value.ordinal() + ": " + value.getDisplayName());
        }
        DayOfWeek januaryFirst = DayOfWeek.values()[scanner.nextInt()];

        DateService dateService = DateServiceFactory.forYear(year, januaryFirst);

        System.out.println("Please, enter the number of a day");

        int day = scanner.nextInt();

        scanner.close();

        DateOfYear dateOfYear = dateService.getDateOfYear(day);

        System.out.println("This day is: " +
                dateOfYear.getDayOfWeek().getDisplayName() + ", " +
                dateOfYear.getMonth().getDisplayName() + " " +
                dateOfYear.getDayOfMonth());
    }
}
