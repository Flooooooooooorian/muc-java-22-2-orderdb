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

    @Test
    void testListProducts_thenReturnProductList() {
        //GIVEN
        List<Order> order = new ArrayList<>();
        OrderRepository orderRepository = new OrderRepository(order);

        Product product1 = new Product("Banane", "123");
        List<Product> products = new ArrayList<>();
        products.add(product1);

        ProductRepository productRepository = new ProductRepository(products);

        ShopService shopService = new ShopService(orderRepository, productRepository);

        //WHEN
        List<Product> actual = shopService.listProducts();

        //THEN
        List<Product> expected = new ArrayList<>(products);
        assertEquals(expected, actual);
    }

    @Test
    void testListOrders() {
        //GIVEN
        List<Order> orders = new ArrayList<>();
        OrderRepository orderRepository = new OrderRepository(orders);

        Product product1 = new Product("Banane", "123");
        List<Product> products = new ArrayList<>();
        products.add(product1);

        ProductRepository productRepository = new ProductRepository(products);

        ShopService shopService = new ShopService(orderRepository, productRepository);

        //WHEN
        List<Order> actual = shopService.listOrders();

        //THEN
        List<Order> expected = new ArrayList<>(orders);
        assertEquals(expected, actual);
    }

    @Test
    void testGetOrders() {
        //GIVEN
        Product product1 = new Product("Banane", "123");
        List<Product> products = new ArrayList<>();
        products.add(product1);

        ProductRepository productRepository = new ProductRepository(products);

        List<Order> orders = new ArrayList<>();
        Order order = new Order("123456", products);
        orders.add(order);

        OrderRepository orderRepository = new OrderRepository(orders);

        ShopService shopService = new ShopService(orderRepository, productRepository);

        //WHEN
        Order actual = shopService.getOrder("123456");

        //THEN
        Order expected = new Order("123456", products);
        assertEquals(expected, actual);
    }
}
