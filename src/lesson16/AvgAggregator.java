package lesson16;

public class AvgAggregator implements Aggregator<Double, Integer> {

    @Override
    public Double aggregate(Integer[] items) {
        if (items == null) {
            throw new IllegalArgumentException("Can't aggregate null");
        }
        int length = items.length;
        if (length == 0) {
            throw new IllegalArgumentException("Empty array has no average value");
        }
        double sum = 0;
        for (Number item : items) {
            if (item != null) {
                sum += item.doubleValue();
            }
        }
        return sum / length;
    }
}
