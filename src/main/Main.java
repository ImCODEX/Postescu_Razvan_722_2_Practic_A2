package main;

import controller.OrderController;
import controller.OrderControllerInterface;
import controller.ProductController;
import controller.ProductControllerInterface;
import view.View;

public class Main {
    public static void main(String[] args) {
        ProductControllerInterface productController = new ProductController();
        OrderControllerInterface orderController = new OrderController(productController);
        View view = new View(productController, orderController);
        view.run();
    }
}
