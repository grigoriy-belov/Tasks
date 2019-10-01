package lesson12.pizza;

import lesson12.ingredients.*;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggies[] veggies;
    Cheese cheese;
    Pepperoni pepperoni;

    protected Pizza create(Dough dough, Sauce sauce, Cheese cheese, Veggies[] veggies, Pepperoni pepperoni) {
    }

    public String getName() {
        return name;
    }

    public static class PizzaBuilder {
        private Dough dough;
        private Sauce sauce;
        private Veggies[] veggies;
        private Cheese cheese;
        private Pepperoni pepperoni;

        public PizzaBuilder createDough(Dough dough) {
            this.dough = dough;
            return this;
        }
        public PizzaBuilder createSauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }
        public PizzaBuilder createVeggies(Veggies[] veggies) {
            this.veggies = veggies;
            return this;
        }
        public PizzaBuilder createCheese(Cheese cheese) {
            this.cheese = cheese;
            return this;
        }
        public PizzaBuilder createPepperoni(Pepperoni pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }


        Pizza build () {
            return Pizza.create(dough, sauce, veggies, cheese, pepperoni);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("---- " + name + " ----\n");
        if (dough != null) {
            result.append(dough);
            result.append("\n");
        }
        if (sauce != null) {
            result.append(sauce);
            result.append("\n");
        }
        if (cheese != null) {
            result.append(cheese);
            result.append("\n");
        }
        if (veggies != null) {
            for (int i = 0; i < veggies.length; i++) {
                result.append(veggies[i]);
                if (i < veggies.length-1) {
                    result.append(", ");
                }
            }
            result.append("\n");
        }
        if (pepperoni != null) {
            result.append(pepperoni);
            result.append("\n");
        }
        return result.toString();
    }
    }
}
