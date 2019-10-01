package lesson12.kitchen;

import lesson12.Menu;
import lesson12.pizza.Pizza;

public class DoughCook implements Cook {

    public Pizza.PizzaBuilder cook(Pizza.PizzaBuilder pizzaBuilder, Menu pizza) {
        System.out.println("Preparing dough");

        switch (pizza) {
            case CHEESE_PIZZA:
            case PEPPERONI_PIZZA:
                pizzaBuilder.dough("Thin Crust Dough");
                break;
            case VEGGIE_PIZZA:
                pizzaBuilder.dough("Thick Crust Dough");
                break;
        }
        return pizzaBuilder;
    }
}
