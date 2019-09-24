package lesson11.Task2;

public class Oxygen extends Substance {
    @Override
    public State heatUp(double t) {
        temperature += t;

        if (temperature < -218.9) {
            return State.SOLID;
        } else if (temperature < 184) {
            return State.LIQUID;
        } else {
            return State.GAS;
        }
    }
}
