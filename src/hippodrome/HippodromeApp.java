package hippodrome;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HippodromeApp {
    private static final int DISTANCE = 1000;

    public static void main(String[] args) throws InterruptedException {

        List<Horse> horses = new ArrayList<>();
        Hippodrome hippodrome = new Hippodrome(DISTANCE);

        horses.add(new Horse(hippodrome,"Spirit"));
        horses.add(new Horse(hippodrome,"Daisy"));
        horses.add(new Horse(hippodrome,"Sugar"));

        System.out.println("Enter the number of horse you want to bet on:");
        for (int i = 0; i < horses.size(); i++) {
            System.out.println(i + 1 + ". " + horses.get(i).getName());
        }

        Scanner scanner = new Scanner(System.in);
        int bet = scanner.nextInt();
        while (bet <= 0 || bet > horses.size()) {
            System.out.println("There is no horse with such number. Choose another one.");
            bet = scanner.nextInt();
        }
        Horse chosen = horses.get(bet - 1);
        System.out.println("You have chosen " + chosen.getName());

        ExecutorService executorService = Executors.newFixedThreadPool(horses.size());

        for (Horse horse : horses) {
            executorService.execute(horse);
        }
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        for (Horse horse : hippodrome.getRaceResults()) {
            System.out.println(horse.getName());
        }

        List<Horse> raceResults = hippodrome.getRaceResults();

        System.out.println("Horse you bet on got place " + (raceResults.indexOf(chosen) + 1)
            + " out of " + raceResults.size());
    }
}
