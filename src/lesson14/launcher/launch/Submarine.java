package lesson14.launcher.launch;

import lesson14.launcher.Coordinates;
import lesson14.launcher.Rocket;

import java.util.Date;

public final class Submarine implements MobileLaunchPlatform {

    private Coordinates location;

    public Submarine(Coordinates location) {
        this.location = location;
    }

    @Override
    public void move(Coordinates location) {
        this.location = location;
    }


    @Override
    public Launch launch(Rocket rocket) {
        Date date = new Date();
        Launch launch =  new Launch(location, rocket, new Date());

        System.out.println(rocket.getWarhead() +
                " rocket has been launched from the submarine at {" +
                location.getLatitude() + ", " +
                location.getLongitude() + "} at " +
                launch.getDate() + ", targeting coordinates {" +
                rocket.getTarget().getLatitude() + ", "  +
                rocket.getTarget().getLongitude() + "}"
        );
        return launch;
    }
}
