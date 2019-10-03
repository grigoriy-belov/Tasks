package lesson14.launcher;

import lesson14.launcher.storage.RocketNotFoundException;

import java.util.NoSuchElementException;

public class OptionalRocket {

    private final Rocket value;

    public OptionalRocket(Rocket value) {
        this.value = value;
    }

    public Rocket get() {
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    public boolean isPresent() {
        return value != null;
    }
}
