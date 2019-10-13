package com.shop;

public class Admin {
    //Private
    private final String login;
    private final String password;
    //Public
    public Admin(String login, String pass) {
        this.login = login;
        this.password = pass;
    }

    public boolean logLikeAdmim(String login, String password) {
        return (login == this.login && password == this.password);
    }

    public void scan(Product product) {
        //CashMachine.startOrder(product);
    }
}
