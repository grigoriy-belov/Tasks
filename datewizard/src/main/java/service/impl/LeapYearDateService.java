package service.impl;

import model.DayOfWeek;
import model.Month;

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

