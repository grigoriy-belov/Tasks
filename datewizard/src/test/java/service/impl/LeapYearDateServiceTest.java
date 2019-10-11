package service.impl;

import model.DateOfYear;
import model.DayOfWeek;
import model.Month;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearDateServiceTest {
    LeapYearDateService defaultService;
    private final DayOfWeek initialDayOfWeek = DayOfWeek.FRI;

    @BeforeEach
    void setUp() {
        defaultService = new LeapYearDateService(initialDayOfWeek);
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

//    for days which remainder of the division by 7 is 1, the week day should be equal initial week day
    @Test
    void checkWeekBoundaries() {
        assertEquals(defaultService.getDateOfYear(50).getDayOfWeek(), initialDayOfWeek);
        assertEquals(defaultService.getDateOfYear(183).getDayOfWeek(), initialDayOfWeek);
        assertEquals(defaultService.getDateOfYear(344).getDayOfWeek(), initialDayOfWeek);
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



