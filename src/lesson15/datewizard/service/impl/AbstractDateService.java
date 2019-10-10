package lesson15.datewizard.service.impl;

import lesson15.datewizard.model.DateOfYear;
import lesson15.datewizard.model.DayOfWeek;
import lesson15.datewizard.model.Month;
import lesson15.datewizard.service.DateService;

abstract class AbstractDateService implements DateService {

    private final DayOfWeek januaryFirst;

    AbstractDateService(DayOfWeek januaryFirst) {
        this.januaryFirst = januaryFirst;
    }

    @Override
    public DateOfYear getDateOfYear(int dayNumber) {
        int upperThreshold = getUpperThreshold();
        if (dayNumber <= 0 || dayNumber > upperThreshold) {
            throw new IllegalArgumentException("Day's number expected to be in range [1, " +
                    upperThreshold + "]. Got: " + dayNumber);
        }
        int counter = 0;
        int month = 0;
        int daysInMonth = getMonthLength(Month.JAN);
        Month[] months = Month.values();

        while (counter + daysInMonth < dayNumber) {
            counter += daysInMonth;
            month++;
            daysInMonth = getMonthLength(months[month]);
        }

        Month calculatedMonth = months[month];

        int dateInMonth = dayNumber - counter;

        int weekDay = (januaryFirst.ordinal() + dayNumber) % 7;

        if (weekDay == 0) {
            weekDay = 7;
        }

        DayOfWeek dayOfWeek = DayOfWeek.values()[weekDay - 1];

        return new DateOfYear(dateInMonth, calculatedMonth, dayOfWeek);
    }

    abstract int getUpperThreshold();

    abstract int getMonthLength(Month month);
}
