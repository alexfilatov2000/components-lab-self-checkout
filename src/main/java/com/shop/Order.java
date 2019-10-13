package com.shop;

import java.util.Map;
import java.util.HashMap;

public class Order {
    // Private
    private final Map<Product, Integer> products;
    private int price;

    // Public
    public Order() {
        products = new HashMap();
        price = 0;
    }

    public void addProduct(Product product, int amount) {
        amount += products.containsKey(product) ? products.get(product) : 0;
        products.put(product, amount);
    }

    public void removeProduct(Product product, int amount) {
        amount -= products.get(product);
        amount = amount < 0 ? (-1) * amount : 0;
        products.put(product, amount);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public int getPrice() {

        return price;
    }

    /**
     * @return Чек с купленными товарами и
     * стоимостью покупки
     */
    public String getBill() {

    }
}
