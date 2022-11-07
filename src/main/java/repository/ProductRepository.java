package repository;

import model.Product;

import java.util.List;

public class ProductRepository {

    private List<Product> products;

    public ProductRepository(List<Product> products) {
        this.products = products;
    }

    public List<Product> list() {
        return products;
    }
}
