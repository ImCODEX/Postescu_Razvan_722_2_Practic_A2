package controller;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductController implements ProductControllerInterface{
    private final List<Product> productList;

    public ProductController() {
        this.productList = new ArrayList<>();
    }

    @Override
    public Product addProduct(Integer id, String name, Integer price) {
        Product tempProduct = new Product(id, name, price);
        productList.add(tempProduct);
        return tempProduct;
    }

    @Override
    public void deleteProduct(Integer id) {
        productList.removeIf(product -> Objects.equals(product.getId(), id));
    }

    @Override
    public void updateProduct(Integer id, String name, Integer price) {
        for (Product product:
             productList) {
            if(Objects.equals(product.getId(), id)){
                product.setPrice(price);
                product.setName(name);
            }
        }
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public Product findById(Integer id) {
        for (Product product:
             productList) {
            if(Objects.equals(product.getId(), id)){
                return product;
            }
        }
        return null;
    }
}
