package lesson12;

public class ChiefCook implements Cook {

    public Pizza.PizzaBuilder cook(Pizza.PizzaBuilder pizzaBuilder, Menu pizza) {
        System.out.println("Adding sauce");
        System.out.println("Adding toppings");
        switch (pizza) {
            case CHEESE_PIZZA:
                pizzaBuilder.sauce("Marinara sauce");
                pizzaBuilder.toppings("Shredded Parmesan");
                break;
            case PEPPERONI_PIZZA:
                pizzaBuilder.sauce("Marinara sauce");
                pizzaBuilder.toppings("Grated Reggiano Cheese, Sliced Pepperoni, Garlic, Onion, Mushrooms," +
                        " Red Pepper");
                break;
            case VEGGIE_PIZZA:
                pizzaBuilder.sauce("Tomato Sauce");
                pizzaBuilder.toppings("Shredded Mozzarella Cheese, Black Olives, Spinach, Eggplant");
                break;
        }
        return pizzaBuilder;
    }
}
