package controller;

import model.Order;
import model.Product;

import java.util.List;

public interface OrderControllerInterface {

    /**
     * Adds a new Order
     * @param orderNumber Integer
     * @param address String
     * @param productList List<Product>
     * @return Order
     */
    Order addOrder(Integer orderNumber, String address, List<Product> productList);

    /**
     * Deletes an Order
     * @param orderNumber Integer
     */
    void deleteOrder(Integer orderNumber);

    /**
     * Updates an Order
     * @param orderNumber Integer
     * @param address String
     * @param productList List<Product>
     */
    void updateOrder(Integer orderNumber, String address, List<Product> productList);

    /**
     * Gets all Orders
     * @return List<Order>
     */
    List<Order> getAll();

    /**
     * Finds an Order by a specified Id
     * @param orderNumber Integer
     * @return Order
    */
    Order findById(Integer orderNumber);

    /**
     * Adds a Product to an Order
     * @param productId Integer
     * @param orderNumber Integer
     */
    void addProductToOrder(Integer productId, Integer orderNumber);


    /**
     * Sorts an Order by total Price of Products
     */
    List<Order> sortOrderByTotalPrice();

    /**
     * Filters the Orders by a specified Product Id
     * @param productId Integer
     * @return List<Order>
     */
    List<Order> filterByProduct(Integer productId);

}
