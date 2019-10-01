package lesson11.task2;

public abstract class AbstractSubstance implements Substance {
    private double t;

    public AbstractSubstance() {
        this(DEFAULT_TEMPERATURE);
    }

    public AbstractSubstance(double t) {
        this.t = t;
    }

    public State heatUp(double t) {
        this.t = Math.max(ABSOLUTE_ZERO, this.t + t);

        if (this.t > getEvaporationThreshold()) {
            return State.GAS;
        } else if (this.t > getCrystallizationThreshold()) {
            return State.LIQUID;
        } else {
            return State.SOLID;
        }
    }

    @Override
    public double getTemperature() {
        return t;
    }

    protected abstract double getCrystallizationThreshold();

    protected abstract double getEvaporationThreshold();
}
