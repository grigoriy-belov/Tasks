package lesson14.launcher;

import java.util.Objects;

public final class Coordinates {

    private final double latitude;

    private final double longitude;

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates coordinates = (Coordinates) o;
        return Double.compare(coordinates.latitude, latitude) == 0 &&
                Double.compare(coordinates.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public String toString() {
        return "Target{" +
                "lattitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
