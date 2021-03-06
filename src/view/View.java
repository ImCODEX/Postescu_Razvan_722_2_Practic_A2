package view;

import controller.OrderControllerInterface;
import controller.ProductControllerInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private ProductControllerInterface productController;
    private OrderControllerInterface orderController;

    public View(ProductControllerInterface productController, OrderControllerInterface orderController) {
        this.productController = productController;
        this.orderController = orderController;

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
    
    public void run(){
        Scanner scanner = new Scanner(System.in);

        loop:
        while (true) {
            System.out.println("""
                     
                     0. Exit Program \r
                     1. Show all Orders \r
                     2. Show all Products \r
                     3. Add a Order \r
                     4. Add an Product \r
                     5. Remove a Order \r
                     6. Remove an Product \r
                     7. Update a Order \r
                     8. Update an Product \r
                     9. Add Product to Order \r
                     10. Sort desc by Total Price \r
                     11. Filter Orders by specified Product \r
                    """);
            System.out.println("Enter input: ");
            int variant = scanner.nextInt();
            System.out.println("You've entered: " + variant);
            switch (variant) {
                case 0:
                    break loop;
                case 1:
                    showOrders();
                    break;
                case 2:
                    showProducts();
                    break;
                case 3:
                    addOrder();
                    break;
                case 4:
                    addProduct();
                    break;
                case 5:
                    deleteOrder();
                    break;
                case 6:
                    deleteProduct();
                    break;
                case 7:
                    updateOrder();
                    break;
                case 8:
                    updateProduct();
                    break;
                case 9:
                    addProductToOrder();
                    break;
                case 10:
                    sortOrdersByTotalPrice();
                    break;
                case 11:
                    filterOrdersByProduct();
                    break;
            }

        }
    }

    private void filterOrdersByProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Product id:");
        int productId = scanner.nextInt();

        System.out.println(orderController.filterByProduct(productId));
    }

    private void sortOrdersByTotalPrice(){
        System.out.println(orderController.sortOrderByTotalPrice());
    }
    
    private void addProductToOrder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Order id:");
        try {
            int orderId = scanner.nextInt();
            System.out.println("Enter Product id:");
            int productId = scanner.nextInt();
            orderController.addProductToOrder(productId, orderId);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void updateProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You will need to write a few things that represent Product attributes.");
        System.out.println("Enter Product id:");
        try {
            int id = scanner.nextInt();
            System.out.println("Enter Product name:");
            scanner.nextLine(); //throw away the \n not consumed by nextInt()
            String name = scanner.nextLine();
            System.out.println("Enter Product's price:");
            Integer price = scanner.nextInt();

            productController.updateProduct(id, name, price);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void updateOrder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You will need to write a few things that represent Order attributes.");
        System.out.println("Enter Order number:");
        try {
            int orderNumber = scanner.nextInt();
            System.out.println("Enter Order address:");
            scanner.nextLine(); //throw away the \n not consumed by nextInt()
            String address = scanner.nextLine();

            orderController.updateOrder(orderNumber, address,  new ArrayList<>());
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void deleteProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Product id:");
        int id = scanner.nextInt();
        productController.deleteProduct(id);
    }
    
    private void deleteOrder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Order number:");
        int id = scanner.nextInt();
        orderController.deleteOrder(id);
    }
    
    private void addOrder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You will need to write a few things that represent Order attributes.");
        System.out.println("Enter Order number:");
        try {
            int orderNumber = scanner.nextInt();
            System.out.println("Enter Order address:");
            scanner.nextLine(); //throw away the \n not consumed by nextInt()
            String address = scanner.nextLine();

            orderController.addOrder(orderNumber, address,  new ArrayList<>());
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void addProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You will need to write a few things that represent Product attributes.");
        System.out.println("Enter Product id:");
        try {
            int id = scanner.nextInt();
            System.out.println("Enter Product name:");
            scanner.nextLine(); //throw away the \n not consumed by nextInt()
            String name = scanner.nextLine();
            System.out.println("Enter Product's price:");
            Integer price = scanner.nextInt();

            productController.addProduct(id, name, price);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void showProducts() {
        System.out.println(productController.getAll());
    }

    private void showOrders() {
        System.out.println(orderController.getAll());
    }
}
