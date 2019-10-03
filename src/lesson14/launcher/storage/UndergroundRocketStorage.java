package lesson14.launcher.storage;

import lesson14.launcher.Rocket;

import java.util.Optional;
import java.util.function.Supplier;

public class UndergroundRocketStorage implements RocketStorage {

    private final Rocket[] rockets;

    public UndergroundRocketStorage(Rocket... rockets) {
        this.rockets = rockets;
    }

    @Override
    public Rocket get(int index) throws RocketNotFoundException {
        return tryToGet(index).orElseThrow(() -> new RocketNotFoundException(index));
    }

    @Override
    public Optional<Rocket> tryToGet(int index) {
        Rocket rocket;
        if (index < 0 || index >= rockets.length) {
            rocket = null;
        } else {
            rocket = rockets[index];
        }
        rockets[index] = null;
        return Optional.ofNullable(rocket);
    }

}
