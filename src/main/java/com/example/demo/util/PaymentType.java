package com.example.demo.util;

public enum PaymentType {
    CREDIT_CARD("creditCardPayment"),
    PAYPAL("payPalPayment"),
    GOOGLE_PAY("googlePayPayment");

    private final String value;

    PaymentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
