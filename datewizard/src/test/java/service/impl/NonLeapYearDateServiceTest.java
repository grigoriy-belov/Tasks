package service.impl;

import model.DayOfWeek;
import model.Month;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NonLeapYearDateServiceTest {
    NonLeapYearDateService defaultService;

    @BeforeEach
    void setUp() {
        defaultService = new NonLeapYearDateService(DayOfWeek.MON);
    }

    @Test
    void upperThresholdIs365() {
        assertEquals(365, defaultService.getUpperThreshold());
    }

    @Test
    void monthLengthShouldReturnValueForNonLeapYear() {
        assertEquals(31, defaultService.getMonthLength(Month.JAN));
        assertEquals(28, defaultService.getMonthLength(Month.FEB));
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
//   another option
//
//        try {
//            defaultService.getDateOfYear(0);
//             fail("Exception expected");
//        } catch (Exception e) {
//            assertTrue(e instanceof IllegalArgumentException);
//        }
    }

    @Test
    void whenGraterThan365_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> defaultService.getDateOfYear(366));
        assertThrows(IllegalArgumentException.class, () -> defaultService.getDateOfYear(367));
    }

    @Test
    void the60thDayShouldBeMarch1st() {
        assertEquals(Month.MAR, defaultService.getDateOfYear(60).getMonth());
        assertEquals(1, defaultService.getDateOfYear(60).getDayOfMonth());
    }

    @Test
    void the365thDayShouldBeDecember31() {
        assertEquals(Month.DEC, defaultService.getDateOfYear(365).getMonth());
        assertEquals(31, defaultService.getDateOfYear(365).getDayOfMonth());
    }

    @Test
    void checkWeekBoundaries() {
        for (int i = 8; i <= defaultService.getUpperThreshold(); i++) {
            if (i % 7 == 1) {
                for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                    NonLeapYearDateService dateService = new NonLeapYearDateService(dayOfWeek);
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