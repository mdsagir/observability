package com.example.demo.service.payment;

import com.example.demo.factory.PaymentFactory;
import com.example.demo.request.PaymentRequest;
import org.springframework.stereotype.Service;


@Service
public class PaymentFacade {
    private final PaymentFactory paymentFactory;

    public PaymentFacade(PaymentFactory paymentFactory) {
        this.paymentFactory = paymentFactory;
    }
    public void payment(PaymentRequest paymentRequest) {
        PaymentService payment = paymentFactory.getPaymentStrategy(paymentRequest.paymentType());
        payment.pay(paymentRequest.amount());
    }
}

