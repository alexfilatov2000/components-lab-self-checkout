package com.shop;

import com.exception.AmountException;
import com.exception.DataBaseException;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * host - условный IP главного сервера
 * port - условный открытый порт для
 * соединений с кассовыми аппаратами
 */
public class    MainServerConnection {
    // Private
    private final String host;
    private final int port;
    private Map<Product, Integer> productsAmount;
    private Map<Integer,Product> products;

    private static MainServerConnection connection;

    /**
     * Конструктор приватный, потому что
     * данный класс должен быть Singletone.
     * Это значит, что может быть лишь один
     * объект данного класса. Поэтому получение
     * объектов будет выполняться через метод
     * getConnection()
     */
    private MainServerConnection() {
        host = "127.0.0.55";
        port = 80;
        products = new HashMap();
        productsAmount = new HashMap();
    }

    private void addProducts() {
        //Адмін добавляє товари
    }

    private void removeProducts() {
        //Адмін удаляє товари
    }

    private void primaryFilling() {
        //Визивається в методі КешМашини accessToAll(), первоначальна настройка касового апарата.
    }

    // Public
    public static MainServerConnection getConnection() {
        if (connection == null) {
            connection = new MainServerConnection();
        }
        return connection;
    }

    public Product getProduct(int id) throws DataBaseException {
        if (products.containsKey(id)) {
            return products.get(id);
        } else {
            throw new DataBaseException();
        }
    }

    public int getAmount(int id) {
        return productsAmount.get(products.get(id)); // получаем amount продукта  по его айдишнику
    }

    public void reduce(Order currentOrder) throws AmountException {
        Set<Product> removeProd = currentOrder.getAllProducts();
        for (Product product : removeProd) {
            if (productsAmount.get(product) == 0) {
                throw new AmountException();
            } else {
                productsAmount.put(product, productsAmount.get(product) - 1);
            }
        }
    }
}
