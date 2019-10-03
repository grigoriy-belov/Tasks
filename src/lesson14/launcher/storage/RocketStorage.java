package lesson14.launcher.storage;


import lesson14.launcher.OptionalRocket;
import lesson14.launcher.Rocket;

import java.util.Optional;

public interface RocketStorage {

    Rocket get(int index) throws RocketNotFoundException;

    OptionalRocket tryToGet(int index);
}
