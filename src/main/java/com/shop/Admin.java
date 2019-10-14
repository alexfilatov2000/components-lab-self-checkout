package com.shop;

import com.exception.AuthException;
import com.exception.DatabaseException;

import java.util.Map;

public class Admin {
    //Private
    private final String login;
    private final String password;
    private boolean loggedIn;
    private CashMachine cashMachine;

    //Public
    public Admin(String login, String pass, CashMachine cashMachine) {
        this.login = login;
        this.password = pass;
        this.cashMachine = cashMachine;
        this.loggedIn = false;
    }

    public void logIn(String login, String password) {
        if (login.equalsIgnoreCase(this.login) && password.equalsIgnoreCase(this.password)) {
            loggedIn = true;
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void addProduct(int id, int amount) {
        try {
            cashMachine.addProduct(this, id, amount);
        } catch (AuthException e) {
            e.printStackTrace();
        }
    }

    public void removeProduct(Admin admin, int id, int amount) {
        try {
            cashMachine.removeProduct(this, id, amount);
        } catch (AuthException e) {
            e.printStackTrace();
        }
    }

    public void fill(Admin admin, Map<Product, Integer> fillProducts) {
        try {
            cashMachine.fill(this, fillProducts);
        } catch (AuthException e) {
            e.printStackTrace();
        }
    }
}
