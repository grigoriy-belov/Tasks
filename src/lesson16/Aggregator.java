package lesson16;

public interface Aggregator<A, T> {

    A aggregate(T[] items);

}
