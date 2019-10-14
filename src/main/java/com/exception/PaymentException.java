package com.exception;

/**
 * Тут можно прописать определенный Exception
 * для неудачной оплаты
 */
public class PaymentException extends Exception {
    public PaymentException() {
        super();
    }

    public PaymentException(String message) {
        super(message);
    }
}