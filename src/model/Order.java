package model;

import java.util.List;
import java.util.Objects;

public class Order {
    private int orderNumber;
    private String address;
    private List<Product> productList;

    public Order(int orderNumber, String address, List<Product> productList) {
        this.orderNumber = orderNumber;
        this.address = address;
        this.productList = productList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", address='" + address + '\'' +
                ", productList=" + productList +
                '}';
    }
}
