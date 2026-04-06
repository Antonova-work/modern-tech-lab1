package com.moderntech.ecommerce.models;
import com.moderntech.ecommerce.enums.OrderStatus;
import java.util.List;

public class Order {
    private String orderId;
    private List<OrderItem> orderItems;
    private OrderStatus status;
    private double totalAmount;

    public Order(String orderId, List<OrderItem> items, double total) {
        this.orderId = orderId;
        this.orderItems = items;
        this.totalAmount = total;
        this.status = OrderStatus.PENDING;
    }
    public void setStatus(OrderStatus status) { this.status = status; }
    public void printOrderDetails() {
        System.out.println("Заказ #" + orderId + " [" + status + "]");
        orderItems.forEach(i -> System.out.println("- " + i.productName() + " x" + i.quantity()));
        System.out.println("Итоговая сумма: " + totalAmount + " руб.");
    }
}