package lesson16;

public class SumAggregator implements Aggregator<Integer, Integer> {
    @Override
    public Integer aggregate(Integer[] items) {
        int sum = 0;

        for (Integer item : items) {
            if (item != null) {
                sum += item;
            }
        }
        return sum;
    }
}
