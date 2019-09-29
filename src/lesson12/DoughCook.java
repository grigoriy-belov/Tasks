package lesson12;

public class DoughCook implements Cook {

    public Pizza.PizzaBuilder cook(Pizza.PizzaBuilder pizzaBuilder, Menu pizza) {
        System.out.println("Preparing dough");

        switch (pizza) {
            case CHEESE_PIZZA:
            case PEPPERONI_PIZZA:
                pizzaBuilder.dough("Thin crust Dough");
                break;
            case VEGGIE_PIZZA:
                pizzaBuilder.dough("Thick Dough");
                break;
        }
        return pizzaBuilder;
    }
}
