package lesson12;

import java.util.ArrayList;
import java.util.List;

public class Waiter {
    private Order order;
    private List<Pizza> readyOrder;

    public Waiter() {
        this.readyOrder = new ArrayList<>();
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void addItemToReadyOrder(Pizza pizza) {
        readyOrder.add(pizza);
    }


    public String deliverOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("Your order is ready. Bon appetite!\n\n");
        for (Pizza pizza : readyOrder) {
            sb.append(pizza.getName()).append("\n");
        }

        return sb.toString();
    }
}
