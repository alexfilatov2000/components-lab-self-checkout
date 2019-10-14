package com.shop;

import com.exception.AmountException;
import com.exception.DataBaseException;
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
    public void pay(Order finalOrder,Client client) throws PaymentException {
        if(client.getClientCash()>=finalOrder.getPrice()){
            client.setClientCash(client.getClientCash()-finalOrder.getPrice());
        }
        else {
            throw new PaymentException();
        }
    }
}

class BarcodeScanner {
    // Public
    /**
     * @return Артикул (идентификатор)
     * отсканированного товара
     */
    public Product scan(int id, MainServerConnection msc) throws DataBaseException {
        try {
            msc.getProduct(id);
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
        return msc.getProduct(id);
    }
}

public class CashMachine {
    // Private
    private final BarcodeScanner barcodeScanner;
    private final PaymentSystem paymentSystem;
    private MainServerConnection mainServerConnection;
    private Order currentOrder;

    // Public
    public CashMachine() {
        barcodeScanner = new BarcodeScanner();
        paymentSystem = new PaymentSystem();
        mainServerConnection = MainServerConnection.getConnection();
    }

    public void startOrder(int id) throws DataBaseException {
        currentOrder.addProduct(barcodeScanner.scan(id, mainServerConnection));
    }

    public void accessToAll(Admin admin) {
        //Треба менюшку замутити тут тіпа можна міняти БД, настроювати апарат міняти бумагу і т.д.
    }

    public void endOrder(Client client) {
        try {
            paymentSystem.pay(currentOrder, client);
        } catch (PaymentException e) {
            e.printStackTrace();
        }
        try {
            mainServerConnection.reduce(currentOrder);
        } catch (AmountException e) {
            e.printStackTrace();
        }
        System.out.println(currentOrder.getBill());
        currentOrder.clearOrder();
    }
}
