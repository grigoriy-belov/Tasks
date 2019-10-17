package lesson16;

public class IntSumAggregator extends SumAggregator<Integer> {
    @Override
    Integer sum(Integer x, Integer y) {
        return x != null ? (y != null ? x + y : x) : y;
    }
}
