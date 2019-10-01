package lesson12;

import java.util.List;

public class Order {

    private List<Menu> orderList;

    public Order(List<Menu> orderList) {
        this.orderList = orderList;
    }

    public List<Menu> getOrderList() {
        return orderList;
    }
}
