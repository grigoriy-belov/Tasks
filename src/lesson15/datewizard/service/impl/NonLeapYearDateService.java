package lesson15.datewizard.service.impl;

import lesson15.datewizard.model.DateOfYear;
import lesson15.datewizard.model.DayOfWeek;
import lesson15.datewizard.model.Month;
import lesson15.datewizard.service.DateService;

public class NonLeapYearDateService implements DateService {

    private final DayOfWeek januaryFirst;

    public NonLeapYearDateService(DayOfWeek januaryFirst) {
        this.januaryFirst = januaryFirst;
    }

    @Override
    public DateOfYear getDateOfYear(int dayNumber) {
        if (dayNumber <= 0 || dayNumber > 356) {
            throw new IllegalArgumentException("Day's number expected to be in range [1, 365]. Got: " + dayNumber);
        }
        int counter = 0;
        int month = 1;
        int daysInMonth = Month.JAN.getNumberOfDays();

        Month[] months = Month.values();

        while (counter + daysInMonth < dayNumber) {
            counter += daysInMonth;
            month++;
            daysInMonth = months[month].getNumberOfDays();
        }

        Month calculatedMonth = months[month];

        int dateInMonth = dayNumber - counter;

        int weekDay = dayNumber % 7 + januaryFirst.ordinal();

        String weekDayName = null;

        if (weekDay == 0) {
            weekDay = 7;
        }

        DayOfWeek dayOfWeek = DayOfWeek.values()[weekDay - 1];

        return new DateOfYear(calculatedMonth, dayOfWeek, dateInMonth);
    }
}
