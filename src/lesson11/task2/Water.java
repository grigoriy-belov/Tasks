package lesson11.task2;

public class Water extends AbstractSubstance {

    private static final String NAME = "Water";

    private static final double CRYSTALLIZATION_THRESHOLD = 0;

    private static final double EVAPORATION_THRESHOLD = 100;

    @Override
    protected double getCrystallizationThreshold() {
        return CRYSTALLIZATION_THRESHOLD;
    }

    @Override
    protected double getEvaporationThreshold() {
        return EVAPORATION_THRESHOLD;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
