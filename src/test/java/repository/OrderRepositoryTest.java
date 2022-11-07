package repository;

import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;

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
}
