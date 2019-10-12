package com.shop;

public class Product {
    // Private
    /**
     * price - Цена товара, предположительно
     * будем хранить в int в копейках (для того,
     * чтобы были целые числа). Либо второй
     * вариант можно использовать класс
     * BigDecimal для этих целей
     */
    private int id;
    private String name;
    private int price;

    // Public
    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
