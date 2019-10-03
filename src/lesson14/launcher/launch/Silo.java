package lesson14.launcher.launch;

import lesson14.launcher.Coordinates;
import lesson14.launcher.Rocket;

import java.util.Date;

public final class Silo implements LaunchPlatform {

    private final Coordinates location;

    public Silo(Coordinates location) {
        this.location = location;
    }

    @Override
    public Launch launch(Rocket rocket) {
        Launch launch =  new Launch(location, rocket, new Date());

        System.out.println(rocket.getWarhead() +
                " rocket has been launched from the silo at {" +
                location.getLatitude() + ", " +
                location.getLongitude() + "} at " +
                launch.getDate() + ", targeting coordinates {" +
                rocket.getTarget().getLatitude() + ", "  +
                rocket.getTarget().getLongitude() + "}"
        );
        return launch;
    }
}
