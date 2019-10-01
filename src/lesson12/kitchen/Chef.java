package lesson12.kitchen;

import lesson12.Menu;
import lesson12.ingredients.*;
import lesson12.pizza.Pizza;

public class ChiefCook implements Cook {

    public Pizza.PizzaBuilder cookPizza(Pizza.PizzaBuilder pizzaBuilder, Menu pizza) {
        System.out.println("Adding sauce");
        System.out.println("Adding toppings");
        switch (pizza) {
            case CHEESE_PIZZA:
                pizzaBuilder.createSauce(new MarinaraSauce());
                pizzaBuilder.createCheese(new ParmesanCheese());
                break;
            case PEPPERONI_PIZZA:
                pizzaBuilder.createSauce(new MarinaraSauce());
                pizzaBuilder.createCheese(new ReggianoCheese());
                pizzaBuilder.createVeggies(new Veggies[]{new Garlic(), new Onion(), new Mushroom(), new RedPepper()});
                pizzaBuilder.createPepperoni(new SlicedPepperoni());
                break;
            case VEGGIE_PIZZA:
                pizzaBuilder.createSauce(new TomatoSauce());
                pizzaBuilder.createCheese(new MozzarellaCheese());
                pizzaBuilder.createVeggies(new Veggies[]{new BlackOlives(), new Spinach(), new EggPlant()});
                break;
        }
        return pizzaBuilder;
    }
}
