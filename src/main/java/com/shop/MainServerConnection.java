package com.shop;

import com.exception.DatabaseException;
import java.util.Map;
import java.util.HashMap;

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

    private void primaryFill() {
        //Визивається в методі КешМашини accessToAll(), первоначальна настройка касового апарата.
    }

    // Public
    public static MainServerConnection getConnection() {
        if (connection == null) {
            connection = new MainServerConnection();
        }
        return connection;
    }

    public Product getProduct(int id) throws DatabaseException {
        if (products.containsKey(id)) {
            return products.get(id);
        } else {
            throw new DatabaseException();
        }
    }

    public int getAmount(int id) {
        return productsAmount.get(products.get(id)); // получаем amount продукта  по его айдишнику
    }

    public void reduce(Order currentOrder) throws DatabaseException {
        Map<Product, Integer> products = currentOrder.getProducts();
        for (Product product : products.keySet()) {
            int amount = products.get(product);
            if (productsAmount.get(product) < amount) {
                throw new DatabaseException("No such product in the stock");
            } else {
                productsAmount.put(product, productsAmount.get(product) - amount);
            }
        }
    }
}
