package lesson16;

public class AvgAggregator implements Aggregator<Double, Integer> {

    SumAggregator sumAggregator = new SumAggregator();

    @Override
    public Double aggregate(Integer[] items) {
        double sum = sumAggregator.aggregate(items);
        return sum /items.length;
    }
}
