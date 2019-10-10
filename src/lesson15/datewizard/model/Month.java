package lesson15.datewizard.model;

public enum Month {
    JAN("January", 31),
    FEB("February", 28, 29),
    MAR("March", 31),
    APR("April", 30),
    MAY("May", 31),
    JUN("June", 30),
    JUL("July", 31),
    AUG("August", 31),
    SEP("September", 30),
    OCT("October", 31),
    NOV("November", 30),
    DEC("December", 31);

    private final String displayName;

    private final int numberOfDays;

    private final int numberOfDaysLeapYear;


    Month(String displayName, int numberOfDays) {
        this.displayName = displayName;
        this.numberOfDays = numberOfDays;
        this.numberOfDaysLeapYear = numberOfDays;
    }

    Month(String displayName, int numberOfDays, int numberOfDaysLeapYear) {
        this.displayName = displayName;
        this.numberOfDays = numberOfDays;
        this.numberOfDaysLeapYear = numberOfDaysLeapYear;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getNumberOfDays(boolean leapYear) {
        return leapYear ? numberOfDaysLeapYear : numberOfDays;
    }
}
