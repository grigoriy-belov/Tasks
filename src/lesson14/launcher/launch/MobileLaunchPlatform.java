package lesson14.launcher.launch;

import lesson14.launcher.Coordinates;

public interface MobileLaunchPlatform extends LaunchPlatform {

    void move(Coordinates location);
}
