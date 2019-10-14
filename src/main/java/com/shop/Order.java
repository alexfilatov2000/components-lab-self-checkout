package com.shop;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Order {
    // Private
    private Map<Product, Integer> products;
    private int price;

    // Public
    public Order() {
        products = new HashMap();
        price = 0;
    }

    /**
     * @param product - Продукт для добавления
     * @desc Добавление одного продукта в
     * текущую покупку
     */
    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
        price += product.getPrice();
    }

    /**
     * @param product - Продукт для удалений
     * @desc Удаление одного продукта из
     * текущей покупки
     */
    public void removeProduct(Product product) {
        if (products.get(product) == 1) {
            products.remove(product);
        } else {
            products.put(product, products.get(product) - 1);
        }
        price -= product.getPrice();
    }

    /**
     * Очистить покупку
     */
    public void clearOrder() {
        products = new HashMap();
        price = 0;
    }

    /**
     * @return Логическое значение, пустая
     * ли покупка (есть ли какие-то товары)
     */
    public boolean isEmpty() {
        return products.isEmpty();
    }

    /**
     * @return Чек с купленными товарами и
     * стоимостью покупки
     */
    public String getBill() {
        String result = "";

        //Добавяєм продукти і цену через \n
        Set<Product> keys = products.keySet();
        for (Product prod : keys) {
            result += prod.getName() + " * ";
            result += products.get(prod) + ";\n";
        }

        result += "Price: " + price;

        return result;
    }

    /**
     * @return Сумму покупки
     */
    public int getPrice() { return price; }

    /**
     * @return Map с товарами
     */
    public Map<Product, Integer> getProducts() {
        return new HashMap(products);
    }
}
