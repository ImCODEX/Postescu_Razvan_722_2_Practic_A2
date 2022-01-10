package Tests;

import controller.OrderController;
import controller.OrderControllerInterface;
import controller.ProductController;
import controller.ProductControllerInterface;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {

    private OrderControllerInterface orderController;
    private ProductControllerInterface productController;


    @org.junit.jupiter.api.BeforeEach
    void setUp(){
        productController = new ProductController();
        orderController = new OrderController(productController);

        productController.addProduct(0, "masa", 100);
        productController.addProduct(1, "tigaie", 50);
        productController.addProduct(2, "mobila", 220);
        productController.addProduct(3, "laptop", 3000);

        orderController.addOrder(0, "bucuresti", new ArrayList<>());
        orderController.addOrder(1, "cluj", new ArrayList<>());
        orderController.addOrder(2, "timisoara", new ArrayList<>());

        orderController.addProductToOrder(0, 0);
        orderController.addProductToOrder(1, 1);
        orderController.addProductToOrder(2, 2);
        orderController.addProductToOrder(3, 2);

    }

    @org.junit.jupiter.api.Test
    void addProductToOrder() {
        orderController.addProductToOrder(0,1);
        assertEquals(2, orderController.findById(1).getProductList().size());
    }

    @org.junit.jupiter.api.Test
    void sortOrderByTotalPrice() {
        assertEquals(3220, orderController.sortOrderByTotalPrice().get(0).getTotalPrice());
    }

    @org.junit.jupiter.api.Test
    void filterByProduct() {
        assertEquals(1, orderController.filterByProduct(1).size());
    }
}