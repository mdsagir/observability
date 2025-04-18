package com.example.demo.factory;

import com.example.demo.service.payment.PaymentService;
import com.example.demo.util.PaymentType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentFactory {
    private final Map<String, PaymentService> paymentMap;

    public PaymentFactory(Map<String, PaymentService> paymentMap) {
        this.paymentMap = paymentMap;
    }

    public PaymentService getPaymentStrategy(PaymentType paymentType) {
        PaymentService strategy = paymentMap.get(paymentType.getValue());
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid payment type: " + paymentType);
        }
        return strategy;
    }
}
