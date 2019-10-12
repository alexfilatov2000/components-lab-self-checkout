package com.shop;

/**
 * host - условный IP главного сервера
 * port - условный открытый порт для
 * соединений с кассовыми аппаратами
 */
public class MainServerConnection {
    // Private
    private final String host;
    private final int port;

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
    }

    // Public
    public static MainServerConnection getConnection() {
        if (connection == null) {
            connection = new MainServerConnection();
        }
        return connection;
    }

    public Product getProduct(int id) {
        // Получение продукта
        return null;
    }

    public int getAmount(int id) {
        // Получаем id
        return 0;
    }

    public void reduce(int id, int amount) {

    }
}
