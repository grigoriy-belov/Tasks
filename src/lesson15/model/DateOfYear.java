package lesson15.model;

import java.util.Objects;

public final class DateOfYear {

    private final Month month;

    private final DayOfWeek dayOfWeek;

    private final int dayOfMonth;

    public DateOfYear(Month month, DayOfWeek dayOfWeek, int dayOfMonth) {
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.dayOfMonth = dayOfMonth;
    }

    public Month getMonth() {
        return month;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateOfYear that = (DateOfYear) o;
        return dayOfMonth == that.dayOfMonth &&
                month == that.month &&
                dayOfWeek == that.dayOfWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, dayOfWeek, dayOfMonth);
    }

    @Override
    public String toString() {
        return "DateOfYear{" +
                "month=" + month +
                ", dayOfWeek=" + dayOfWeek +
                ", dayOfMonth=" + dayOfMonth +
                '}';
    }
}
