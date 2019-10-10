package lesson15.datewizard.service.impl;

import lesson15.datewizard.model.DayOfWeek;
import lesson15.datewizard.model.Month;

public class NonLeapYearDateService extends AbstractDateService {

    public NonLeapYearDateService(DayOfWeek januaryFirst) {
        super(januaryFirst);
    }

    @Override
    int getUpperThreshold() {
        return 365;
    }

    @Override
    int getMonthLength(Month month) {
        return month.getNumberOfDays(false);
    }
}
