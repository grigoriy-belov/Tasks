package lesson12;

import lesson12.kitchen.Chef;
import lesson12.kitchen.Cook;
import lesson12.kitchen.SousChef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Waiter waiter = new Waiter();
        Cook sousChef = new SousChef();
        Cook chef = new Chef();

        restaurant.printMenu();

        Order order = restaurant.getUserOrder();

        List<Menu> orderList = order.getOrderList();

        for (Menu item : orderList) {
            Pizza.PizzaBuilder pizzaBuilder = new Pizza.PizzaBuilder();
            pizzaBuilder = sousChef.cookPizza(pizzaBuilder, item);
            Pizza pizza = chef.cookPizza(pizzaBuilder, item).build();
            waiter.addItemToReadyOrder(pizza);
        }

        System.out.println(waiter.deliverOrder());
    }

    private void printMenu() {
        System.out.println("Menu:");
        for (Menu pizza : Menu.values()) {
            System.out.println((pizza.ordinal()) + 1 + ". " + pizza);
        }
    }

    private Order getUserOrder() {
        System.out.println("Enter pizza number and '0' if you are done");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Menu> orderList = new ArrayList<>();

        int response;
        do {
            response = scanner.nextInt();
            switch (response) {
                case 0:
                    break;
                case 1:
                    orderList.add(Menu.CHEESE_PIZZA);
                    break;
                case 2:
                    orderList.add(Menu.PEPPERONI_PIZZA);
                    break;
                case 3:
                    orderList.add(Menu.VEGGIE_PIZZA);
                    break;
                default:
                    System.err.println("Wrong item number!");
            }
        } while (response != 0);

        return new Order(orderList);
    }
}
