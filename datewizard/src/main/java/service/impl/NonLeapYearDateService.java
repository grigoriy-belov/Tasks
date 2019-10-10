package service.impl;


import model.DayOfWeek;
import model.Month;

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
