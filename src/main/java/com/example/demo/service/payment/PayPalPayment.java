package com.example.demo.service.payment;

import org.springframework.stereotype.Service;

@Service
public class PayPalPayment implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal");
    }
}
