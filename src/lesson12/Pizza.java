package lesson12;

public class Pizza {
    private final String dough;
    private final String sauce;
    private final String toppings;

    private Pizza(String dough, String sauce, String toppings) {
        this.dough = dough;
        this.sauce = sauce;
        this.toppings = toppings;
    }

    private static Pizza create(String dough, String sauce, String toppings) {
        return new Pizza(dough, sauce, toppings);
    }

    static class PizzaBuilder {
        private String dough;
        private String sauce;
        private String toppings;

        PizzaBuilder dough(String sauce) {
            this.dough = sauce;
            return this;
        }
        PizzaBuilder sauce(String dough) {
            this.sauce = dough;
            return this;
        }
        PizzaBuilder toppings(String toppings) {
            this.toppings = toppings;
            return this;
        }

        Pizza build () {
            return Pizza.create(dough, sauce, toppings);
        }
    }

    @Override
    public String toString() {
        return "Pizza with " +
                dough + ", " +
                sauce + ", " +
                toppings;
    }
}
