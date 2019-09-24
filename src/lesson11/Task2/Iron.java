package lesson11.Task2;

public class Iron extends Substance {
    @Override
    public State heatUp(double t) {
        temperature += t;

        if (temperature < 1538) {
            return State.SOLID;
        } else if (temperature < 2862) {
            return State.LIQUID;
        } else {
            return State.GAS;
        }
    }
}
