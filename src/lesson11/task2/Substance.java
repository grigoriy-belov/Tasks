package lesson11.task2;

public interface Substance {
    double DEFAULT_TEMPERATURE = 20;

    double ABSOLUTE_ZERO = -273.15;

    State heatUp(double t);

    double getTemperature();

    String getName();
}
