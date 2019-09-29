package lesson12;

public class Waiter {
    private Order order;
    private Pizza pizza;

    class Order {
        private Menu pizzaType;

        public Order(Menu pizzaType) {
            this.pizzaType = pizzaType;
            Waiter.this.order = this;
        }
        public Menu getPizzaType() {
            return pizzaType;
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String deliverDish() {
        return pizza + " is ready. Bon appetite!";
    }
}
