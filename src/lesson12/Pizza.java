package lesson12;

import lesson12.ingredients.*;

public class Pizza {
    private Menu pizzaType;
    private Dough dough;
    private Sauce sauce;
    private Veggies[] veggies;
    private Cheese cheese;
    private Pepperoni pepperoni;

    private Pizza(Menu pizzaType, Dough dough, Sauce sauce, Cheese cheese, Veggies[] veggies, Pepperoni pepperoni) {
        this.pizzaType = pizzaType;
        this.dough = dough;
        this.sauce = sauce;
        this.veggies = veggies;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
    }

    private static Pizza create(Menu pizzaType, Dough dough, Sauce sauce, Cheese cheese, Veggies[] veggies, Pepperoni pepperoni) {
        return new Pizza(pizzaType, dough, sauce, cheese, veggies, pepperoni);
    }

    public Menu getPizzaType() {
        return pizzaType;
    }

    public static class PizzaBuilder {
        private Menu pizzaType;
        private Dough dough;
        private Sauce sauce;
        private Veggies[] veggies;
        private Cheese cheese;
        private Pepperoni pepperoni;

        public PizzaBuilder definePizzaType(Menu pizzaType) {
            this.pizzaType = pizzaType;
            return this;
        }
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
            return Pizza.create(pizzaType, dough, sauce, cheese, veggies, pepperoni);
        }
    }

    public String getName() {
        StringBuilder result = new StringBuilder();
        result.append("---- " + pizzaType + " ----\n");
        if (dough != null) {
            result.append(dough.getName());
            result.append("\n");
        }
        if (sauce != null) {
            result.append(sauce.getName());
            result.append("\n");
        }
        if (cheese != null) {
            result.append(cheese.getName());
            result.append("\n");
        }
        if (veggies != null) {
            for (int i = 0; i < veggies.length; i++) {
                result.append(veggies[i].getName());
                if (i < veggies.length-1) {
                    result.append(", ");
                }
            }
            result.append("\n");
        }
        if (pepperoni != null) {
            result.append(pepperoni.getName());
            result.append("\n");
        }
        return result.toString();
    }
}

