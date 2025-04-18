package com.example.demo.controller;

import com.example.demo.factory.PaymentFactory;
import com.example.demo.request.PaymentRequest;
import com.example.demo.service.payment.PaymentFacade;
import com.example.demo.service.payment.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {

    private final PaymentFacade paymentFacade;

    public PaymentController(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }


    @PostMapping
    public void pay(@RequestBody PaymentRequest paymentRequest) {
        paymentFacade.payment(paymentRequest);
    }
}
