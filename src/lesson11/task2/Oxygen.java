package lesson11.task2;

public class Oxygen extends Substance {
    @Override
    public State heatUp(double t) {
        temperature += t;

        if (temperature < -218.8) {
            return State.SOLID;
        } else if (temperature < 183) {
            return State.LIQUID;
        } else {
            return State.GAS;
        }
    }
}
