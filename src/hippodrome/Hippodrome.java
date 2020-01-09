package hippodrome;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private int distance;
    private List<Horse> raceResults;

    public Hippodrome(int distance) {
        this.distance = distance;
        this.raceResults = new ArrayList<>();
    }

    public int getDistance() {
        return distance;
    }

    public synchronized void setFinisher(Horse horse) {
        System.out.println(horse.getName() + " has finished the race");
        raceResults.add(horse);
    }

    public List<Horse> getRaceResults() {
        return raceResults;
    }
}
