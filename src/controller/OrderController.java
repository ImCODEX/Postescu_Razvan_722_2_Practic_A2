package controller;

import model.Order;
import model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class OrderController implements OrderControllerInterface {
    private final List<Order> orderList;
    private final ProductControllerInterface productController;

    public OrderController(ProductControllerInterface productController) {
        this.orderList = new ArrayList<>();
        this.productController = productController;
    }

    @Override
    public Order addOrder(Integer orderNumber, String address, List<Product> productList) {
        Order tempOrder = new Order(orderNumber, address, productList);
        orderList.add(tempOrder);
        return tempOrder;
    }

    @Override
    public void deleteOrder(Integer orderNumber) {
        orderList.removeIf(order -> Objects.equals(order.getOrderNumber(), orderNumber));
    }

    @Override
    public void updateOrder(Integer orderNumber, String address, List<Product> productList) {
        for (Order order:
             orderList) {
            if(Objects.equals(order.getOrderNumber(), orderNumber)){
                order.setAddress(address);
                order.setProductList(productList);
            }
        }
    }

    @Override
    public List<Order> getAll() {
        return orderList;

    }

    @Override
    public Order findById(Integer orderNumber) {
        for (Order order:
             orderList) {
            if(Objects.equals(order.getOrderNumber(), orderNumber))
                return order;
        }
        return null;
    }

    @Override
    public void addProductToOrder(Integer productId, Integer orderNumber) {
        orderList.stream()
                .filter(order -> Objects.equals(order.getOrderNumber(), orderNumber))
                .map(order -> {
                    List<Product> productList = order.getProductList();
                    if(productList == null){
                        productList = new ArrayList<>();
                    }
                    productList.add(productController.findById(productId));
                    order.setProductList(productList);
                    return order;
                }).toList();
    }

    @Override
    public List<Order> sortOrderByTotalPrice() {
        return orderList.stream().sorted(Comparator.comparingInt(Order::getTotalPrice).reversed()).toList();
    }

    @Override
    public List<Order> filterByProduct(Integer productId) {
        List<Order> filteredOrderList = new ArrayList<>();
        for (Order order:
             orderList) {
            for (Product product:
                 order.getProductList()) {
                if(product.getId() == productId){
                    filteredOrderList.add(order);
                }
            }
        }
        return filteredOrderList;
    }
}
