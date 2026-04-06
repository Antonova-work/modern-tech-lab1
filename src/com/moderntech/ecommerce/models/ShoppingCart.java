package com.moderntech.ecommerce.models;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();
    public void addItem(Product product, int quantity) { items.add(new CartItem(product, quantity)); }
    public List<CartItem> getItems() { return items; }
    public double calculateTotalWithVAT() {
        double total = items.stream().mapToDouble(i -> i.product().price() * i.quantity()).sum();
        return total * 1.20;
    }
}