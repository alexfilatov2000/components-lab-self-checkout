package com.shop;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Order {
    // Private
    private Map<Product, Integer> products;
    private int price;

    // Public
    public Order(MainServerConnection msc) {
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

    public Set<Product> getAllProducts() { return products.keySet(); }

    public int getPrice() { return price; }

    public void clearOrder() {
        products = null;
        price = 0;
    }
    /**
     * @return Чек с купленными товарами и
     * стоимостью покупки
     */
    public String getBill() {
        String result = "";

        //Добавяєм продукти і цену через \n
        Set<Product> keys = getAllProducts();
        for (Product prod : keys) {
            result += prod.getName() + " * ";
            result += products.get(prod) + ";\n";
        }

        result += "Price: " + price;

        return result;
    }
}
