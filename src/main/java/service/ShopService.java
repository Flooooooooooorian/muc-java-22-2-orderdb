package service;

import model.Order;
import model.Product;
import repository.OrderRepository;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public ShopService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Product getProduct(String id) {
        return productRepository.get(id);
    }

    public List<Product> listProducts() {
        return productRepository.list();
    }

    public List<Order> listOrders() {
        return orderRepository.list();
    }

    public Order getOrder(String id) {
        return orderRepository.get(id);
    }

    public Order addOrder(String orderId, List<String> ids) {

        List<Product> products = new ArrayList<>();

        for (String id : ids) {
            Product product = productRepository.get(id);
            products.add(product);
        }

        Order newOrder = new Order(orderId, products);
        return orderRepository.add(newOrder);
    }
}
