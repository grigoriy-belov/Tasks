package service.impl;

import model.DayOfWeek;
import model.Month;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonLeapYearDateServiceTest {
    NonLeapYearDateService defaultService;

    @BeforeEach
    void setUp() {
        defaultService = new NonLeapYearDateService(DayOfWeek.TUE);
    }

    @Test
    void upperThresholdIs365() {

        assertEquals(365, defaultService.getUpperThreshold());
    }

    @Test
    void monthLengthShouldReturnValueForNonLeapYear() {
        assertEquals(28, defaultService.getMonthLength(Month.JAN));
        assertEquals(28, defaultService.getMonthLength(Month.FEB));
        assertEquals(28, defaultService.getMonthLength(Month.MAR));
        assertEquals(28, defaultService.getMonthLength(Month.APR));
        assertEquals(28, defaultService.getMonthLength(Month.MAY));
        assertEquals(28, defaultService.getMonthLength(Month.JUN));
        assertEquals(28, defaultService.getMonthLength(Month.JUL));
        assertEquals(28, defaultService.getMonthLength(Month.AUG));
        assertEquals(28, defaultService.getMonthLength(Month.SEP));
        assertEquals(28, defaultService.getMonthLength(Month.OCT));
        assertEquals(28, defaultService.getMonthLength(Month.NOV));
        assertEquals(28, defaultService.getMonthLength(Month.DEC));

    }

    @Test
    void whenDayNumberLessThanZero_shouldThrowException() {
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

}