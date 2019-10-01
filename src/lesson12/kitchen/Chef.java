package lesson12.kitchen;

import lesson12.Menu;
import lesson12.ingredients.*;
import lesson12.Pizza;

public class Chef implements Cook {

    public Pizza.PizzaBuilder cookPizza(Pizza.PizzaBuilder pizzaBuilder, Menu pizza) {
        System.out.println("Adding toppings\n");
        switch (pizza) {
            case CHEESE_PIZZA:
                pizzaBuilder.createCheese(new ParmesanCheese());
                break;
            case PEPPERONI_PIZZA:
                pizzaBuilder.createCheese(new ReggianoCheese());
                pizzaBuilder.createVeggies(new Veggies[]{new Garlic(), new Onion(), new Mushroom(), new RedPepper()});
                pizzaBuilder.createPepperoni(new SlicedPepperoni());
                break;
            case VEGGIE_PIZZA:
                pizzaBuilder.createCheese(new MozzarellaCheese());
                pizzaBuilder.createVeggies(new Veggies[]{new BlackOlives(), new Spinach(), new EggPlant()});
                break;
        }
        return pizzaBuilder;
    }
}
