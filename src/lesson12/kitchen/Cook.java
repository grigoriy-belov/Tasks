package lesson12.kitchen;

import lesson12.Menu;
import lesson12.Pizza;

public interface Cook {
    Pizza.PizzaBuilder cookPizza(Pizza.PizzaBuilder pizzaBuilder, Menu pizza);
}
