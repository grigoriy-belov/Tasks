package lesson12;

import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Waiter waiter = new Waiter();
        Cook doughCook = new DoughCook();
        Cook chief = new ChiefCook();

        Waiter.Order order = restaurant.getUserOrder(waiter);

        Pizza.PizzaBuilder pizzaBuilder = new Pizza.PizzaBuilder();
        pizzaBuilder = doughCook.cook(pizzaBuilder, waiter.getOrder().getPizzaType());
        Pizza pizza = chief.cook(pizzaBuilder, waiter.getOrder().getPizzaType()).build();

        waiter.setPizza(pizza);
        System.out.println(waiter.deliverDish());

    }

    private void printMenu() {
        System.out.println("Choose pizza:");
        for (Menu pizza : Menu.values()) {
            System.out.println(pizza.ordinal() + ". " + pizza);
        }
    }

    private Waiter.Order getUserOrder(Waiter waiter) {
        Waiter.Order order = null;
        while (order == null) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int pizzaNumber = scanner.nextInt();

            order = null;
            switch (pizzaNumber) {
                case 0:
                    order = waiter.new Order(Menu.CHEESE_PIZZA);
                    break;
                case 1:
                    order = waiter.new Order(Menu.PEPPERONI_PIZZA);
                    break;
                case 2:
                    order = waiter.new Order(Menu.VEGGIE_PIZZA);
                    break;
            }
        }
        return order;
    }
}
