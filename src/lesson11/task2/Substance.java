package lesson11.task2;

public abstract class Substance {
    public double temperature = 20;

    public abstract State heatUp (double t);

    public double getTemperature() {
        return temperature;
    }
}
