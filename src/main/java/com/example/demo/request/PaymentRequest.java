package com.example.demo.request;

import com.example.demo.util.PaymentType;

public record PaymentRequest(double amount, PaymentType paymentType) {
}
