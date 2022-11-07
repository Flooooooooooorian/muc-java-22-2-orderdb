package repository;

import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderRepositoryTest {

    @Test
    void list() {
        //GIVEN
        List<Product> products = List.of(
                new Product("Handy", "123"),
                new Product("Apfel", "567457"));

        List<Order> orders = List.of(
                new Order("123", products),
                new Order("34664236", products));


        OrderRepository orderRepository = new OrderRepository(orders);
        //WHEN


        List<Order> result = orderRepository.list();

        //THEN
        List<Order> expected = List.of(
                new Order("123", products),
                new Order("34664236", products));

        assertEquals(expected, result);
    }

    @Test
    void get() {
        //GIVEN
        List<Product> products = List.of(
                new Product("Handy", "123"),
                new Product("Apfel", "567457"));

        List<Order> orders = List.of(
                new Order("123", products),
                new Order("34664236", products));


        OrderRepository orderRepository = new OrderRepository(orders);

        //WHEN

        Order actual = orderRepository.get("34664236");

        //THEN
        Order expected = new Order("34664236", products);

        assertEquals(expected, actual);
    }

    @Test
    void add() {
        //GIVEN
        List<Product> products = List.of(
                new Product("Handy", "123"),
                new Product("Apfel", "567457"));

        List<Order> orders = new ArrayList<>();

        Order order1 = new Order("123", products);
        orders.add(order1);
        orders.add(new Order("34664236", products));


        OrderRepository orderRepository = new OrderRepository(orders);

        Order orderToAdd = new Order("999", List.of(new Product("Laptop", "457")));

        //WHEN
        Order actual = orderRepository.add(orderToAdd);

        //THEN
        Order expected = new Order("999", List.of(new Product("Laptop", "457")));
        assertEquals(expected, actual);
    }
}
