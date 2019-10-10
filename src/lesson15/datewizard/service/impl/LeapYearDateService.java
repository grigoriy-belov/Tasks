package lesson15.datewizard.service.impl;

import lesson15.datewizard.model.DayOfWeek;
import lesson15.datewizard.model.Month;

public class LeapYearDateService extends AbstractDateService {

    public LeapYearDateService(DayOfWeek januaryFirst) {
        super(januaryFirst);
    }

    @Override
    int getUpperThreshold() {
        return 366;
    }

    @Override
    int getMonthLength(Month month) {
        return month.getNumberOfDays(true);
    }
}

