package repository;

import model.Order;
import model.Product;

import java.util.List;

public class OrderRepository {

    private List<Order> orders;
    public OrderRepository(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> list() {
        return orders;
    }

    public Order get(String id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public Order add(Order orderToAdd) {
        orders.add(orderToAdd);
        return orderToAdd;
    }
}
