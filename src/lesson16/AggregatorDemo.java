package lesson16;

public class AggregatorDemo {
    public static void main(String[] args) {
        CountAggregator<Integer> countAggregator = new CountAggregator<>();
        System.out.println(countAggregator.aggregate(new Integer[] {1, 2, 3, 4}));

        SumAggregator sumAggregator = new SumAggregator();
        System.out.println(sumAggregator.aggregate(new Integer[] {1, 2, 3, 4}));
    }
}
