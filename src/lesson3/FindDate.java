package lesson3;

import java.util.Scanner;

public class FindDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of day in year:");
        int numberOfDay = scanner.nextInt();

        int dayOfWeekNumber = numberOfDay % 7;
        String dayOfWeek = "";

        switch (dayOfWeekNumber) {
            case 1:
                dayOfWeek = "Monday";
                break;
            case 2:
                dayOfWeek = "Tuesday";
                break;
            case 3:
                dayOfWeek = "Wednesday";
                break;
            case 4:
                dayOfWeek = "Thursday";
                break;
            case 5:
                dayOfWeek = "Friday";
                break;
            case 6:
                dayOfWeek = "Saturday";
                break;
            case 0:
                dayOfWeek = "Sunday";
                break;
        }

        int counter = 0;
        int i = 1;
        int dayOfMonth = 0;
        while (counter < numberOfDay) {
            dayOfMonth = numberOfDay - counter;
            if (i == 2) {
                counter += 28;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                counter += 30;
            } else {
                counter += 31;
            }
            i++;
        }
        int month = i-1;

        System.out.println("Month: " + month);
        System.out.println("Day of month: " + dayOfMonth);
        System.out.println("Day of Week: " + dayOfWeek);
    }
}
