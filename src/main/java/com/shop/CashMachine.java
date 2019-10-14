package com.shop;

import com.exception.AuthException;
import com.exception.DatabaseException;
import com.exception.OrderException;
import com.exception.PaymentException;

import java.util.Map;

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
            throw new PaymentException("Balance is low");
        }
    }
}

class BarcodeScanner {
    // Public
    /**
     * @return Артикул (идентификатор)
     * отсканированного товара
     */
    public Product scan(int id, MainServerConnection msc) throws DatabaseException {
        try {
            msc.getProduct(id);
        } catch (DatabaseException e) {
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

    // Client methods
    public void startOrder(int id) {
        currentOrder = new Order();
    }

    public void endOrder(Client client) throws OrderException {
        if (currentOrder == null) {
            throw new OrderException("No current order. Please call startOrder before ending it");
        }
        try {
            paymentSystem.pay(currentOrder, client);
        } catch (PaymentException e) {
            e.printStackTrace();
        }
        try {
            mainServerConnection.reduce(currentOrder);
        } catch (DatabaseException e) {
            e.printStackTrace();
        } finally {
            currentOrder = null;
        }

        System.out.println(currentOrder.getBill());

        currentOrder.clearOrder();
    }

    public void scan(int id) throws DatabaseException, OrderException {
        if (currentOrder == null) {
            throw new OrderException("No current order. Please call startOrder before scanning");
        }
        currentOrder.addProduct(barcodeScanner.scan(id, mainServerConnection));
    }

    // Admin methods
    public void addProduct(Admin admin, int id, int amount) throws AuthException {
        if (!admin.isLoggedIn()) {
            throw new AuthException();
        }
        try {
            mainServerConnection.addProduct(id, amount);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }

    public void removeProduct(Admin admin, int id, int amount) throws AuthException {
        try {
            mainServerConnection.removeProduct(id, amount);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }

    public void fill(Admin admin, Map<Product, Integer> fillProducts) throws AuthException {
        mainServerConnection.fill(fillProducts);
    }

    public void addPaper(Admin admin) {
        /**
         * Тут код для добавления бумаги.
         * Если есть желание можно будет
         * добавить количество бумаги в текущий
         * момент, при печати чека уменьшать
         * это количество а тут добавлять
         * по-настоящему. Пока эмуляция
         */
        System.out.println("Бумага для чеков была добавлена!");
    }
}
