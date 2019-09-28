package lesson11.task2;

public class Water extends Substance {

    @Override
    public State heatUp(double t) {
        temperature += t;

        if (temperature < 0) {
            return State.SOLID;
        } else if (temperature < 100) {
            return State.LIQUID;
        } else {
            return State.GAS;
        }
    }
}
