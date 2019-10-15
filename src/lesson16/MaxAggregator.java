package lesson16;

public class MaxAggregator<T extends Comparable<T>> implements Aggregator<T, T> {

    @Override
    public  T aggregate(T[] items) {
        if (items == null || items.length == 0) {
            return null;
        }
        T max = items[0];

        for (int i = 1; i < items.length; i++) {
            if (max.compareTo(items[i]) < 0) {
                max = items[i];
            }
        }
        return max;
    }
}
