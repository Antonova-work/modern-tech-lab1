package com.moderntech.ecommerce.payment;
public class OzonPayment implements Payment {
    @Override
    public void pay(double amount, PaymentMethod method) {
        System.out.println("[Провайдер: OZON] Сумма: " + amount + " руб. Метод: " + method.getClass().getSimpleName());
    }
}