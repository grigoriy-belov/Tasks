package service.impl;


import model.DateOfYear;
import model.DayOfWeek;
import model.Month;
import service.DateService;

abstract class AbstractDateService implements DateService {

    private final DayOfWeek januaryFirst;

    AbstractDateService(DayOfWeek januaryFirst) {
        this.januaryFirst = januaryFirst;
    }

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
