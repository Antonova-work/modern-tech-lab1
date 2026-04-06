package com.moderntech.ecommerce.main;

import com.moderntech.ecommerce.models.*;
import com.moderntech.ecommerce.enums.*;
import com.moderntech.ecommerce.payment.*;
import java.util.*;

public class ECommerceApp {
    public static void main(String[] args) {
        // 1. Каталог
        Product p1 = new Product("1", "Laptop Pro", ProductCategory.LAPTOP, 150000, 5);
        Product p2 = new Product("2", "Phone 15", ProductCategory.SMARTPHONE, 90000, 10);
        Product p3 = new Product("3", "Tablet X", ProductCategory.TABLET, 60000, 7);
        Product p4 = new Product("4", "Camera Z", ProductCategory.CAMERA, 120000, 3);

        System.out.println("=== КАТАЛОГ ТОВАРОВ ===");
        List.of(p1, p2, p3, p4).forEach(p -> System.out.println(p.name() + " (" + p.category() + ") - " + p.price()));

        // 2. Покупатель и корзина
        Customer customer = new Customer("Алексей");
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(p1, 1);
        cart.addItem(p2, 1);

        System.out.println("\n=== КОРЗИНА ===");
        System.out.println("Сумма с НДС: " + cart.calculateTotalWithVAT());

        // 3. Заказ (Checkout)
        List<OrderItem> orderItems = cart.getItems().stream()
                .map(i -> new OrderItem(i.product().name(), i.quantity(), i.product().price())).toList();
        Order order = new Order("ORD-001", orderItems, cart.calculateTotalWithVAT());

        System.out.println("\n=== ОФОРМЛЕНИЕ ЗАКАЗА ===");
        order.setStatus(OrderStatus.CONFIRMED); // Смена статуса
        order.printOrderDetails();

        // 4. Три сценария оплаты
        System.out.println("\n=== ПРОВЕРКА ПЛАТЕЖЕЙ ===");
        double amount = cart.calculateTotalWithVAT();

        new OzonPayment().pay(amount, new CreditCardPayment());
        new WildberriesPayment().pay(amount, new DigitalWalletPayment());
        new OzonPayment().pay(amount, new CashOnDelivery());

        order.setStatus(OrderStatus.DELIVERED); // Итоговая смена статуса
        System.out.println("\nФинальный статус заказа: DELIVERED");
    }
}