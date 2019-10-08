package lesson15.datewizard.service.impl;

import lesson15.datewizard.model.DateOfYear;
import lesson15.datewizard.model.DayOfWeek;
import lesson15.datewizard.model.Month;
import lesson15.datewizard.service.DateService;

public class LeapYearDateService extends AbstractDateService {


    public LeapYearDateService(DayOfWeek januaryFirst) {
        super(januaryFirst);
    }

    @Override
    public DateOfYear getDateOfYear(int dayNumber) {

    }

    @Override
    int getUpperThreshold() {
        return 0;
    }

    @Override
    int getMonthLength(Month month) {
        return 0;
    }
}
}
