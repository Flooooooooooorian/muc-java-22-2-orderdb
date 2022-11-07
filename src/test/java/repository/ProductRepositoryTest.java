package repository;

import model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void list() {
        //GIVEN
        List<Product> products = List.of(
                new Product("Handy", "123"),
                new Product("Apfel", "567457"));

        ProductRepository productRepository = new ProductRepository(products);

        //WHEN

        List<Product> actual = productRepository.list();

        //THEN
        List<Product> expected = List.of(
                new Product("Handy", "123"),
                new Product("Apfel", "567457"));

        assertEquals(expected, actual);
    }
}
