package com.shop;

import com.exception.PaymentException;

/**
 * Тут также прописываем классы
 * PaymentSystem, BarcodeScanner
 * (можно и в отдельных файлах, но лучше
 * здесь т.к. они используются только внутри
 * класса CashMachine)
 */

class PaymentSystem {
    // Private
    /**
     * Возможно какие-то поля для
     * оплаты товара
     */

    // Public
    public void pay(int sum) {}
}

class BarcodeScanner {
    // Public
    /**
     * @return Артикул (идентификатор)
     * отсканированного товара
     */
    public int scan(Product product) {
        int id = 0;
        // Сканируем код и получаем id
        return id;
    }
}

public class CashMachine {
    // Private
    private final BarcodeScanner barcodeScanner;
    private final PaymentSystem paymentSystem;
    private final MainServerConnection mainServerConnection;
    private Order currentOrder;

    private void pay() throws PaymentException {}

    // Public
    public CashMachine() {
        barcodeScanner = new BarcodeScanner();
        paymentSystem = new PaymentSystem();
        mainServerConnection = MainServerConnection.getConnection();
    }

    public void startOrder(Product product) {}
    public void endOrder() {}
}
