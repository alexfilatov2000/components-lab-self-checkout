package com.shop;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Order {
    // Private
    private Map<Integer, Integer> products;
    private int price;
    private Set<Integer> getAllIds() { return products.keySet(); }

    // Public
    public Order(MainServerConnection msc) {
        products = new HashMap();
        price = 0;
    }

    public void addProduct(int id, MainServerConnection msc) {
        if (products.containsKey(id)) {
            products.put(id, products.get(id) + 1);
        } else {
            products.put(id, 1);
        }
        price += msc.getProduct(id).getPrice();
    }

    public void removeProduct(int id, MainServerConnection msc) {
        if (products.get(id) == 1) {
            products.remove(id);
        } else {
            products.put(id, products.get(id) - 1);
        }
        price -= msc.getProduct(id).getPrice();
    }

    public int getPrice() { return price; }

    /**
     * @return Чек с купленными товарами и
     * стоимостью покупки
     */
    public String getBill(MainServerConnection msc) {
        String result = "";

        //Добавяєм продукти і цену через \n
        Set<Integer> keys = getAllIds();
        for (int id : keys) {
            result += msc.getProduct(id).getName() + " * ";
            result += products.get(id) + ";\n";
        }

        result += "Price: " + price;

        return result;
    }
}
