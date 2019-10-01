package lesson11.task2;

public class Oxygen extends AbstractSubstance {

    private static final String NAME = "Oxygen";

    private static final double CRYSTALLIZATION_THRESHOLD = -218.8;

    private static final double EVAPORATION_THRESHOLD = -182.98;

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
