import java.util.Map;
import java.util.HashMap;

import com.shop.Admin;
import com.shop.Client;
import com.shop.Product;
import com.shop.CashMachine;

public class Main {
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASSWORD = "admin";

    private static Map<Product, Integer> getProducts() {
        Map<Product, Integer> products = new HashMap();

        products.put(new Product(1, "Хлеб белый", 700), 5);
        products.put(new Product(2, "Хлеб черный", 650), 3);
        products.put(new Product(3, "Рис", 1400), 8);
        products.put(new Product(4, "Гречка", 1200), 12);
        products.put(new Product(5, "Колбаса", 40_000), 2);
        products.put(new Product(6, "Печенье", 700), 5);
        products.put(new Product(7, "Сахар", 10_000), 10);
        products.put(new Product(8, "Чай", 18_000), 3);
        products.put(new Product(9, "Кофе", 60_000), 2);

        return products;
    }

    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine();
        Map<Product, Integer> products = getProducts();

        Client client = new Client(1_000_000); // 1000 UAH
        Admin admin = new Admin(ADMIN_LOGIN, ADMIN_PASSWORD, cashMachine);
    }
}
