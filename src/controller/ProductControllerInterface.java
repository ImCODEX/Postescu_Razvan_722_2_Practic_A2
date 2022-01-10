package controller;

import model.Product;

import java.util.List;

public interface ProductControllerInterface {

    /**
     * Adds a Product
     * @param id Integer
     * @param name String
     * @param price Integer
     * @return Product
     */
    Product addProduct(Integer id, String name, Integer price);

    /**
     * Deletes a Product
     * @param id Integer
     */
    void deleteProduct(Integer id);

    /**
     * Updates a Product
     * @param id Integer
     * @param name String
     * @param price Int
     */
    void updateProduct(Integer id, String name, Integer price);

    /**
     * Get all Products
     * @return List<Product>
     */
    List<Product> getAll();

    /**
     * Finds a Product by a specified id
     * @param id Integer
     * @return Product
     */
    Product findById(Integer id);
}
