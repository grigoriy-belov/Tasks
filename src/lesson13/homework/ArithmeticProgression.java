package lesson13.homework;

public class ArithmeticProgression {
    private final int initial;
    private final int step;

    public ArithmeticProgression(int initial, int step) throws ProgressionConfigurationException {
        if (step == 0) throw new ProgressionConfigurationException("Step is 0");
        this.initial = initial;
        this.step = step;
    }

    public int calculate (int n) throws ProgressionConfigurationException {
        if (n <= 0) throw new ProgressionConfigurationException("Wrong number of element");

        int result = initial;
        for (int i = 0; i < n; i++) {
            result += step;
        }
        return result;
    }

}
