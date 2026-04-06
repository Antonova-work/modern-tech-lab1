package com.moderntech.ecommerce.payment;
public class WildberriesPayment implements Payment {
    @Override
    public void pay(double amount, PaymentMethod method) {
        System.out.println("[Провайдер: Wildberries] Сумма: " + amount + " руб. Метод: " + method.getClass().getSimpleName());
    }
}