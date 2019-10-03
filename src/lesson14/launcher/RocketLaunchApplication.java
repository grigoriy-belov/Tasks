package lesson14.launcher;

import lesson14.launcher.launch.Launch;
import lesson14.launcher.launch.LaunchPlatform;
import lesson14.launcher.launch.Silo;
import lesson14.launcher.launch.Submarine;
import lesson14.launcher.storage.RocketStorage;
import lesson14.launcher.storage.UndergroundRocketStorage;

import java.util.Optional;
import java.util.Scanner;

public class RocketLaunchApplication {
    public static void main(String[] args) {

//        Coordinates bellfast = new Coordinates(-5.93936, 54.66682);

//        Rocket bellfastNuke = new Rocket(Warhead.NUCLEAR, bellfast);

        Rocket[] rockets = new Rocket[] {new Rocket(Warhead.NUCLEAR, new Coordinates(-5.93936, 54.66682)),
                new Rocket(Warhead.CONVENTIONAL, new Coordinates(32.1234, 52.2356)),
                new Rocket(Warhead.NUCLEAR, new Coordinates(12.1245, 32.4235))};

        RocketStorage storage = new UndergroundRocketStorage(rockets);

        Scanner scanner = new Scanner(System.in);

        int rocketIndex;
        while (true) {
            System.out.println("Choose rocket index from 0 to " + (rockets.length - 1));

            rocketIndex = scanner.nextInt();

            if (rocketIndex < 0 || rocketIndex >= rockets.length) {
                System.out.println("There is no such rocket index.");
            } else {
                break;
            }
        }

        System.out.println("Choose launch platform: (1 - Silo, 2 - Submarine)");
        int platformCode = scanner.nextInt();

        OptionalRocket r0 = storage.tryToGet(rocketIndex);

        LaunchPlatform site000 = null;
        switch (platformCode) {
            case 1:
                site000 = new Silo(new Coordinates(0.0, 0.0));
            case 2:
                site000 = new Submarine(new Coordinates(0.0, 0.0));
        }


        if (r0.isPresent()) {
            Rocket rocket = r0.get();
            Launch launch = site000.launch(rocket);
            System.out.println("Verifying launch: " + launch);
        }
    }
}
