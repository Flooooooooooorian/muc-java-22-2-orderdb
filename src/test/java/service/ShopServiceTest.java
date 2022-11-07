package service;

import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;
import repository.OrderRepository;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void testGetProduct_whenNonExistingId_thenReturnNull() {
        //GIVEN
        List<Order> order = new ArrayList<>();
        OrderRepository orderRepository = new OrderRepository(order);
        List<Product> products = new ArrayList<>();
        ProductRepository productRepository = new ProductRepository(products);

        ShopService shopService = new ShopService(orderRepository, productRepository);

        //WHEN
        Product actual = shopService.getProduct("nonExistingId");

        //THEN
        Product expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void testGetProduct_whenExistingId_thenReturnProduct() {
        //GIVEN
        List<Order> order = new ArrayList<>();
        OrderRepository orderRepository = new OrderRepository(order);

        Product product1 = new Product("Banane", "123");
        List<Product> products = new ArrayList<>();
        products.add(product1);

        ProductRepository productRepository = new ProductRepository(products);

        ShopService shopService = new ShopService(orderRepository, productRepository);

        //WHEN
        Product actual = shopService.getProduct("123");

        //THEN
        Product expected = new Product("Banane", "123");
        assertEquals(expected, actual);
    }
}
