package lesson15.datewizard.service;

import lesson15.datewizard.model.DayOfWeek;
import lesson15.datewizard.service.impl.LeapYearDateService;
import lesson15.datewizard.service.impl.NonLeapYearDateService;

public final class DateServiceFactory {
    private DateServiceFactory() {
    }

    public static DateService forYear(int year, DayOfWeek januaryFirst) {

        boolean leap = (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);

        DateService instance;

        if (leap) {
            instance = new LeapYearDateService(januaryFirst);
        } else {
            instance = new NonLeapYearDateService(januaryFirst);
        }

        return instance;
    }
}
