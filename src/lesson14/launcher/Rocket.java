package lesson14.launcher;

import java.util.Objects;

public final class Rocket {

    private final Warhead warhead;

    private final Coordinates coordinates;

    public Rocket(Warhead warhead, Coordinates coordinates) {
        this.warhead = warhead;
        this.coordinates = coordinates;
    }

    public Warhead getWarhead() {
        return warhead;
    }

    public Coordinates getTarget() {
        return coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rocket rocket = (Rocket) o;
        return warhead == rocket.warhead &&
                Objects.equals(coordinates, rocket.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warhead, coordinates);
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "warhead=" + warhead +
                ", target=" + coordinates +
                '}';
    }
}
