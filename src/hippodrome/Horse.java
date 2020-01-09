package hippodrome;

import java.util.Random;

public class Horse implements Runnable {

    private static final int MIN_SPEED = 60;
    private static final int MAX_SPEED = 100;

    private final Random random = new Random();

    private Hippodrome hippodrome;
    private String name;
    private int passedDistance;

    public Horse(Hippodrome hippodrome, String name) {
        this.hippodrome = hippodrome;
        this.name = name;
    }

    public void move() {
        int move = random.nextInt(MAX_SPEED - MIN_SPEED + 1) + MIN_SPEED;
        if (passedDistance + move > hippodrome.getDistance())
            move = hippodrome.getDistance() - passedDistance;
        passedDistance += move;
        System.out.println(getName() + " ran " + passedDistance + " meters");
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " started the race!");
            while (getPassedDistance() < hippodrome.getDistance()) {
                move();
                Thread.sleep(100);
            }
            hippodrome.setFinisher(this);

        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPassedDistance() {
        return passedDistance;
    }
}
