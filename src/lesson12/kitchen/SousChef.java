package lesson12.kitchen;

import lesson12.Menu;
import lesson12.ingredients.MarinaraSauce;
import lesson12.ingredients.ThickCrustDough;
import lesson12.ingredients.ThinCrustDough;
import lesson12.ingredients.TomatoSauce;
import lesson12.Pizza;

public class SousChef implements Cook {

    public Pizza.PizzaBuilder cookPizza(Pizza.PizzaBuilder pizzaBuilder, Menu pizza) {
        pizzaBuilder.definePizzaType(pizza);
        System.out.println("Preparing " + pizza);
        System.out.println("Making dough");
        System.out.println("Making sauce");

        switch (pizza) {
            case CHEESE_PIZZA:
            case PEPPERONI_PIZZA:
                pizzaBuilder.createSauce(new MarinaraSauce());
                pizzaBuilder.createDough(new ThinCrustDough());
                break;
            case VEGGIE_PIZZA:
                pizzaBuilder.createSauce(new TomatoSauce());
                pizzaBuilder.createDough(new ThickCrustDough());
                break;
        }
        return pizzaBuilder;
    }
}
