package lesson14.launcher;

import lesson14.launcher.launch.Launch;
import lesson14.launcher.launch.LaunchPlatform;
import lesson14.launcher.launch.Silo;
import lesson14.launcher.storage.RocketStorage;
import lesson14.launcher.storage.UndergroundRocketStorage;

import java.util.Optional;

public class RocketLaunchApplication {
    public static void main(String[] args) {

        Coordinates bellfast = new Coordinates(-5.93936, 54.66682);

        Rocket bellfastNuke = new Rocket(Warhead.NUCLEAR, bellfast);

        RocketStorage storage = new UndergroundRocketStorage(bellfastNuke);

        Optional<Rocket> r0 = storage.tryToGet(0);

        LaunchPlatform site000 = new Silo(new Coordinates(0.0, 0.0));

        if (r0.isPresent()) {
            Rocket rocket = r0.get();
            Launch launch = site000.launch(rocket);
            System.out.println("Verifying launch: " + launch);
        }
    }
}
