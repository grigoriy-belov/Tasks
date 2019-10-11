package service.impl;

import model.DayOfWeek;
import model.Month;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LeapYearDateServiceTest {
    LeapYearDateService defaultService;

    @BeforeEach
    void setUp() {
        defaultService = new LeapYearDateService(DayOfWeek.MON);
    }

    @Test
    void upperThresholdIs366() {
        assertEquals(366, defaultService.getUpperThreshold());
    }

    @Test
    void monthLengthShouldReturnValueForNonLeapYear() {
        assertEquals(31, defaultService.getMonthLength(Month.JAN));
        assertEquals(29, defaultService.getMonthLength(Month.FEB));
        assertEquals(31, defaultService.getMonthLength(Month.MAR));
        assertEquals(30, defaultService.getMonthLength(Month.APR));
        assertEquals(31, defaultService.getMonthLength(Month.MAY));
        assertEquals(30, defaultService.getMonthLength(Month.JUN));
        assertEquals(31, defaultService.getMonthLength(Month.JUL));
        assertEquals(31, defaultService.getMonthLength(Month.AUG));
        assertEquals(30, defaultService.getMonthLength(Month.SEP));
        assertEquals(31, defaultService.getMonthLength(Month.OCT));
        assertEquals(30, defaultService.getMonthLength(Month.NOV));
        assertEquals(31, defaultService.getMonthLength(Month.DEC));
    }

    @Test
    void whenDayNumberLessThanOrEqualsZero_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> defaultService.getDateOfYear(0));
        assertThrows(IllegalArgumentException.class, () -> defaultService.getDateOfYear(-1));
    }

    @Test
    void whenGraterThan366_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> defaultService.getDateOfYear(367));
        assertThrows(IllegalArgumentException.class, () -> defaultService.getDateOfYear(368));
    }

    @Test
    void the60thDayShouldBeFebruary29th() {
        assertEquals(Month.FEB, defaultService.getDateOfYear(60).getMonth());
        assertEquals(29, defaultService.getDateOfYear(60).getDayOfMonth());
    }

    @Test
    void the366thDayShouldBeDecember31() {
        assertEquals(Month.DEC, defaultService.getDateOfYear(366).getMonth());
        assertEquals(31, defaultService.getDateOfYear(366).getDayOfMonth());
    }

    @Test
    void checkWeekBoundaries() {
        for (int i = 8; i <= defaultService.getUpperThreshold(); i++) {
            if (i % 7 == 1) {
                for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                    LeapYearDateService dateService = new LeapYearDateService(dayOfWeek);
                    assertEquals(dateService.getDateOfYear(1).getDayOfWeek(), dateService.getDateOfYear(i).getDayOfWeek());
                }
            }
        }
    }

    @Test
    void checkMonthBoundaries() {
        int counter = 0;
        for (Month month : Month.values()) {
            counter += month.getNumberOfDays(false);
            assertEquals(month, defaultService.getDateOfYear(counter).getMonth());
        }
    }
}



