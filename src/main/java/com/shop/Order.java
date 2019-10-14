package com.shop;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Order {
    // Private
    private final Map<Product, Integer> products;
    private int price;
    private Set<Product> getAllProduct() { return products.keySet(); }

    // Public
    public Order() {
        products = new HashMap();
        price = 0;
    }

    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
        price += product.getPrice();
    }

    public void removeProduct(Product product) {
        if (products.get(product) == 1) {
            products.remove(product);
        } else {
            products.put(product, products.get(product) - 1);
        }
        price -= product.getPrice();
    }

    public int getPrice() { return price; }

    /**
     * @return Чек с купленными товарами и
     * стоимостью покупки
     */
    public String getBill() {
        String result = "";

        //Добавяєм продукти і цену через \n
        Set<Product> keys = getAllProduct();
        for (Product product : keys) {
            result += product.getName() + " * ";
            result += products.get(product) + ";\n";
        }

        result += "Price: " + price;
        return result;
    }
}
