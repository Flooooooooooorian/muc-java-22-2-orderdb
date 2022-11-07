package repository;

import model.Order;

import java.util.List;

public class OrderRepository {

    private List<Order> orders;
    public OrderRepository(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> list() {
        return orders;
    }
}
