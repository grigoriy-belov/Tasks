package lesson16;

public class AggregatorDemo {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        Character[] sArr = {'a', 'b', 'c', 'd', 'z'};

        CountAggregator<Integer> countAggregator = new CountAggregator<>();
        System.out.println(countAggregator.aggregate(arr));

        SumAggregator sumAggregator = new SumAggregator();
        System.out.println(sumAggregator.aggregate(arr));

        AvgAggregator avgAggregator = new AvgAggregator();
        System.out.println(avgAggregator.aggregate(arr));

        MaxAggregator maxAggregator = new MaxAggregator();
        System.out.println(maxAggregator.aggregate(arr));
        System.out.println(maxAggregator.aggregate(sArr));
    }
}
